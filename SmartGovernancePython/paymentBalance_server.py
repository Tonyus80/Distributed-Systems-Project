from __future__ import print_function

import logging
import socket
import time
from asyncio import Event
from concurrent import futures
from zeroconf import ServiceInfo, Zeroconf, ServiceBrowser, ServiceStateChange

import payment_pb2
import payment_pb2_grpc
import grpc


class AmountTotalDueServicer(payment_pb2_grpc.AmountTotalDueServicer):
    # server getting balance request and sending back response
    #def checkTaxBalance(self, request, context):
    def checkAmount(self, request, context):
        print("Request: " + request.text)
        response = payment_pb2.PaymentResponse()
        response.value = 'User tax  amount is 250 euro.'
        return response

    # server receives stream of requests, sends back stream of responses
    def confirmTaxPayments(self, request_iterator, context):
        print('Request to confirm tax payment date')

        for taxPayments in request_iterator:
            yield taxPayments



    def Listoverduepayer(self, request, context):
        print("Server received staff request: " + request.ask)

        staff = ["Sam", "Lisa", "Jay", "John", "Shiobhan", "Jim", "Sandra", "Mark"]
        for x in staff:
            #print(x)
            yield security_pb2.ListResponse(ans=x)
            time.sleep(2)
# REGISTERING SERVICE WITH ZEROCONFIG

def register_service():
    # adding events for when a service is added or removed
    service_added = Event()
    service_removed = Event()

    # setting service type and name
    type_ = "_payment._tcp.local."
    registration_name = "payment_server.%s" % type_

    def on_service_state_change(zeroconf, service_type, state_change, name):
        if name == registration_name:
            if state_change is ServiceStateChange.Added:
                service_added.set()
                print('Service added')
            elif state_change is ServiceStateChange.Removed:
                service_removed.set()
                print('Service removed')

    zeroconf_browser = Zeroconf()
    browser = ServiceBrowser(zeroconf_browser, type_, [on_service_state_change])

    zeroconf_registrar = Zeroconf()
    desc = 'check payments are due'
    info = ServiceInfo(
        # specifying service info: type, name, localhost, port
        type_, registration_name,
        socket.inet_aton("192.168.0.0"), 50074, 0, 0,
        desc, ".local.")
    zeroconf_registrar.register_service(info)

    try:
        # try catch for error handling when service is added
        service_added.wait(1)
        assert service_added.is_set()

    finally:
        zeroconf_registrar.close()
        browser.cancel()
        zeroconf_browser.close()





# starting server on specified port
def serve():
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))

    payment_pb2_grpc.add_AmountTotalDueServicer_to_server(
        AmountTotalDueServicer(), server)

    print('Starting server. Listening on port 50074.')
    server.add_insecure_port('[::]:50074')
    server.start()
    server.wait_for_termination()

    try:
        while True:
            time.sleep(86400)
    except KeyboardInterrupt:
        server.stop(0)
        



if __name__ == '__main__':
    logging.basicConfig()
    # register_service()
    serve()

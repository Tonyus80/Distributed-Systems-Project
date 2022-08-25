from __future__ import print_function

import logging

import payment_pb2
import payment_pb2_grpc
import grpc


# request to get Tax balance
def get_tax_balance():
    # add channel and specify port
    # request send to server to check balance
    # when server responds, print responsepip3
    channel = grpc.insecure_channel('localhost:50074')
    stub = payment_pb2_grpc.AmountTotalDueStub(channel)
    request = payment_pb2.PaymentRequest(
        text='Retrieve user payments balance.')
    response = stub.checkAmount(request)
    print(response.value)


# request with Tax_requests list as stream of requests to server
def make_tax_payments_request(payments):
    return payment_pb2.TaxPaymentsRequest(
        taxPayments=payments
    )


# list of payment dates to send to server as stream
payment_requests = [
    make_tax_payments_request('1/2/22'),
    make_tax_payments_request('1/3/22'),
    make_tax_payments_request('1/4/22'),
    make_tax_payments_request('1/5/22'),
    make_tax_payments_request('1/6/22'),
]


# sending server each request in list using for loop
def generate_payment_requests():
    payment_requests
    for payment_request in payment_requests:
        print("Sending the tax requests: %s" % payment_request.taxPayments)
        yield payment_request


# servers response to requests sent
def send_request(stub):
    requests = stub.confirmTaxPayments(generate_payment_requests())
    for request in requests:
        print("\nServer response: Yes, there is a payment due on %s" % request.taxPayments)


def run_payment_confirmation():
    with grpc.insecure_channel('localhost:50074') as channel:
        stub = payment_pb2_grpc.AmountTotalDueStub(channel)
        send_request(stub)


if __name__ == '__main__':
    logging.basicConfig()
    get_tax_balance()
    run_payment_confirmation()

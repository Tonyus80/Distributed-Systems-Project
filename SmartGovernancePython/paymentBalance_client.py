from __future__ import print_function

import logging
import time

import payment_pb2
import payment_pb2_grpc
import grpc


def list_overdue_payer(stub):
    print("Requesting list of overdue payer ")

    features = stub.Listoverduepayer(payment_pb2.ListRequest(ask='overdue payer list'))
    print("Client received")
    for feature in features:
        print("Name: %s" % feature.ans)


# request to get Tax balance
def get_tax_balance():
    # adding channel and port
    #  send request to server to check due date
    # when server responds, print response
    channel = grpc.insecure_channel('localhost:50074')
    stub = payment_pb2_grpc.AmountTotalDueStub(channel)###ORG
    ####stub = payment_pb2_grpc.PaymentBalanceStub(channel)
    request = payment_pb2.PaymentRequest(
        text='Retrieve user payments balance.')
        #taxPayments='Retrieve user payments balance.')
    response = stub.checkAmount(request)
    print(response.value)


# request with Tax_requests list as stream of requests to server
def make_tax_payments_request(payments):
    return payment_pb2.TaxPaymentsRequest(
        taxPayments=payments

    )

##sources https://www.velotio.com/engineering-blog/grpc-implementation-using-python
# Array list of payment dates to send to server as stream
payment_requests = [
    make_tax_payments_request('1/5/22'),
    make_tax_payments_request('1/6/22'),
    make_tax_payments_request('1/7/22'),
    make_tax_payments_request('1/8/22'),
    make_tax_payments_request('1/9/22'),
]


# sending server each request in list using for loop
def generate_payment_requests():
    #payment_requests
    payment_requests = [
        make_tax_payments_request('1/5/22'),
        make_tax_payments_request('1/6/22'),
        make_tax_payments_request('1/7/22'),
        make_tax_payments_request('1/8/22'),
        make_tax_payments_request('1/9/22'),
    ]

    #test

    for payment_request in payment_requests:
        print("Sending the tax requests: %s" % payment_request.taxPayments)
        yield payment_request



# servers response to requests sent
def send_request(stub):
    requests = stub.confirmTaxPayments(generate_payment_requests())
    for request in requests:
        print("\nServer response: there is a payment due on %s" % request.taxPayments)



def run_payment_confirmation():
    with grpc.insecure_channel('localhost:50074') as channel:
        stub = payment_pb2_grpc.AmountTotalDueStub(channel)
        send_request(stub)
        time.sleep(2)
        print("-------------- Sever Side Streaming --------------")
        list_overdue_payer(stub)


if __name__ == '__main__':
    logging.basicConfig()
    get_tax_balance()
    run_payment_confirmation()

# Generated by the gRPC Python protocol compiler plugin. DO NOT EDIT!
"""Client and server classes corresponding to protobuf-defined services."""
import grpc

import payment_pb2 as payment__pb2


class AmountTotalDueStub(object):
    """Missing associated documentation comment in .proto file."""

    def __init__(self, channel):
        """Constructor.

        Args:
            channel: A grpc.Channel.
        """
        self.checkAmount = channel.unary_unary(
                '/paymentServices.AmountTotalDue/checkAmount',
                request_serializer=payment__pb2.PaymentRequest.SerializeToString,
                response_deserializer=payment__pb2.PaymentResponse.FromString,
                )
        self.confirmTaxPayments = channel.stream_stream(
                '/paymentServices.AmountTotalDue/confirmTaxPayments',
                request_serializer=payment__pb2.TaxPaymentsRequest.SerializeToString,
                response_deserializer=payment__pb2.TaxPaymentsResponse.FromString,
                )


class AmountTotalDueServicer(object):
    """Missing associated documentation comment in .proto file."""

    def checkAmount(self, request, context):
        """unary RPC
        """
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def confirmTaxPayments(self, request_iterator, context):
        """bidirection RPC - send stream of next tax payments
        """
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')


def add_AmountTotalDueServicer_to_server(servicer, server):
    rpc_method_handlers = {
            'checkAmount': grpc.unary_unary_rpc_method_handler(
                    servicer.checkAmount,
                    request_deserializer=payment__pb2.PaymentRequest.FromString,
                    response_serializer=payment__pb2.PaymentResponse.SerializeToString,
            ),
            'confirmTaxPayments': grpc.stream_stream_rpc_method_handler(
                    servicer.confirmTaxPayments,
                    request_deserializer=payment__pb2.TaxPaymentsRequest.FromString,
                    response_serializer=payment__pb2.TaxPaymentsResponse.SerializeToString,
            ),
    }
    generic_handler = grpc.method_handlers_generic_handler(
            'paymentServices.AmountTotalDue', rpc_method_handlers)
    server.add_generic_rpc_handlers((generic_handler,))


 # This class is part of an EXPERIMENTAL API.
class AmountTotalDue(object):
    """Missing associated documentation comment in .proto file."""

    @staticmethod
    def checkAmount(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/paymentServices.AmountTotalDue/checkAmount',
            payment__pb2.PaymentRequest.SerializeToString,
            payment__pb2.PaymentResponse.FromString,
            options, channel_credentials,
            insecure, call_credentials, compression, wait_for_ready, timeout, metadata)

    @staticmethod
    def confirmTaxPayments(request_iterator,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.stream_stream(request_iterator, target, '/paymentServices.AmountTotalDue/confirmTaxPayments',
            payment__pb2.TaxPaymentsRequest.SerializeToString,
            payment__pb2.TaxPaymentsResponse.FromString,
            options, channel_credentials,
            insecure, call_credentials, compression, wait_for_ready, timeout, metadata)
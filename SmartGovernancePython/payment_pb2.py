# -*- coding: utf-8 -*-
# Generated by the protocol buffer compiler.  DO NOT EDIT!
# source: payment.proto
"""Generated protocol buffer code."""
from google.protobuf import descriptor as _descriptor
from google.protobuf import message as _message
from google.protobuf import reflection as _reflection
from google.protobuf import symbol_database as _symbol_database
# @@protoc_insertion_point(imports)

_sym_db = _symbol_database.Default()




DESCRIPTOR = _descriptor.FileDescriptor(
  name='payment.proto',
  package='paymentServices',
  syntax='proto3',
  serialized_options=b'\n\021taxPaymentServiceB\030AmountBalanceServiceImplP\001\242\002\003BBS',
  create_key=_descriptor._internal_create_key,
  serialized_pb=b'\n\rpayment.proto\x12\x0fpaymentServices\"\x1e\n\x0ePaymentRequest\x12\x0c\n\x04text\x18\x01 \x01(\t\" \n\x0fPaymentResponse\x12\r\n\x05value\x18\x01 \x01(\t\")\n\x12TaxPaymentsRequest\x12\x13\n\x0btaxPayments\x18\x01 \x01(\t\"*\n\x13TaxPaymentsResponse\x12\x13\n\x0btaxPayments\x18\x01 \x01(\t2\xc7\x01\n\x0e\x41mountTotalDue\x12P\n\x0b\x63heckAmount\x12\x1f.paymentServices.PaymentRequest\x1a .paymentServices.PaymentResponse\x12\x63\n\x12\x63onfirmTaxPayments\x12#.paymentServices.TaxPaymentsRequest\x1a$.paymentServices.TaxPaymentsResponse(\x01\x30\x01\x42\x35\n\x11taxPaymentServiceB\x18\x41mountBalanceServiceImplP\x01\xa2\x02\x03\x42\x42Sb\x06proto3'
)




_PAYMENTREQUEST = _descriptor.Descriptor(
  name='PaymentRequest',
  full_name='paymentServices.PaymentRequest',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  create_key=_descriptor._internal_create_key,
  fields=[
    _descriptor.FieldDescriptor(
      name='text', full_name='paymentServices.PaymentRequest.text', index=0,
      number=1, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=b"".decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=34,
  serialized_end=64,
)


_PAYMENTRESPONSE = _descriptor.Descriptor(
  name='PaymentResponse',
  full_name='paymentServices.PaymentResponse',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  create_key=_descriptor._internal_create_key,
  fields=[
    _descriptor.FieldDescriptor(
      name='value', full_name='paymentServices.PaymentResponse.value', index=0,
      number=1, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=b"".decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=66,
  serialized_end=98,
)


_TAXPAYMENTSREQUEST = _descriptor.Descriptor(
  name='TaxPaymentsRequest',
  full_name='paymentServices.TaxPaymentsRequest',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  create_key=_descriptor._internal_create_key,
  fields=[
    _descriptor.FieldDescriptor(
      name='taxPayments', full_name='paymentServices.TaxPaymentsRequest.taxPayments', index=0,
      number=1, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=b"".decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=100,
  serialized_end=141,
)


_TAXPAYMENTSRESPONSE = _descriptor.Descriptor(
  name='TaxPaymentsResponse',
  full_name='paymentServices.TaxPaymentsResponse',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  create_key=_descriptor._internal_create_key,
  fields=[
    _descriptor.FieldDescriptor(
      name='taxPayments', full_name='paymentServices.TaxPaymentsResponse.taxPayments', index=0,
      number=1, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=b"".decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=143,
  serialized_end=185,
)

DESCRIPTOR.message_types_by_name['PaymentRequest'] = _PAYMENTREQUEST
DESCRIPTOR.message_types_by_name['PaymentResponse'] = _PAYMENTRESPONSE
DESCRIPTOR.message_types_by_name['TaxPaymentsRequest'] = _TAXPAYMENTSREQUEST
DESCRIPTOR.message_types_by_name['TaxPaymentsResponse'] = _TAXPAYMENTSRESPONSE
_sym_db.RegisterFileDescriptor(DESCRIPTOR)

PaymentRequest = _reflection.GeneratedProtocolMessageType('PaymentRequest', (_message.Message,), {
  'DESCRIPTOR' : _PAYMENTREQUEST,
  '__module__' : 'payment_pb2'
  # @@protoc_insertion_point(class_scope:paymentServices.PaymentRequest)
  })
_sym_db.RegisterMessage(PaymentRequest)

PaymentResponse = _reflection.GeneratedProtocolMessageType('PaymentResponse', (_message.Message,), {
  'DESCRIPTOR' : _PAYMENTRESPONSE,
  '__module__' : 'payment_pb2'
  # @@protoc_insertion_point(class_scope:paymentServices.PaymentResponse)
  })
_sym_db.RegisterMessage(PaymentResponse)

TaxPaymentsRequest = _reflection.GeneratedProtocolMessageType('TaxPaymentsRequest', (_message.Message,), {
  'DESCRIPTOR' : _TAXPAYMENTSREQUEST,
  '__module__' : 'payment_pb2'
  # @@protoc_insertion_point(class_scope:paymentServices.TaxPaymentsRequest)
  })
_sym_db.RegisterMessage(TaxPaymentsRequest)

TaxPaymentsResponse = _reflection.GeneratedProtocolMessageType('TaxPaymentsResponse', (_message.Message,), {
  'DESCRIPTOR' : _TAXPAYMENTSRESPONSE,
  '__module__' : 'payment_pb2'
  # @@protoc_insertion_point(class_scope:paymentServices.TaxPaymentsResponse)
  })
_sym_db.RegisterMessage(TaxPaymentsResponse)


DESCRIPTOR._options = None

_AMOUNTTOTALDUE = _descriptor.ServiceDescriptor(
  name='AmountTotalDue',
  full_name='paymentServices.AmountTotalDue',
  file=DESCRIPTOR,
  index=0,
  serialized_options=None,
  create_key=_descriptor._internal_create_key,
  serialized_start=188,
  serialized_end=387,
  methods=[
  _descriptor.MethodDescriptor(
    name='checkAmount',
    full_name='paymentServices.AmountTotalDue.checkAmount',
    index=0,
    containing_service=None,
    input_type=_PAYMENTREQUEST,
    output_type=_PAYMENTRESPONSE,
    serialized_options=None,
    create_key=_descriptor._internal_create_key,
  ),
  _descriptor.MethodDescriptor(
    name='confirmTaxPayments',
    full_name='paymentServices.AmountTotalDue.confirmTaxPayments',
    index=1,
    containing_service=None,
    input_type=_TAXPAYMENTSREQUEST,
    output_type=_TAXPAYMENTSRESPONSE,
    serialized_options=None,
    create_key=_descriptor._internal_create_key,
  ),
])
_sym_db.RegisterServiceDescriptor(_AMOUNTTOTALDUE)

DESCRIPTOR.services_by_name['AmountTotalDue'] = _AMOUNTTOTALDUE

# @@protoc_insertion_point(module_scope)

// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: payment.proto

package taxPaymentService;

public final class PaymentBalanceServiceImpl {
  private PaymentBalanceServiceImpl() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_paymentServices_PaymentRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_paymentServices_PaymentRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_paymentServices_PaymentResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_paymentServices_PaymentResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_paymentServices_TaxPaymentsRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_paymentServices_TaxPaymentsRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_paymentServices_TaxPaymentsResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_paymentServices_TaxPaymentsResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\rpayment.proto\022\017paymentServices\"\"\n\016Paym" +
      "entRequest\022\020\n\010totalDue\030\001 \001(\t\"#\n\017PaymentR" +
      "esponse\022\020\n\010totalDue\030\001 \001(\t\")\n\022TaxPayments" +
      "Request\022\023\n\013taxPayments\030\001 \001(\t\"*\n\023TaxPayme" +
      "ntsResponse\022\023\n\013taxPayments\030\001 \001(\t2\307\001\n\016Amo" +
      "untTotalDue\022P\n\013checkAmount\022\037.paymentServ" +
      "ices.PaymentRequest\032 .paymentServices.Pa" +
      "ymentResponse\022c\n\022confirmTaxPayments\022#.pa" +
      "ymentServices.TaxPaymentsRequest\032$.payme" +
      "ntServices.TaxPaymentsResponse(\0010\001B0\n\021ta" +
      "xPaymentServiceB\031PaymentBalanceServiceIm" +
      "plP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_paymentServices_PaymentRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_paymentServices_PaymentRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_paymentServices_PaymentRequest_descriptor,
        new java.lang.String[] { "TotalDue", });
    internal_static_paymentServices_PaymentResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_paymentServices_PaymentResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_paymentServices_PaymentResponse_descriptor,
        new java.lang.String[] { "TotalDue", });
    internal_static_paymentServices_TaxPaymentsRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_paymentServices_TaxPaymentsRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_paymentServices_TaxPaymentsRequest_descriptor,
        new java.lang.String[] { "TaxPayments", });
    internal_static_paymentServices_TaxPaymentsResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_paymentServices_TaxPaymentsResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_paymentServices_TaxPaymentsResponse_descriptor,
        new java.lang.String[] { "TaxPayments", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
package taxPaymentService;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: payment.proto")
public final class AmountTotalDueGrpc {

  private AmountTotalDueGrpc() {}

  public static final String SERVICE_NAME = "paymentServices.AmountTotalDue";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<taxPaymentService.PaymentRequest,
      taxPaymentService.PaymentResponse> getCheckAmountMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "checkAmount",
      requestType = taxPaymentService.PaymentRequest.class,
      responseType = taxPaymentService.PaymentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<taxPaymentService.PaymentRequest,
      taxPaymentService.PaymentResponse> getCheckAmountMethod() {
    io.grpc.MethodDescriptor<taxPaymentService.PaymentRequest, taxPaymentService.PaymentResponse> getCheckAmountMethod;
    if ((getCheckAmountMethod = AmountTotalDueGrpc.getCheckAmountMethod) == null) {
      synchronized (AmountTotalDueGrpc.class) {
        if ((getCheckAmountMethod = AmountTotalDueGrpc.getCheckAmountMethod) == null) {
          AmountTotalDueGrpc.getCheckAmountMethod = getCheckAmountMethod = 
              io.grpc.MethodDescriptor.<taxPaymentService.PaymentRequest, taxPaymentService.PaymentResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "paymentServices.AmountTotalDue", "checkAmount"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  taxPaymentService.PaymentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  taxPaymentService.PaymentResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new AmountTotalDueMethodDescriptorSupplier("checkAmount"))
                  .build();
          }
        }
     }
     return getCheckAmountMethod;
  }

  private static volatile io.grpc.MethodDescriptor<taxPaymentService.ListRequest,
      taxPaymentService.ListResponse> getListoverduepayerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Listoverduepayer",
      requestType = taxPaymentService.ListRequest.class,
      responseType = taxPaymentService.ListResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<taxPaymentService.ListRequest,
      taxPaymentService.ListResponse> getListoverduepayerMethod() {
    io.grpc.MethodDescriptor<taxPaymentService.ListRequest, taxPaymentService.ListResponse> getListoverduepayerMethod;
    if ((getListoverduepayerMethod = AmountTotalDueGrpc.getListoverduepayerMethod) == null) {
      synchronized (AmountTotalDueGrpc.class) {
        if ((getListoverduepayerMethod = AmountTotalDueGrpc.getListoverduepayerMethod) == null) {
          AmountTotalDueGrpc.getListoverduepayerMethod = getListoverduepayerMethod = 
              io.grpc.MethodDescriptor.<taxPaymentService.ListRequest, taxPaymentService.ListResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "paymentServices.AmountTotalDue", "Listoverduepayer"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  taxPaymentService.ListRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  taxPaymentService.ListResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new AmountTotalDueMethodDescriptorSupplier("Listoverduepayer"))
                  .build();
          }
        }
     }
     return getListoverduepayerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<taxPaymentService.TaxPaymentsRequest,
      taxPaymentService.TaxPaymentsResponse> getConfirmTaxPaymentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "confirmTaxPayments",
      requestType = taxPaymentService.TaxPaymentsRequest.class,
      responseType = taxPaymentService.TaxPaymentsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<taxPaymentService.TaxPaymentsRequest,
      taxPaymentService.TaxPaymentsResponse> getConfirmTaxPaymentsMethod() {
    io.grpc.MethodDescriptor<taxPaymentService.TaxPaymentsRequest, taxPaymentService.TaxPaymentsResponse> getConfirmTaxPaymentsMethod;
    if ((getConfirmTaxPaymentsMethod = AmountTotalDueGrpc.getConfirmTaxPaymentsMethod) == null) {
      synchronized (AmountTotalDueGrpc.class) {
        if ((getConfirmTaxPaymentsMethod = AmountTotalDueGrpc.getConfirmTaxPaymentsMethod) == null) {
          AmountTotalDueGrpc.getConfirmTaxPaymentsMethod = getConfirmTaxPaymentsMethod = 
              io.grpc.MethodDescriptor.<taxPaymentService.TaxPaymentsRequest, taxPaymentService.TaxPaymentsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "paymentServices.AmountTotalDue", "confirmTaxPayments"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  taxPaymentService.TaxPaymentsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  taxPaymentService.TaxPaymentsResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new AmountTotalDueMethodDescriptorSupplier("confirmTaxPayments"))
                  .build();
          }
        }
     }
     return getConfirmTaxPaymentsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AmountTotalDueStub newStub(io.grpc.Channel channel) {
    return new AmountTotalDueStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AmountTotalDueBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new AmountTotalDueBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AmountTotalDueFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new AmountTotalDueFutureStub(channel);
  }

  /**
   */
  public static abstract class AmountTotalDueImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * unary RPC
     * </pre>
     */
    public void checkAmount(taxPaymentService.PaymentRequest request,
        io.grpc.stub.StreamObserver<taxPaymentService.PaymentResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCheckAmountMethod(), responseObserver);
    }

    /**
     * <pre>
     *server side streaming
     * </pre>
     */
    public void listoverduepayer(taxPaymentService.ListRequest request,
        io.grpc.stub.StreamObserver<taxPaymentService.ListResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getListoverduepayerMethod(), responseObserver);
    }

    /**
     * <pre>
     * bidirection RPC - send stream of next tax payments
     * </pre>
     */
    public io.grpc.stub.StreamObserver<taxPaymentService.TaxPaymentsRequest> confirmTaxPayments(
        io.grpc.stub.StreamObserver<taxPaymentService.TaxPaymentsResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getConfirmTaxPaymentsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCheckAmountMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                taxPaymentService.PaymentRequest,
                taxPaymentService.PaymentResponse>(
                  this, METHODID_CHECK_AMOUNT)))
          .addMethod(
            getListoverduepayerMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                taxPaymentService.ListRequest,
                taxPaymentService.ListResponse>(
                  this, METHODID_LISTOVERDUEPAYER)))
          .addMethod(
            getConfirmTaxPaymentsMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                taxPaymentService.TaxPaymentsRequest,
                taxPaymentService.TaxPaymentsResponse>(
                  this, METHODID_CONFIRM_TAX_PAYMENTS)))
          .build();
    }
  }

  /**
   */
  public static final class AmountTotalDueStub extends io.grpc.stub.AbstractStub<AmountTotalDueStub> {
    private AmountTotalDueStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AmountTotalDueStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AmountTotalDueStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AmountTotalDueStub(channel, callOptions);
    }

    /**
     * <pre>
     * unary RPC
     * </pre>
     */
    public void checkAmount(taxPaymentService.PaymentRequest request,
        io.grpc.stub.StreamObserver<taxPaymentService.PaymentResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCheckAmountMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *server side streaming
     * </pre>
     */
    public void listoverduepayer(taxPaymentService.ListRequest request,
        io.grpc.stub.StreamObserver<taxPaymentService.ListResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getListoverduepayerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * bidirection RPC - send stream of next tax payments
     * </pre>
     */
    public io.grpc.stub.StreamObserver<taxPaymentService.TaxPaymentsRequest> confirmTaxPayments(
        io.grpc.stub.StreamObserver<taxPaymentService.TaxPaymentsResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getConfirmTaxPaymentsMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class AmountTotalDueBlockingStub extends io.grpc.stub.AbstractStub<AmountTotalDueBlockingStub> {
    private AmountTotalDueBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AmountTotalDueBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AmountTotalDueBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AmountTotalDueBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * unary RPC
     * </pre>
     */
    public taxPaymentService.PaymentResponse checkAmount(taxPaymentService.PaymentRequest request) {
      return blockingUnaryCall(
          getChannel(), getCheckAmountMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *server side streaming
     * </pre>
     */
    public java.util.Iterator<taxPaymentService.ListResponse> listoverduepayer(
        taxPaymentService.ListRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getListoverduepayerMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class AmountTotalDueFutureStub extends io.grpc.stub.AbstractStub<AmountTotalDueFutureStub> {
    private AmountTotalDueFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AmountTotalDueFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AmountTotalDueFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AmountTotalDueFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * unary RPC
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<taxPaymentService.PaymentResponse> checkAmount(
        taxPaymentService.PaymentRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCheckAmountMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CHECK_AMOUNT = 0;
  private static final int METHODID_LISTOVERDUEPAYER = 1;
  private static final int METHODID_CONFIRM_TAX_PAYMENTS = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AmountTotalDueImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AmountTotalDueImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CHECK_AMOUNT:
          serviceImpl.checkAmount((taxPaymentService.PaymentRequest) request,
              (io.grpc.stub.StreamObserver<taxPaymentService.PaymentResponse>) responseObserver);
          break;
        case METHODID_LISTOVERDUEPAYER:
          serviceImpl.listoverduepayer((taxPaymentService.ListRequest) request,
              (io.grpc.stub.StreamObserver<taxPaymentService.ListResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CONFIRM_TAX_PAYMENTS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.confirmTaxPayments(
              (io.grpc.stub.StreamObserver<taxPaymentService.TaxPaymentsResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class AmountTotalDueBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AmountTotalDueBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return taxPaymentService.PaymentBalanceServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AmountTotalDue");
    }
  }

  private static final class AmountTotalDueFileDescriptorSupplier
      extends AmountTotalDueBaseDescriptorSupplier {
    AmountTotalDueFileDescriptorSupplier() {}
  }

  private static final class AmountTotalDueMethodDescriptorSupplier
      extends AmountTotalDueBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AmountTotalDueMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (AmountTotalDueGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AmountTotalDueFileDescriptorSupplier())
              .addMethod(getCheckAmountMethod())
              .addMethod(getListoverduepayerMethod())
              .addMethod(getConfirmTaxPaymentsMethod())
              .build();
        }
      }
    }
    return result;
  }
}

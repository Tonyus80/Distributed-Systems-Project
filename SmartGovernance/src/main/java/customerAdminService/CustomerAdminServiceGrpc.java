package customerAdminService;

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
    comments = "Source: customerAdmin.proto")
public final class CustomerAdminServiceGrpc {

  private CustomerAdminServiceGrpc() {}

  public static final String SERVICE_NAME = "CustomerAdminService.CustomerAdminService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<customerAdminService.RegisterRequest,
      customerAdminService.RegisterResponse> getRegisterCustomersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "registerCustomers",
      requestType = customerAdminService.RegisterRequest.class,
      responseType = customerAdminService.RegisterResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<customerAdminService.RegisterRequest,
      customerAdminService.RegisterResponse> getRegisterCustomersMethod() {
    io.grpc.MethodDescriptor<customerAdminService.RegisterRequest, customerAdminService.RegisterResponse> getRegisterCustomersMethod;
    if ((getRegisterCustomersMethod = CustomerAdminServiceGrpc.getRegisterCustomersMethod) == null) {
      synchronized (CustomerAdminServiceGrpc.class) {
        if ((getRegisterCustomersMethod = CustomerAdminServiceGrpc.getRegisterCustomersMethod) == null) {
          CustomerAdminServiceGrpc.getRegisterCustomersMethod = getRegisterCustomersMethod = 
              io.grpc.MethodDescriptor.<customerAdminService.RegisterRequest, customerAdminService.RegisterResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "CustomerAdminService.CustomerAdminService", "registerCustomers"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  customerAdminService.RegisterRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  customerAdminService.RegisterResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CustomerAdminServiceMethodDescriptorSupplier("registerCustomers"))
                  .build();
          }
        }
     }
     return getRegisterCustomersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<customerAdminService.DisplayRequest,
      customerAdminService.DisplayResponse> getDisplayCustomersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "displayCustomers",
      requestType = customerAdminService.DisplayRequest.class,
      responseType = customerAdminService.DisplayResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<customerAdminService.DisplayRequest,
      customerAdminService.DisplayResponse> getDisplayCustomersMethod() {
    io.grpc.MethodDescriptor<customerAdminService.DisplayRequest, customerAdminService.DisplayResponse> getDisplayCustomersMethod;
    if ((getDisplayCustomersMethod = CustomerAdminServiceGrpc.getDisplayCustomersMethod) == null) {
      synchronized (CustomerAdminServiceGrpc.class) {
        if ((getDisplayCustomersMethod = CustomerAdminServiceGrpc.getDisplayCustomersMethod) == null) {
          CustomerAdminServiceGrpc.getDisplayCustomersMethod = getDisplayCustomersMethod = 
              io.grpc.MethodDescriptor.<customerAdminService.DisplayRequest, customerAdminService.DisplayResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "CustomerAdminService.CustomerAdminService", "displayCustomers"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  customerAdminService.DisplayRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  customerAdminService.DisplayResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CustomerAdminServiceMethodDescriptorSupplier("displayCustomers"))
                  .build();
          }
        }
     }
     return getDisplayCustomersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<customerAdminService.CalculateRequest,
      customerAdminService.CalculateResponse> getCalculatePriceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "calculatePrice",
      requestType = customerAdminService.CalculateRequest.class,
      responseType = customerAdminService.CalculateResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<customerAdminService.CalculateRequest,
      customerAdminService.CalculateResponse> getCalculatePriceMethod() {
    io.grpc.MethodDescriptor<customerAdminService.CalculateRequest, customerAdminService.CalculateResponse> getCalculatePriceMethod;
    if ((getCalculatePriceMethod = CustomerAdminServiceGrpc.getCalculatePriceMethod) == null) {
      synchronized (CustomerAdminServiceGrpc.class) {
        if ((getCalculatePriceMethod = CustomerAdminServiceGrpc.getCalculatePriceMethod) == null) {
          CustomerAdminServiceGrpc.getCalculatePriceMethod = getCalculatePriceMethod = 
              io.grpc.MethodDescriptor.<customerAdminService.CalculateRequest, customerAdminService.CalculateResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "CustomerAdminService.CustomerAdminService", "calculatePrice"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  customerAdminService.CalculateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  customerAdminService.CalculateResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CustomerAdminServiceMethodDescriptorSupplier("calculatePrice"))
                  .build();
          }
        }
     }
     return getCalculatePriceMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CustomerAdminServiceStub newStub(io.grpc.Channel channel) {
    return new CustomerAdminServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CustomerAdminServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CustomerAdminServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CustomerAdminServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CustomerAdminServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class CustomerAdminServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *&#47;/Client streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<customerAdminService.RegisterRequest> registerCustomers(
        io.grpc.stub.StreamObserver<customerAdminService.RegisterResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getRegisterCustomersMethod(), responseObserver);
    }

    /**
     * <pre>
     *&#47;/Server streaming
     * </pre>
     */
    public void displayCustomers(customerAdminService.DisplayRequest request,
        io.grpc.stub.StreamObserver<customerAdminService.DisplayResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDisplayCustomersMethod(), responseObserver);
    }

    /**
     * <pre>
     *&#47;/Unary call
     * </pre>
     */
    public void calculatePrice(customerAdminService.CalculateRequest request,
        io.grpc.stub.StreamObserver<customerAdminService.CalculateResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCalculatePriceMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRegisterCustomersMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                customerAdminService.RegisterRequest,
                customerAdminService.RegisterResponse>(
                  this, METHODID_REGISTER_CUSTOMERS)))
          .addMethod(
            getDisplayCustomersMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                customerAdminService.DisplayRequest,
                customerAdminService.DisplayResponse>(
                  this, METHODID_DISPLAY_CUSTOMERS)))
          .addMethod(
            getCalculatePriceMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                customerAdminService.CalculateRequest,
                customerAdminService.CalculateResponse>(
                  this, METHODID_CALCULATE_PRICE)))
          .build();
    }
  }

  /**
   */
  public static final class CustomerAdminServiceStub extends io.grpc.stub.AbstractStub<CustomerAdminServiceStub> {
    private CustomerAdminServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CustomerAdminServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CustomerAdminServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CustomerAdminServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     *&#47;/Client streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<customerAdminService.RegisterRequest> registerCustomers(
        io.grpc.stub.StreamObserver<customerAdminService.RegisterResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getRegisterCustomersMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     *&#47;/Server streaming
     * </pre>
     */
    public void displayCustomers(customerAdminService.DisplayRequest request,
        io.grpc.stub.StreamObserver<customerAdminService.DisplayResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getDisplayCustomersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *&#47;/Unary call
     * </pre>
     */
    public void calculatePrice(customerAdminService.CalculateRequest request,
        io.grpc.stub.StreamObserver<customerAdminService.CalculateResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCalculatePriceMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CustomerAdminServiceBlockingStub extends io.grpc.stub.AbstractStub<CustomerAdminServiceBlockingStub> {
    private CustomerAdminServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CustomerAdminServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CustomerAdminServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CustomerAdminServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *&#47;/Server streaming
     * </pre>
     */
    public java.util.Iterator<customerAdminService.DisplayResponse> displayCustomers(
        customerAdminService.DisplayRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getDisplayCustomersMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *&#47;/Unary call
     * </pre>
     */
    public customerAdminService.CalculateResponse calculatePrice(customerAdminService.CalculateRequest request) {
      return blockingUnaryCall(
          getChannel(), getCalculatePriceMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CustomerAdminServiceFutureStub extends io.grpc.stub.AbstractStub<CustomerAdminServiceFutureStub> {
    private CustomerAdminServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CustomerAdminServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CustomerAdminServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CustomerAdminServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *&#47;/Unary call
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<customerAdminService.CalculateResponse> calculatePrice(
        customerAdminService.CalculateRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCalculatePriceMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_DISPLAY_CUSTOMERS = 0;
  private static final int METHODID_CALCULATE_PRICE = 1;
  private static final int METHODID_REGISTER_CUSTOMERS = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CustomerAdminServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CustomerAdminServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_DISPLAY_CUSTOMERS:
          serviceImpl.displayCustomers((customerAdminService.DisplayRequest) request,
              (io.grpc.stub.StreamObserver<customerAdminService.DisplayResponse>) responseObserver);
          break;
        case METHODID_CALCULATE_PRICE:
          serviceImpl.calculatePrice((customerAdminService.CalculateRequest) request,
              (io.grpc.stub.StreamObserver<customerAdminService.CalculateResponse>) responseObserver);
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
        case METHODID_REGISTER_CUSTOMERS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.registerCustomers(
              (io.grpc.stub.StreamObserver<customerAdminService.RegisterResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class CustomerAdminServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CustomerAdminServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return customerAdminService.customerAdminServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CustomerAdminService");
    }
  }

  private static final class CustomerAdminServiceFileDescriptorSupplier
      extends CustomerAdminServiceBaseDescriptorSupplier {
    CustomerAdminServiceFileDescriptorSupplier() {}
  }

  private static final class CustomerAdminServiceMethodDescriptorSupplier
      extends CustomerAdminServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CustomerAdminServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (CustomerAdminServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CustomerAdminServiceFileDescriptorSupplier())
              .addMethod(getRegisterCustomersMethod())
              .addMethod(getDisplayCustomersMethod())
              .addMethod(getCalculatePriceMethod())
              .build();
        }
      }
    }
    return result;
  }
}

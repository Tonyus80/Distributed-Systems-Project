package co2MonitoringService;

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
    comments = "Source: co2Monitoring.proto")
public final class Co2MonitoringServiceGrpc {

  private Co2MonitoringServiceGrpc() {}

  public static final String SERVICE_NAME = "co2MonitoringService.Co2MonitoringService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<co2MonitoringService.PowerRequest,
      co2MonitoringService.PowerResponse> getPowerSwitchMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "powerSwitch",
      requestType = co2MonitoringService.PowerRequest.class,
      responseType = co2MonitoringService.PowerResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<co2MonitoringService.PowerRequest,
      co2MonitoringService.PowerResponse> getPowerSwitchMethod() {
    io.grpc.MethodDescriptor<co2MonitoringService.PowerRequest, co2MonitoringService.PowerResponse> getPowerSwitchMethod;
    if ((getPowerSwitchMethod = Co2MonitoringServiceGrpc.getPowerSwitchMethod) == null) {
      synchronized (Co2MonitoringServiceGrpc.class) {
        if ((getPowerSwitchMethod = Co2MonitoringServiceGrpc.getPowerSwitchMethod) == null) {
          Co2MonitoringServiceGrpc.getPowerSwitchMethod = getPowerSwitchMethod = 
              io.grpc.MethodDescriptor.<co2MonitoringService.PowerRequest, co2MonitoringService.PowerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "co2MonitoringService.Co2MonitoringService", "powerSwitch"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  co2MonitoringService.PowerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  co2MonitoringService.PowerResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new Co2MonitoringServiceMethodDescriptorSupplier("powerSwitch"))
                  .build();
          }
        }
     }
     return getPowerSwitchMethod;
  }

  private static volatile io.grpc.MethodDescriptor<co2MonitoringService.Co2Request,
      co2MonitoringService.Co2Response> getCo2EmissionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "co2Emission",
      requestType = co2MonitoringService.Co2Request.class,
      responseType = co2MonitoringService.Co2Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<co2MonitoringService.Co2Request,
      co2MonitoringService.Co2Response> getCo2EmissionMethod() {
    io.grpc.MethodDescriptor<co2MonitoringService.Co2Request, co2MonitoringService.Co2Response> getCo2EmissionMethod;
    if ((getCo2EmissionMethod = Co2MonitoringServiceGrpc.getCo2EmissionMethod) == null) {
      synchronized (Co2MonitoringServiceGrpc.class) {
        if ((getCo2EmissionMethod = Co2MonitoringServiceGrpc.getCo2EmissionMethod) == null) {
          Co2MonitoringServiceGrpc.getCo2EmissionMethod = getCo2EmissionMethod = 
              io.grpc.MethodDescriptor.<co2MonitoringService.Co2Request, co2MonitoringService.Co2Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "co2MonitoringService.Co2MonitoringService", "co2Emission"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  co2MonitoringService.Co2Request.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  co2MonitoringService.Co2Response.getDefaultInstance()))
                  .setSchemaDescriptor(new Co2MonitoringServiceMethodDescriptorSupplier("co2Emission"))
                  .build();
          }
        }
     }
     return getCo2EmissionMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static Co2MonitoringServiceStub newStub(io.grpc.Channel channel) {
    return new Co2MonitoringServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static Co2MonitoringServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new Co2MonitoringServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static Co2MonitoringServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new Co2MonitoringServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class Co2MonitoringServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *Unary Call
     * </pre>
     */
    public void powerSwitch(co2MonitoringService.PowerRequest request,
        io.grpc.stub.StreamObserver<co2MonitoringService.PowerResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getPowerSwitchMethod(), responseObserver);
    }

    /**
     * <pre>
     *Bi-Directional
     * </pre>
     */
    public io.grpc.stub.StreamObserver<co2MonitoringService.Co2Request> co2Emission(
        io.grpc.stub.StreamObserver<co2MonitoringService.Co2Response> responseObserver) {
      return asyncUnimplementedStreamingCall(getCo2EmissionMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getPowerSwitchMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                co2MonitoringService.PowerRequest,
                co2MonitoringService.PowerResponse>(
                  this, METHODID_POWER_SWITCH)))
          .addMethod(
            getCo2EmissionMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                co2MonitoringService.Co2Request,
                co2MonitoringService.Co2Response>(
                  this, METHODID_CO2EMISSION)))
          .build();
    }
  }

  /**
   */
  public static final class Co2MonitoringServiceStub extends io.grpc.stub.AbstractStub<Co2MonitoringServiceStub> {
    private Co2MonitoringServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private Co2MonitoringServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected Co2MonitoringServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new Co2MonitoringServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     *Unary Call
     * </pre>
     */
    public void powerSwitch(co2MonitoringService.PowerRequest request,
        io.grpc.stub.StreamObserver<co2MonitoringService.PowerResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPowerSwitchMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *Bi-Directional
     * </pre>
     */
    public io.grpc.stub.StreamObserver<co2MonitoringService.Co2Request> co2Emission(
        io.grpc.stub.StreamObserver<co2MonitoringService.Co2Response> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getCo2EmissionMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class Co2MonitoringServiceBlockingStub extends io.grpc.stub.AbstractStub<Co2MonitoringServiceBlockingStub> {
    private Co2MonitoringServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private Co2MonitoringServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected Co2MonitoringServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new Co2MonitoringServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *Unary Call
     * </pre>
     */
    public co2MonitoringService.PowerResponse powerSwitch(co2MonitoringService.PowerRequest request) {
      return blockingUnaryCall(
          getChannel(), getPowerSwitchMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class Co2MonitoringServiceFutureStub extends io.grpc.stub.AbstractStub<Co2MonitoringServiceFutureStub> {
    private Co2MonitoringServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private Co2MonitoringServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected Co2MonitoringServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new Co2MonitoringServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *Unary Call
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<co2MonitoringService.PowerResponse> powerSwitch(
        co2MonitoringService.PowerRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getPowerSwitchMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_POWER_SWITCH = 0;
  private static final int METHODID_CO2EMISSION = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final Co2MonitoringServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(Co2MonitoringServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_POWER_SWITCH:
          serviceImpl.powerSwitch((co2MonitoringService.PowerRequest) request,
              (io.grpc.stub.StreamObserver<co2MonitoringService.PowerResponse>) responseObserver);
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
        case METHODID_CO2EMISSION:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.co2Emission(
              (io.grpc.stub.StreamObserver<co2MonitoringService.Co2Response>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class Co2MonitoringServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    Co2MonitoringServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return co2MonitoringService.Co2MonitoringServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Co2MonitoringService");
    }
  }

  private static final class Co2MonitoringServiceFileDescriptorSupplier
      extends Co2MonitoringServiceBaseDescriptorSupplier {
    Co2MonitoringServiceFileDescriptorSupplier() {}
  }

  private static final class Co2MonitoringServiceMethodDescriptorSupplier
      extends Co2MonitoringServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    Co2MonitoringServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (Co2MonitoringServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new Co2MonitoringServiceFileDescriptorSupplier())
              .addMethod(getPowerSwitchMethod())
              .addMethod(getCo2EmissionMethod())
              .build();
        }
      }
    }
    return result;
  }
}

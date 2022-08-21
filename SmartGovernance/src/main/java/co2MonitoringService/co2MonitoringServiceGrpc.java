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
public final class co2MonitoringServiceGrpc {

  private co2MonitoringServiceGrpc() {}

  public static final String SERVICE_NAME = "co2MonitoringService.co2MonitoringService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<co2MonitoringService.DeviceRequest,
      co2MonitoringService.DeviceResponse> getMonitoringDeviceOnOffMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "monitoringDeviceOnOff",
      requestType = co2MonitoringService.DeviceRequest.class,
      responseType = co2MonitoringService.DeviceResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<co2MonitoringService.DeviceRequest,
      co2MonitoringService.DeviceResponse> getMonitoringDeviceOnOffMethod() {
    io.grpc.MethodDescriptor<co2MonitoringService.DeviceRequest, co2MonitoringService.DeviceResponse> getMonitoringDeviceOnOffMethod;
    if ((getMonitoringDeviceOnOffMethod = co2MonitoringServiceGrpc.getMonitoringDeviceOnOffMethod) == null) {
      synchronized (co2MonitoringServiceGrpc.class) {
        if ((getMonitoringDeviceOnOffMethod = co2MonitoringServiceGrpc.getMonitoringDeviceOnOffMethod) == null) {
          co2MonitoringServiceGrpc.getMonitoringDeviceOnOffMethod = getMonitoringDeviceOnOffMethod = 
              io.grpc.MethodDescriptor.<co2MonitoringService.DeviceRequest, co2MonitoringService.DeviceResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "co2MonitoringService.co2MonitoringService", "monitoringDeviceOnOff"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  co2MonitoringService.DeviceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  co2MonitoringService.DeviceResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new co2MonitoringServiceMethodDescriptorSupplier("monitoringDeviceOnOff"))
                  .build();
          }
        }
     }
     return getMonitoringDeviceOnOffMethod;
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
    if ((getCo2EmissionMethod = co2MonitoringServiceGrpc.getCo2EmissionMethod) == null) {
      synchronized (co2MonitoringServiceGrpc.class) {
        if ((getCo2EmissionMethod = co2MonitoringServiceGrpc.getCo2EmissionMethod) == null) {
          co2MonitoringServiceGrpc.getCo2EmissionMethod = getCo2EmissionMethod = 
              io.grpc.MethodDescriptor.<co2MonitoringService.Co2Request, co2MonitoringService.Co2Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "co2MonitoringService.co2MonitoringService", "co2Emission"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  co2MonitoringService.Co2Request.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  co2MonitoringService.Co2Response.getDefaultInstance()))
                  .setSchemaDescriptor(new co2MonitoringServiceMethodDescriptorSupplier("co2Emission"))
                  .build();
          }
        }
     }
     return getCo2EmissionMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static co2MonitoringServiceStub newStub(io.grpc.Channel channel) {
    return new co2MonitoringServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static co2MonitoringServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new co2MonitoringServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static co2MonitoringServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new co2MonitoringServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class co2MonitoringServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *Unary Call
     * </pre>
     */
    public void monitoringDeviceOnOff(co2MonitoringService.DeviceRequest request,
        io.grpc.stub.StreamObserver<co2MonitoringService.DeviceResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getMonitoringDeviceOnOffMethod(), responseObserver);
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
            getMonitoringDeviceOnOffMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                co2MonitoringService.DeviceRequest,
                co2MonitoringService.DeviceResponse>(
                  this, METHODID_MONITORING_DEVICE_ON_OFF)))
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
  public static final class co2MonitoringServiceStub extends io.grpc.stub.AbstractStub<co2MonitoringServiceStub> {
    private co2MonitoringServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private co2MonitoringServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected co2MonitoringServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new co2MonitoringServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     *Unary Call
     * </pre>
     */
    public void monitoringDeviceOnOff(co2MonitoringService.DeviceRequest request,
        io.grpc.stub.StreamObserver<co2MonitoringService.DeviceResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getMonitoringDeviceOnOffMethod(), getCallOptions()), request, responseObserver);
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
  public static final class co2MonitoringServiceBlockingStub extends io.grpc.stub.AbstractStub<co2MonitoringServiceBlockingStub> {
    private co2MonitoringServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private co2MonitoringServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected co2MonitoringServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new co2MonitoringServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *Unary Call
     * </pre>
     */
    public co2MonitoringService.DeviceResponse monitoringDeviceOnOff(co2MonitoringService.DeviceRequest request) {
      return blockingUnaryCall(
          getChannel(), getMonitoringDeviceOnOffMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class co2MonitoringServiceFutureStub extends io.grpc.stub.AbstractStub<co2MonitoringServiceFutureStub> {
    private co2MonitoringServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private co2MonitoringServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected co2MonitoringServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new co2MonitoringServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *Unary Call
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<co2MonitoringService.DeviceResponse> monitoringDeviceOnOff(
        co2MonitoringService.DeviceRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getMonitoringDeviceOnOffMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_MONITORING_DEVICE_ON_OFF = 0;
  private static final int METHODID_CO2EMISSION = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final co2MonitoringServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(co2MonitoringServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_MONITORING_DEVICE_ON_OFF:
          serviceImpl.monitoringDeviceOnOff((co2MonitoringService.DeviceRequest) request,
              (io.grpc.stub.StreamObserver<co2MonitoringService.DeviceResponse>) responseObserver);
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

  private static abstract class co2MonitoringServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    co2MonitoringServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return co2MonitoringService.co2MonitoringServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("co2MonitoringService");
    }
  }

  private static final class co2MonitoringServiceFileDescriptorSupplier
      extends co2MonitoringServiceBaseDescriptorSupplier {
    co2MonitoringServiceFileDescriptorSupplier() {}
  }

  private static final class co2MonitoringServiceMethodDescriptorSupplier
      extends co2MonitoringServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    co2MonitoringServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (co2MonitoringServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new co2MonitoringServiceFileDescriptorSupplier())
              .addMethod(getMonitoringDeviceOnOffMethod())
              .addMethod(getCo2EmissionMethod())
              .build();
        }
      }
    }
    return result;
  }
}

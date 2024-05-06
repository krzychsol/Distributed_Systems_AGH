package sr.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.62.2)",
    comments = "Source: carshowroom.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CarshowroomServiceGrpc {

  private CarshowroomServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "tutorial.CarshowroomService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<sr.proto.CarshowroomServiceProtos.AddCarOptionalRequest,
      sr.proto.CarshowroomServiceProtos.AddCarResponse> getAddCarOptionalMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddCarOptional",
      requestType = sr.proto.CarshowroomServiceProtos.AddCarOptionalRequest.class,
      responseType = sr.proto.CarshowroomServiceProtos.AddCarResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<sr.proto.CarshowroomServiceProtos.AddCarOptionalRequest,
      sr.proto.CarshowroomServiceProtos.AddCarResponse> getAddCarOptionalMethod() {
    io.grpc.MethodDescriptor<sr.proto.CarshowroomServiceProtos.AddCarOptionalRequest, sr.proto.CarshowroomServiceProtos.AddCarResponse> getAddCarOptionalMethod;
    if ((getAddCarOptionalMethod = CarshowroomServiceGrpc.getAddCarOptionalMethod) == null) {
      synchronized (CarshowroomServiceGrpc.class) {
        if ((getAddCarOptionalMethod = CarshowroomServiceGrpc.getAddCarOptionalMethod) == null) {
          CarshowroomServiceGrpc.getAddCarOptionalMethod = getAddCarOptionalMethod =
              io.grpc.MethodDescriptor.<sr.proto.CarshowroomServiceProtos.AddCarOptionalRequest, sr.proto.CarshowroomServiceProtos.AddCarResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AddCarOptional"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sr.proto.CarshowroomServiceProtos.AddCarOptionalRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sr.proto.CarshowroomServiceProtos.AddCarResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CarshowroomServiceMethodDescriptorSupplier("AddCarOptional"))
              .build();
        }
      }
    }
    return getAddCarOptionalMethod;
  }

  private static volatile io.grpc.MethodDescriptor<sr.proto.CarshowroomServiceProtos.AddCarNoOptionalRequest,
      sr.proto.CarshowroomServiceProtos.AddCarResponse> getAddCarNoOptionalMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddCarNoOptional",
      requestType = sr.proto.CarshowroomServiceProtos.AddCarNoOptionalRequest.class,
      responseType = sr.proto.CarshowroomServiceProtos.AddCarResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<sr.proto.CarshowroomServiceProtos.AddCarNoOptionalRequest,
      sr.proto.CarshowroomServiceProtos.AddCarResponse> getAddCarNoOptionalMethod() {
    io.grpc.MethodDescriptor<sr.proto.CarshowroomServiceProtos.AddCarNoOptionalRequest, sr.proto.CarshowroomServiceProtos.AddCarResponse> getAddCarNoOptionalMethod;
    if ((getAddCarNoOptionalMethod = CarshowroomServiceGrpc.getAddCarNoOptionalMethod) == null) {
      synchronized (CarshowroomServiceGrpc.class) {
        if ((getAddCarNoOptionalMethod = CarshowroomServiceGrpc.getAddCarNoOptionalMethod) == null) {
          CarshowroomServiceGrpc.getAddCarNoOptionalMethod = getAddCarNoOptionalMethod =
              io.grpc.MethodDescriptor.<sr.proto.CarshowroomServiceProtos.AddCarNoOptionalRequest, sr.proto.CarshowroomServiceProtos.AddCarResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AddCarNoOptional"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sr.proto.CarshowroomServiceProtos.AddCarNoOptionalRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sr.proto.CarshowroomServiceProtos.AddCarResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CarshowroomServiceMethodDescriptorSupplier("AddCarNoOptional"))
              .build();
        }
      }
    }
    return getAddCarNoOptionalMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CarshowroomServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CarshowroomServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CarshowroomServiceStub>() {
        @java.lang.Override
        public CarshowroomServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CarshowroomServiceStub(channel, callOptions);
        }
      };
    return CarshowroomServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CarshowroomServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CarshowroomServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CarshowroomServiceBlockingStub>() {
        @java.lang.Override
        public CarshowroomServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CarshowroomServiceBlockingStub(channel, callOptions);
        }
      };
    return CarshowroomServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CarshowroomServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CarshowroomServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CarshowroomServiceFutureStub>() {
        @java.lang.Override
        public CarshowroomServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CarshowroomServiceFutureStub(channel, callOptions);
        }
      };
    return CarshowroomServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void addCarOptional(sr.proto.CarshowroomServiceProtos.AddCarOptionalRequest request,
        io.grpc.stub.StreamObserver<sr.proto.CarshowroomServiceProtos.AddCarResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddCarOptionalMethod(), responseObserver);
    }

    /**
     */
    default void addCarNoOptional(sr.proto.CarshowroomServiceProtos.AddCarNoOptionalRequest request,
        io.grpc.stub.StreamObserver<sr.proto.CarshowroomServiceProtos.AddCarResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddCarNoOptionalMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service CarshowroomService.
   */
  public static abstract class CarshowroomServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return CarshowroomServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service CarshowroomService.
   */
  public static final class CarshowroomServiceStub
      extends io.grpc.stub.AbstractAsyncStub<CarshowroomServiceStub> {
    private CarshowroomServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CarshowroomServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CarshowroomServiceStub(channel, callOptions);
    }

    /**
     */
    public void addCarOptional(sr.proto.CarshowroomServiceProtos.AddCarOptionalRequest request,
        io.grpc.stub.StreamObserver<sr.proto.CarshowroomServiceProtos.AddCarResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddCarOptionalMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addCarNoOptional(sr.proto.CarshowroomServiceProtos.AddCarNoOptionalRequest request,
        io.grpc.stub.StreamObserver<sr.proto.CarshowroomServiceProtos.AddCarResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddCarNoOptionalMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service CarshowroomService.
   */
  public static final class CarshowroomServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<CarshowroomServiceBlockingStub> {
    private CarshowroomServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CarshowroomServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CarshowroomServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public sr.proto.CarshowroomServiceProtos.AddCarResponse addCarOptional(sr.proto.CarshowroomServiceProtos.AddCarOptionalRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddCarOptionalMethod(), getCallOptions(), request);
    }

    /**
     */
    public sr.proto.CarshowroomServiceProtos.AddCarResponse addCarNoOptional(sr.proto.CarshowroomServiceProtos.AddCarNoOptionalRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddCarNoOptionalMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service CarshowroomService.
   */
  public static final class CarshowroomServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<CarshowroomServiceFutureStub> {
    private CarshowroomServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CarshowroomServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CarshowroomServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<sr.proto.CarshowroomServiceProtos.AddCarResponse> addCarOptional(
        sr.proto.CarshowroomServiceProtos.AddCarOptionalRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddCarOptionalMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<sr.proto.CarshowroomServiceProtos.AddCarResponse> addCarNoOptional(
        sr.proto.CarshowroomServiceProtos.AddCarNoOptionalRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddCarNoOptionalMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_CAR_OPTIONAL = 0;
  private static final int METHODID_ADD_CAR_NO_OPTIONAL = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD_CAR_OPTIONAL:
          serviceImpl.addCarOptional((sr.proto.CarshowroomServiceProtos.AddCarOptionalRequest) request,
              (io.grpc.stub.StreamObserver<sr.proto.CarshowroomServiceProtos.AddCarResponse>) responseObserver);
          break;
        case METHODID_ADD_CAR_NO_OPTIONAL:
          serviceImpl.addCarNoOptional((sr.proto.CarshowroomServiceProtos.AddCarNoOptionalRequest) request,
              (io.grpc.stub.StreamObserver<sr.proto.CarshowroomServiceProtos.AddCarResponse>) responseObserver);
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
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getAddCarOptionalMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              sr.proto.CarshowroomServiceProtos.AddCarOptionalRequest,
              sr.proto.CarshowroomServiceProtos.AddCarResponse>(
                service, METHODID_ADD_CAR_OPTIONAL)))
        .addMethod(
          getAddCarNoOptionalMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              sr.proto.CarshowroomServiceProtos.AddCarNoOptionalRequest,
              sr.proto.CarshowroomServiceProtos.AddCarResponse>(
                service, METHODID_ADD_CAR_NO_OPTIONAL)))
        .build();
  }

  private static abstract class CarshowroomServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CarshowroomServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return sr.proto.CarshowroomServiceProtos.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CarshowroomService");
    }
  }

  private static final class CarshowroomServiceFileDescriptorSupplier
      extends CarshowroomServiceBaseDescriptorSupplier {
    CarshowroomServiceFileDescriptorSupplier() {}
  }

  private static final class CarshowroomServiceMethodDescriptorSupplier
      extends CarshowroomServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    CarshowroomServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (CarshowroomServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CarshowroomServiceFileDescriptorSupplier())
              .addMethod(getAddCarOptionalMethod())
              .addMethod(getAddCarNoOptionalMethod())
              .build();
        }
      }
    }
    return result;
  }
}

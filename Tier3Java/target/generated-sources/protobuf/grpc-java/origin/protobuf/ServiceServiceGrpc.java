package origin.protobuf;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.4.0)",
    comments = "Source: protobuf.proto")
public final class ServiceServiceGrpc {

  private ServiceServiceGrpc() {}

  public static final String SERVICE_NAME = "ServiceService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<origin.protobuf.ServiceRequest,
      origin.protobuf.Void> METHOD_REQUEST_START_SERVICE =
      io.grpc.MethodDescriptor.<origin.protobuf.ServiceRequest, origin.protobuf.Void>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "ServiceService", "RequestStartService"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              origin.protobuf.ServiceRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              origin.protobuf.Void.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<origin.protobuf.ServiceRequest,
      origin.protobuf.Void> METHOD_ACCEPT_START_SERVICE =
      io.grpc.MethodDescriptor.<origin.protobuf.ServiceRequest, origin.protobuf.Void>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "ServiceService", "AcceptStartService"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              origin.protobuf.ServiceRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              origin.protobuf.Void.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<origin.protobuf.ServiceRequest,
      origin.protobuf.Void> METHOD_DENY_START_SERVICE =
      io.grpc.MethodDescriptor.<origin.protobuf.ServiceRequest, origin.protobuf.Void>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "ServiceService", "DenyStartService"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              origin.protobuf.ServiceRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              origin.protobuf.Void.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<origin.protobuf.FindServiceProto,
      origin.protobuf.Void> METHOD_END_SERVICE =
      io.grpc.MethodDescriptor.<origin.protobuf.FindServiceProto, origin.protobuf.Void>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "ServiceService", "EndService"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              origin.protobuf.FindServiceProto.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              origin.protobuf.Void.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<origin.protobuf.SearchAnnouncementProto,
      origin.protobuf.RequestServicesProto> METHOD_FIND_REQUEST_SERVICES =
      io.grpc.MethodDescriptor.<origin.protobuf.SearchAnnouncementProto, origin.protobuf.RequestServicesProto>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "ServiceService", "FindRequestServices"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              origin.protobuf.SearchAnnouncementProto.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              origin.protobuf.RequestServicesProto.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<origin.protobuf.SearchServiceProto,
      origin.protobuf.ServicesProto> METHOD_FIND_SERVICES =
      io.grpc.MethodDescriptor.<origin.protobuf.SearchServiceProto, origin.protobuf.ServicesProto>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "ServiceService", "FindServices"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              origin.protobuf.SearchServiceProto.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              origin.protobuf.ServicesProto.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<origin.protobuf.FindServiceProto,
      origin.protobuf.ServiceProto> METHOD_GET_SERVICE =
      io.grpc.MethodDescriptor.<origin.protobuf.FindServiceProto, origin.protobuf.ServiceProto>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "ServiceService", "GetService"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              origin.protobuf.FindServiceProto.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              origin.protobuf.ServiceProto.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ServiceServiceStub newStub(io.grpc.Channel channel) {
    return new ServiceServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ServiceServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ServiceServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ServiceServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ServiceServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class ServiceServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void requestStartService(origin.protobuf.ServiceRequest request,
        io.grpc.stub.StreamObserver<origin.protobuf.Void> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_REQUEST_START_SERVICE, responseObserver);
    }

    /**
     */
    public void acceptStartService(origin.protobuf.ServiceRequest request,
        io.grpc.stub.StreamObserver<origin.protobuf.Void> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_ACCEPT_START_SERVICE, responseObserver);
    }

    /**
     */
    public void denyStartService(origin.protobuf.ServiceRequest request,
        io.grpc.stub.StreamObserver<origin.protobuf.Void> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_DENY_START_SERVICE, responseObserver);
    }

    /**
     */
    public void endService(origin.protobuf.FindServiceProto request,
        io.grpc.stub.StreamObserver<origin.protobuf.Void> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_END_SERVICE, responseObserver);
    }

    /**
     */
    public void findRequestServices(origin.protobuf.SearchAnnouncementProto request,
        io.grpc.stub.StreamObserver<origin.protobuf.RequestServicesProto> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_FIND_REQUEST_SERVICES, responseObserver);
    }

    /**
     */
    public void findServices(origin.protobuf.SearchServiceProto request,
        io.grpc.stub.StreamObserver<origin.protobuf.ServicesProto> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_FIND_SERVICES, responseObserver);
    }

    /**
     */
    public void getService(origin.protobuf.FindServiceProto request,
        io.grpc.stub.StreamObserver<origin.protobuf.ServiceProto> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_SERVICE, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_REQUEST_START_SERVICE,
            asyncUnaryCall(
              new MethodHandlers<
                origin.protobuf.ServiceRequest,
                origin.protobuf.Void>(
                  this, METHODID_REQUEST_START_SERVICE)))
          .addMethod(
            METHOD_ACCEPT_START_SERVICE,
            asyncUnaryCall(
              new MethodHandlers<
                origin.protobuf.ServiceRequest,
                origin.protobuf.Void>(
                  this, METHODID_ACCEPT_START_SERVICE)))
          .addMethod(
            METHOD_DENY_START_SERVICE,
            asyncUnaryCall(
              new MethodHandlers<
                origin.protobuf.ServiceRequest,
                origin.protobuf.Void>(
                  this, METHODID_DENY_START_SERVICE)))
          .addMethod(
            METHOD_END_SERVICE,
            asyncUnaryCall(
              new MethodHandlers<
                origin.protobuf.FindServiceProto,
                origin.protobuf.Void>(
                  this, METHODID_END_SERVICE)))
          .addMethod(
            METHOD_FIND_REQUEST_SERVICES,
            asyncUnaryCall(
              new MethodHandlers<
                origin.protobuf.SearchAnnouncementProto,
                origin.protobuf.RequestServicesProto>(
                  this, METHODID_FIND_REQUEST_SERVICES)))
          .addMethod(
            METHOD_FIND_SERVICES,
            asyncUnaryCall(
              new MethodHandlers<
                origin.protobuf.SearchServiceProto,
                origin.protobuf.ServicesProto>(
                  this, METHODID_FIND_SERVICES)))
          .addMethod(
            METHOD_GET_SERVICE,
            asyncUnaryCall(
              new MethodHandlers<
                origin.protobuf.FindServiceProto,
                origin.protobuf.ServiceProto>(
                  this, METHODID_GET_SERVICE)))
          .build();
    }
  }

  /**
   */
  public static final class ServiceServiceStub extends io.grpc.stub.AbstractStub<ServiceServiceStub> {
    private ServiceServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ServiceServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServiceServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ServiceServiceStub(channel, callOptions);
    }

    /**
     */
    public void requestStartService(origin.protobuf.ServiceRequest request,
        io.grpc.stub.StreamObserver<origin.protobuf.Void> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_REQUEST_START_SERVICE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void acceptStartService(origin.protobuf.ServiceRequest request,
        io.grpc.stub.StreamObserver<origin.protobuf.Void> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ACCEPT_START_SERVICE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void denyStartService(origin.protobuf.ServiceRequest request,
        io.grpc.stub.StreamObserver<origin.protobuf.Void> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_DENY_START_SERVICE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void endService(origin.protobuf.FindServiceProto request,
        io.grpc.stub.StreamObserver<origin.protobuf.Void> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_END_SERVICE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void findRequestServices(origin.protobuf.SearchAnnouncementProto request,
        io.grpc.stub.StreamObserver<origin.protobuf.RequestServicesProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_FIND_REQUEST_SERVICES, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void findServices(origin.protobuf.SearchServiceProto request,
        io.grpc.stub.StreamObserver<origin.protobuf.ServicesProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_FIND_SERVICES, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getService(origin.protobuf.FindServiceProto request,
        io.grpc.stub.StreamObserver<origin.protobuf.ServiceProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_SERVICE, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ServiceServiceBlockingStub extends io.grpc.stub.AbstractStub<ServiceServiceBlockingStub> {
    private ServiceServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ServiceServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServiceServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ServiceServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public origin.protobuf.Void requestStartService(origin.protobuf.ServiceRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_REQUEST_START_SERVICE, getCallOptions(), request);
    }

    /**
     */
    public origin.protobuf.Void acceptStartService(origin.protobuf.ServiceRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_ACCEPT_START_SERVICE, getCallOptions(), request);
    }

    /**
     */
    public origin.protobuf.Void denyStartService(origin.protobuf.ServiceRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_DENY_START_SERVICE, getCallOptions(), request);
    }

    /**
     */
    public origin.protobuf.Void endService(origin.protobuf.FindServiceProto request) {
      return blockingUnaryCall(
          getChannel(), METHOD_END_SERVICE, getCallOptions(), request);
    }

    /**
     */
    public origin.protobuf.RequestServicesProto findRequestServices(origin.protobuf.SearchAnnouncementProto request) {
      return blockingUnaryCall(
          getChannel(), METHOD_FIND_REQUEST_SERVICES, getCallOptions(), request);
    }

    /**
     */
    public origin.protobuf.ServicesProto findServices(origin.protobuf.SearchServiceProto request) {
      return blockingUnaryCall(
          getChannel(), METHOD_FIND_SERVICES, getCallOptions(), request);
    }

    /**
     */
    public origin.protobuf.ServiceProto getService(origin.protobuf.FindServiceProto request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_SERVICE, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ServiceServiceFutureStub extends io.grpc.stub.AbstractStub<ServiceServiceFutureStub> {
    private ServiceServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ServiceServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServiceServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ServiceServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<origin.protobuf.Void> requestStartService(
        origin.protobuf.ServiceRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_REQUEST_START_SERVICE, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<origin.protobuf.Void> acceptStartService(
        origin.protobuf.ServiceRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_ACCEPT_START_SERVICE, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<origin.protobuf.Void> denyStartService(
        origin.protobuf.ServiceRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_DENY_START_SERVICE, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<origin.protobuf.Void> endService(
        origin.protobuf.FindServiceProto request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_END_SERVICE, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<origin.protobuf.RequestServicesProto> findRequestServices(
        origin.protobuf.SearchAnnouncementProto request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_FIND_REQUEST_SERVICES, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<origin.protobuf.ServicesProto> findServices(
        origin.protobuf.SearchServiceProto request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_FIND_SERVICES, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<origin.protobuf.ServiceProto> getService(
        origin.protobuf.FindServiceProto request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_SERVICE, getCallOptions()), request);
    }
  }

  private static final int METHODID_REQUEST_START_SERVICE = 0;
  private static final int METHODID_ACCEPT_START_SERVICE = 1;
  private static final int METHODID_DENY_START_SERVICE = 2;
  private static final int METHODID_END_SERVICE = 3;
  private static final int METHODID_FIND_REQUEST_SERVICES = 4;
  private static final int METHODID_FIND_SERVICES = 5;
  private static final int METHODID_GET_SERVICE = 6;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ServiceServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ServiceServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REQUEST_START_SERVICE:
          serviceImpl.requestStartService((origin.protobuf.ServiceRequest) request,
              (io.grpc.stub.StreamObserver<origin.protobuf.Void>) responseObserver);
          break;
        case METHODID_ACCEPT_START_SERVICE:
          serviceImpl.acceptStartService((origin.protobuf.ServiceRequest) request,
              (io.grpc.stub.StreamObserver<origin.protobuf.Void>) responseObserver);
          break;
        case METHODID_DENY_START_SERVICE:
          serviceImpl.denyStartService((origin.protobuf.ServiceRequest) request,
              (io.grpc.stub.StreamObserver<origin.protobuf.Void>) responseObserver);
          break;
        case METHODID_END_SERVICE:
          serviceImpl.endService((origin.protobuf.FindServiceProto) request,
              (io.grpc.stub.StreamObserver<origin.protobuf.Void>) responseObserver);
          break;
        case METHODID_FIND_REQUEST_SERVICES:
          serviceImpl.findRequestServices((origin.protobuf.SearchAnnouncementProto) request,
              (io.grpc.stub.StreamObserver<origin.protobuf.RequestServicesProto>) responseObserver);
          break;
        case METHODID_FIND_SERVICES:
          serviceImpl.findServices((origin.protobuf.SearchServiceProto) request,
              (io.grpc.stub.StreamObserver<origin.protobuf.ServicesProto>) responseObserver);
          break;
        case METHODID_GET_SERVICE:
          serviceImpl.getService((origin.protobuf.FindServiceProto) request,
              (io.grpc.stub.StreamObserver<origin.protobuf.ServiceProto>) responseObserver);
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

  private static final class ServiceServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return origin.protobuf.Protobuf.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ServiceServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ServiceServiceDescriptorSupplier())
              .addMethod(METHOD_REQUEST_START_SERVICE)
              .addMethod(METHOD_ACCEPT_START_SERVICE)
              .addMethod(METHOD_DENY_START_SERVICE)
              .addMethod(METHOD_END_SERVICE)
              .addMethod(METHOD_FIND_REQUEST_SERVICES)
              .addMethod(METHOD_FIND_SERVICES)
              .addMethod(METHOD_GET_SERVICE)
              .build();
        }
      }
    }
    return result;
  }
}

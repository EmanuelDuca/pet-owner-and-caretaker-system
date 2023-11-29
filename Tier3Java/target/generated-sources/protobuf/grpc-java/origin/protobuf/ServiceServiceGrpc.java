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
  public static final io.grpc.MethodDescriptor<origin.protobuf.ServiceRequestProto,
      origin.protobuf.Void> METHOD_REQUEST_START_SERVICE =
      io.grpc.MethodDescriptor.<origin.protobuf.ServiceRequestProto, origin.protobuf.Void>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "ServiceService", "RequestStartService"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              origin.protobuf.ServiceRequestProto.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              origin.protobuf.Void.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<origin.protobuf.FindRequestServiceProto,
      origin.protobuf.Void> METHOD_ACCEPT_START_SERVICE =
      io.grpc.MethodDescriptor.<origin.protobuf.FindRequestServiceProto, origin.protobuf.Void>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "ServiceService", "AcceptStartService"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              origin.protobuf.FindRequestServiceProto.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              origin.protobuf.Void.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<origin.protobuf.FindRequestServiceProto,
      origin.protobuf.Void> METHOD_DENY_START_SERVICE =
      io.grpc.MethodDescriptor.<origin.protobuf.FindRequestServiceProto, origin.protobuf.Void>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "ServiceService", "DenyStartService"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              origin.protobuf.FindRequestServiceProto.getDefaultInstance()))
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
  public static final io.grpc.MethodDescriptor<origin.protobuf.FindAnnouncementProto,
      origin.protobuf.RequestServicesProto> METHOD_SEARCH_REQUEST_SERVICES =
      io.grpc.MethodDescriptor.<origin.protobuf.FindAnnouncementProto, origin.protobuf.RequestServicesProto>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "ServiceService", "SearchRequestServices"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              origin.protobuf.FindAnnouncementProto.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              origin.protobuf.RequestServicesProto.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<origin.protobuf.SearchServiceProto,
      origin.protobuf.ServicesProto> METHOD_SEARCH_SERVICES =
      io.grpc.MethodDescriptor.<origin.protobuf.SearchServiceProto, origin.protobuf.ServicesProto>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "ServiceService", "SearchServices"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              origin.protobuf.SearchServiceProto.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              origin.protobuf.ServicesProto.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<origin.protobuf.FindServiceProto,
      origin.protobuf.ServiceProto> METHOD_FIND_SERVICE =
      io.grpc.MethodDescriptor.<origin.protobuf.FindServiceProto, origin.protobuf.ServiceProto>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "ServiceService", "FindService"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              origin.protobuf.FindServiceProto.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              origin.protobuf.ServiceProto.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<origin.protobuf.FeedbackProto,
      origin.protobuf.Void> METHOD_ADD_FEEDBACK =
      io.grpc.MethodDescriptor.<origin.protobuf.FeedbackProto, origin.protobuf.Void>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "ServiceService", "AddFeedback"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              origin.protobuf.FeedbackProto.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              origin.protobuf.Void.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<origin.protobuf.FindFeedbackProto,
      origin.protobuf.Void> METHOD_DELETE_FEEDBACK =
      io.grpc.MethodDescriptor.<origin.protobuf.FindFeedbackProto, origin.protobuf.Void>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "ServiceService", "DeleteFeedback"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              origin.protobuf.FindFeedbackProto.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              origin.protobuf.Void.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<origin.protobuf.FindUserProto,
      origin.protobuf.FeedbacksProto> METHOD_SEARCH_FEEDBACKS =
      io.grpc.MethodDescriptor.<origin.protobuf.FindUserProto, origin.protobuf.FeedbacksProto>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "ServiceService", "SearchFeedbacks"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              origin.protobuf.FindUserProto.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              origin.protobuf.FeedbacksProto.getDefaultInstance()))
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
    public void requestStartService(origin.protobuf.ServiceRequestProto request,
        io.grpc.stub.StreamObserver<origin.protobuf.Void> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_REQUEST_START_SERVICE, responseObserver);
    }

    /**
     */
    public void acceptStartService(origin.protobuf.FindRequestServiceProto request,
        io.grpc.stub.StreamObserver<origin.protobuf.Void> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_ACCEPT_START_SERVICE, responseObserver);
    }

    /**
     */
    public void denyStartService(origin.protobuf.FindRequestServiceProto request,
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
    public void searchRequestServices(origin.protobuf.FindAnnouncementProto request,
        io.grpc.stub.StreamObserver<origin.protobuf.RequestServicesProto> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SEARCH_REQUEST_SERVICES, responseObserver);
    }

    /**
     */
    public void searchServices(origin.protobuf.SearchServiceProto request,
        io.grpc.stub.StreamObserver<origin.protobuf.ServicesProto> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SEARCH_SERVICES, responseObserver);
    }

    /**
     */
    public void findService(origin.protobuf.FindServiceProto request,
        io.grpc.stub.StreamObserver<origin.protobuf.ServiceProto> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_FIND_SERVICE, responseObserver);
    }

    /**
     */
    public void addFeedback(origin.protobuf.FeedbackProto request,
        io.grpc.stub.StreamObserver<origin.protobuf.Void> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_ADD_FEEDBACK, responseObserver);
    }

    /**
     */
    public void deleteFeedback(origin.protobuf.FindFeedbackProto request,
        io.grpc.stub.StreamObserver<origin.protobuf.Void> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_DELETE_FEEDBACK, responseObserver);
    }

    /**
     */
    public void searchFeedbacks(origin.protobuf.FindUserProto request,
        io.grpc.stub.StreamObserver<origin.protobuf.FeedbacksProto> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SEARCH_FEEDBACKS, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_REQUEST_START_SERVICE,
            asyncUnaryCall(
              new MethodHandlers<
                origin.protobuf.ServiceRequestProto,
                origin.protobuf.Void>(
                  this, METHODID_REQUEST_START_SERVICE)))
          .addMethod(
            METHOD_ACCEPT_START_SERVICE,
            asyncUnaryCall(
              new MethodHandlers<
                origin.protobuf.FindRequestServiceProto,
                origin.protobuf.Void>(
                  this, METHODID_ACCEPT_START_SERVICE)))
          .addMethod(
            METHOD_DENY_START_SERVICE,
            asyncUnaryCall(
              new MethodHandlers<
                origin.protobuf.FindRequestServiceProto,
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
            METHOD_SEARCH_REQUEST_SERVICES,
            asyncUnaryCall(
              new MethodHandlers<
                origin.protobuf.FindAnnouncementProto,
                origin.protobuf.RequestServicesProto>(
                  this, METHODID_SEARCH_REQUEST_SERVICES)))
          .addMethod(
            METHOD_SEARCH_SERVICES,
            asyncUnaryCall(
              new MethodHandlers<
                origin.protobuf.SearchServiceProto,
                origin.protobuf.ServicesProto>(
                  this, METHODID_SEARCH_SERVICES)))
          .addMethod(
            METHOD_FIND_SERVICE,
            asyncUnaryCall(
              new MethodHandlers<
                origin.protobuf.FindServiceProto,
                origin.protobuf.ServiceProto>(
                  this, METHODID_FIND_SERVICE)))
          .addMethod(
            METHOD_ADD_FEEDBACK,
            asyncUnaryCall(
              new MethodHandlers<
                origin.protobuf.FeedbackProto,
                origin.protobuf.Void>(
                  this, METHODID_ADD_FEEDBACK)))
          .addMethod(
            METHOD_DELETE_FEEDBACK,
            asyncUnaryCall(
              new MethodHandlers<
                origin.protobuf.FindFeedbackProto,
                origin.protobuf.Void>(
                  this, METHODID_DELETE_FEEDBACK)))
          .addMethod(
            METHOD_SEARCH_FEEDBACKS,
            asyncUnaryCall(
              new MethodHandlers<
                origin.protobuf.FindUserProto,
                origin.protobuf.FeedbacksProto>(
                  this, METHODID_SEARCH_FEEDBACKS)))
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
    public void requestStartService(origin.protobuf.ServiceRequestProto request,
        io.grpc.stub.StreamObserver<origin.protobuf.Void> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_REQUEST_START_SERVICE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void acceptStartService(origin.protobuf.FindRequestServiceProto request,
        io.grpc.stub.StreamObserver<origin.protobuf.Void> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ACCEPT_START_SERVICE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void denyStartService(origin.protobuf.FindRequestServiceProto request,
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
    public void searchRequestServices(origin.protobuf.FindAnnouncementProto request,
        io.grpc.stub.StreamObserver<origin.protobuf.RequestServicesProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SEARCH_REQUEST_SERVICES, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void searchServices(origin.protobuf.SearchServiceProto request,
        io.grpc.stub.StreamObserver<origin.protobuf.ServicesProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SEARCH_SERVICES, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void findService(origin.protobuf.FindServiceProto request,
        io.grpc.stub.StreamObserver<origin.protobuf.ServiceProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_FIND_SERVICE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addFeedback(origin.protobuf.FeedbackProto request,
        io.grpc.stub.StreamObserver<origin.protobuf.Void> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ADD_FEEDBACK, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteFeedback(origin.protobuf.FindFeedbackProto request,
        io.grpc.stub.StreamObserver<origin.protobuf.Void> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_DELETE_FEEDBACK, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void searchFeedbacks(origin.protobuf.FindUserProto request,
        io.grpc.stub.StreamObserver<origin.protobuf.FeedbacksProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SEARCH_FEEDBACKS, getCallOptions()), request, responseObserver);
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
    public origin.protobuf.Void requestStartService(origin.protobuf.ServiceRequestProto request) {
      return blockingUnaryCall(
          getChannel(), METHOD_REQUEST_START_SERVICE, getCallOptions(), request);
    }

    /**
     */
    public origin.protobuf.Void acceptStartService(origin.protobuf.FindRequestServiceProto request) {
      return blockingUnaryCall(
          getChannel(), METHOD_ACCEPT_START_SERVICE, getCallOptions(), request);
    }

    /**
     */
    public origin.protobuf.Void denyStartService(origin.protobuf.FindRequestServiceProto request) {
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
    public origin.protobuf.RequestServicesProto searchRequestServices(origin.protobuf.FindAnnouncementProto request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SEARCH_REQUEST_SERVICES, getCallOptions(), request);
    }

    /**
     */
    public origin.protobuf.ServicesProto searchServices(origin.protobuf.SearchServiceProto request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SEARCH_SERVICES, getCallOptions(), request);
    }

    /**
     */
    public origin.protobuf.ServiceProto findService(origin.protobuf.FindServiceProto request) {
      return blockingUnaryCall(
          getChannel(), METHOD_FIND_SERVICE, getCallOptions(), request);
    }

    /**
     */
    public origin.protobuf.Void addFeedback(origin.protobuf.FeedbackProto request) {
      return blockingUnaryCall(
          getChannel(), METHOD_ADD_FEEDBACK, getCallOptions(), request);
    }

    /**
     */
    public origin.protobuf.Void deleteFeedback(origin.protobuf.FindFeedbackProto request) {
      return blockingUnaryCall(
          getChannel(), METHOD_DELETE_FEEDBACK, getCallOptions(), request);
    }

    /**
     */
    public origin.protobuf.FeedbacksProto searchFeedbacks(origin.protobuf.FindUserProto request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SEARCH_FEEDBACKS, getCallOptions(), request);
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
        origin.protobuf.ServiceRequestProto request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_REQUEST_START_SERVICE, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<origin.protobuf.Void> acceptStartService(
        origin.protobuf.FindRequestServiceProto request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_ACCEPT_START_SERVICE, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<origin.protobuf.Void> denyStartService(
        origin.protobuf.FindRequestServiceProto request) {
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
    public com.google.common.util.concurrent.ListenableFuture<origin.protobuf.RequestServicesProto> searchRequestServices(
        origin.protobuf.FindAnnouncementProto request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SEARCH_REQUEST_SERVICES, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<origin.protobuf.ServicesProto> searchServices(
        origin.protobuf.SearchServiceProto request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SEARCH_SERVICES, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<origin.protobuf.ServiceProto> findService(
        origin.protobuf.FindServiceProto request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_FIND_SERVICE, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<origin.protobuf.Void> addFeedback(
        origin.protobuf.FeedbackProto request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_ADD_FEEDBACK, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<origin.protobuf.Void> deleteFeedback(
        origin.protobuf.FindFeedbackProto request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_DELETE_FEEDBACK, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<origin.protobuf.FeedbacksProto> searchFeedbacks(
        origin.protobuf.FindUserProto request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SEARCH_FEEDBACKS, getCallOptions()), request);
    }
  }

  private static final int METHODID_REQUEST_START_SERVICE = 0;
  private static final int METHODID_ACCEPT_START_SERVICE = 1;
  private static final int METHODID_DENY_START_SERVICE = 2;
  private static final int METHODID_END_SERVICE = 3;
  private static final int METHODID_SEARCH_REQUEST_SERVICES = 4;
  private static final int METHODID_SEARCH_SERVICES = 5;
  private static final int METHODID_FIND_SERVICE = 6;
  private static final int METHODID_ADD_FEEDBACK = 7;
  private static final int METHODID_DELETE_FEEDBACK = 8;
  private static final int METHODID_SEARCH_FEEDBACKS = 9;

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
          serviceImpl.requestStartService((origin.protobuf.ServiceRequestProto) request,
              (io.grpc.stub.StreamObserver<origin.protobuf.Void>) responseObserver);
          break;
        case METHODID_ACCEPT_START_SERVICE:
          serviceImpl.acceptStartService((origin.protobuf.FindRequestServiceProto) request,
              (io.grpc.stub.StreamObserver<origin.protobuf.Void>) responseObserver);
          break;
        case METHODID_DENY_START_SERVICE:
          serviceImpl.denyStartService((origin.protobuf.FindRequestServiceProto) request,
              (io.grpc.stub.StreamObserver<origin.protobuf.Void>) responseObserver);
          break;
        case METHODID_END_SERVICE:
          serviceImpl.endService((origin.protobuf.FindServiceProto) request,
              (io.grpc.stub.StreamObserver<origin.protobuf.Void>) responseObserver);
          break;
        case METHODID_SEARCH_REQUEST_SERVICES:
          serviceImpl.searchRequestServices((origin.protobuf.FindAnnouncementProto) request,
              (io.grpc.stub.StreamObserver<origin.protobuf.RequestServicesProto>) responseObserver);
          break;
        case METHODID_SEARCH_SERVICES:
          serviceImpl.searchServices((origin.protobuf.SearchServiceProto) request,
              (io.grpc.stub.StreamObserver<origin.protobuf.ServicesProto>) responseObserver);
          break;
        case METHODID_FIND_SERVICE:
          serviceImpl.findService((origin.protobuf.FindServiceProto) request,
              (io.grpc.stub.StreamObserver<origin.protobuf.ServiceProto>) responseObserver);
          break;
        case METHODID_ADD_FEEDBACK:
          serviceImpl.addFeedback((origin.protobuf.FeedbackProto) request,
              (io.grpc.stub.StreamObserver<origin.protobuf.Void>) responseObserver);
          break;
        case METHODID_DELETE_FEEDBACK:
          serviceImpl.deleteFeedback((origin.protobuf.FindFeedbackProto) request,
              (io.grpc.stub.StreamObserver<origin.protobuf.Void>) responseObserver);
          break;
        case METHODID_SEARCH_FEEDBACKS:
          serviceImpl.searchFeedbacks((origin.protobuf.FindUserProto) request,
              (io.grpc.stub.StreamObserver<origin.protobuf.FeedbacksProto>) responseObserver);
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
              .addMethod(METHOD_SEARCH_REQUEST_SERVICES)
              .addMethod(METHOD_SEARCH_SERVICES)
              .addMethod(METHOD_FIND_SERVICE)
              .addMethod(METHOD_ADD_FEEDBACK)
              .addMethod(METHOD_DELETE_FEEDBACK)
              .addMethod(METHOD_SEARCH_FEEDBACKS)
              .build();
        }
      }
    }
    return result;
  }
}

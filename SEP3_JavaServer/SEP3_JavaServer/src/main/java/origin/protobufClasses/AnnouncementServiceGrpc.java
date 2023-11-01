package origin.protobufClasses;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.4.0)",
    comments = "Source: protobuf.proto")
public final class AnnouncementServiceGrpc {

  private AnnouncementServiceGrpc() {}

  public static final String SERVICE_NAME = "AnnouncementService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<Announcement,
          Announcement> METHOD_CREATE_ANNOUNCEMENT =
      io.grpc.MethodDescriptor.<Announcement, Announcement>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "AnnouncementService", "CreateAnnouncement"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              Announcement.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              Announcement.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<SearchField,
          Announcements> METHOD_FIND_ANNOUNCEMENTS =
      io.grpc.MethodDescriptor.<SearchField, Announcements>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "AnnouncementService", "FindAnnouncements"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              SearchField.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              Announcements.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<Announcement,
          Void> METHOD_UPDATE_ANNOUNCEMENT =
      io.grpc.MethodDescriptor.<Announcement, Void>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "AnnouncementService", "UpdateAnnouncement"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              Announcement.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              Void.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<Announcement,
          Void> METHOD_DELETE_ANNOUNCEMENT =
      io.grpc.MethodDescriptor.<Announcement, Void>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "AnnouncementService", "DeleteAnnouncement"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              Announcement.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              Void.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AnnouncementServiceStub newStub(io.grpc.Channel channel) {
    return new AnnouncementServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AnnouncementServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new AnnouncementServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AnnouncementServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new AnnouncementServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class AnnouncementServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void createAnnouncement(Announcement request,
                                   io.grpc.stub.StreamObserver<Announcement> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_CREATE_ANNOUNCEMENT, responseObserver);
    }

    /**
     */
    public void findAnnouncements(SearchField request,
                                  io.grpc.stub.StreamObserver<Announcements> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_FIND_ANNOUNCEMENTS, responseObserver);
    }

    /**
     */
    public void updateAnnouncement(Announcement request,
                                   io.grpc.stub.StreamObserver<Void> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_UPDATE_ANNOUNCEMENT, responseObserver);
    }

    /**
     */
    public void deleteAnnouncement(Announcement request,
                                   io.grpc.stub.StreamObserver<Void> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_DELETE_ANNOUNCEMENT, responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_CREATE_ANNOUNCEMENT,
            asyncUnaryCall(
              new MethodHandlers<
                      Announcement,
                      Announcement>(
                  this, METHODID_CREATE_ANNOUNCEMENT)))
          .addMethod(
            METHOD_FIND_ANNOUNCEMENTS,
            asyncUnaryCall(
              new MethodHandlers<
                      SearchField,
                      Announcements>(
                  this, METHODID_FIND_ANNOUNCEMENTS)))
          .addMethod(
            METHOD_UPDATE_ANNOUNCEMENT,
            asyncUnaryCall(
              new MethodHandlers<
                      Announcement,
                      Void>(
                  this, METHODID_UPDATE_ANNOUNCEMENT)))
          .addMethod(
            METHOD_DELETE_ANNOUNCEMENT,
            asyncUnaryCall(
              new MethodHandlers<
                      Announcement,
                      Void>(
                  this, METHODID_DELETE_ANNOUNCEMENT)))
          .build();
    }
  }

  /**
   */
  public static final class AnnouncementServiceStub extends io.grpc.stub.AbstractStub<AnnouncementServiceStub> {
    private AnnouncementServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AnnouncementServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected AnnouncementServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AnnouncementServiceStub(channel, callOptions);
    }

    /**
     */
    public void createAnnouncement(Announcement request,
                                   io.grpc.stub.StreamObserver<Announcement> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_CREATE_ANNOUNCEMENT, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void findAnnouncements(SearchField request,
                                  io.grpc.stub.StreamObserver<Announcements> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_FIND_ANNOUNCEMENTS, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateAnnouncement(Announcement request,
                                   io.grpc.stub.StreamObserver<Void> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_UPDATE_ANNOUNCEMENT, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteAnnouncement(Announcement request,
                                   io.grpc.stub.StreamObserver<Void> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_DELETE_ANNOUNCEMENT, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class AnnouncementServiceBlockingStub extends io.grpc.stub.AbstractStub<AnnouncementServiceBlockingStub> {
    private AnnouncementServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AnnouncementServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected AnnouncementServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AnnouncementServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public Announcement createAnnouncement(Announcement request) {
      return blockingUnaryCall(
          getChannel(), METHOD_CREATE_ANNOUNCEMENT, getCallOptions(), request);
    }

    /**
     */
    public Announcements findAnnouncements(SearchField request) {
      return blockingUnaryCall(
          getChannel(), METHOD_FIND_ANNOUNCEMENTS, getCallOptions(), request);
    }

    /**
     */
    public Void updateAnnouncement(Announcement request) {
      return blockingUnaryCall(
          getChannel(), METHOD_UPDATE_ANNOUNCEMENT, getCallOptions(), request);
    }

    /**
     */
    public Void deleteAnnouncement(Announcement request) {
      return blockingUnaryCall(
          getChannel(), METHOD_DELETE_ANNOUNCEMENT, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class AnnouncementServiceFutureStub extends io.grpc.stub.AbstractStub<AnnouncementServiceFutureStub> {
    private AnnouncementServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AnnouncementServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected AnnouncementServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AnnouncementServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Announcement> createAnnouncement(
        Announcement request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_CREATE_ANNOUNCEMENT, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Announcements> findAnnouncements(
        SearchField request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_FIND_ANNOUNCEMENTS, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Void> updateAnnouncement(
        Announcement request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_UPDATE_ANNOUNCEMENT, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Void> deleteAnnouncement(
        Announcement request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_DELETE_ANNOUNCEMENT, getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_ANNOUNCEMENT = 0;
  private static final int METHODID_FIND_ANNOUNCEMENTS = 1;
  private static final int METHODID_UPDATE_ANNOUNCEMENT = 2;
  private static final int METHODID_DELETE_ANNOUNCEMENT = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AnnouncementServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AnnouncementServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_ANNOUNCEMENT:
          serviceImpl.createAnnouncement((Announcement) request,
              (io.grpc.stub.StreamObserver<Announcement>) responseObserver);
          break;
        case METHODID_FIND_ANNOUNCEMENTS:
          serviceImpl.findAnnouncements((SearchField) request,
              (io.grpc.stub.StreamObserver<Announcements>) responseObserver);
          break;
        case METHODID_UPDATE_ANNOUNCEMENT:
          serviceImpl.updateAnnouncement((Announcement) request,
              (io.grpc.stub.StreamObserver<Void>) responseObserver);
          break;
        case METHODID_DELETE_ANNOUNCEMENT:
          serviceImpl.deleteAnnouncement((Announcement) request,
              (io.grpc.stub.StreamObserver<Void>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @Override
    @SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class AnnouncementServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return Protobuf.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (AnnouncementServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AnnouncementServiceDescriptorSupplier())
              .addMethod(METHOD_CREATE_ANNOUNCEMENT)
              .addMethod(METHOD_FIND_ANNOUNCEMENTS)
              .addMethod(METHOD_UPDATE_ANNOUNCEMENT)
              .addMethod(METHOD_DELETE_ANNOUNCEMENT)
              .build();
        }
      }
    }
    return result;
  }
}

package origin.protobuf;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.39.0)",
    comments = "Source: protobuf.proto")
public final class AnnouncementServiceGrpc {

  private AnnouncementServiceGrpc() {}

  public static final String SERVICE_NAME = "AnnouncementService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<origin.protobuf.AnnouncementProto,
      origin.protobuf.AnnouncementProto> getCreateAnnouncementMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateAnnouncement",
      requestType = origin.protobuf.AnnouncementProto.class,
      responseType = origin.protobuf.AnnouncementProto.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<origin.protobuf.AnnouncementProto,
      origin.protobuf.AnnouncementProto> getCreateAnnouncementMethod() {
    io.grpc.MethodDescriptor<origin.protobuf.AnnouncementProto, origin.protobuf.AnnouncementProto> getCreateAnnouncementMethod;
    if ((getCreateAnnouncementMethod = AnnouncementServiceGrpc.getCreateAnnouncementMethod) == null) {
      synchronized (AnnouncementServiceGrpc.class) {
        if ((getCreateAnnouncementMethod = AnnouncementServiceGrpc.getCreateAnnouncementMethod) == null) {
          AnnouncementServiceGrpc.getCreateAnnouncementMethod = getCreateAnnouncementMethod =
              io.grpc.MethodDescriptor.<origin.protobuf.AnnouncementProto, origin.protobuf.AnnouncementProto>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateAnnouncement"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  origin.protobuf.AnnouncementProto.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  origin.protobuf.AnnouncementProto.getDefaultInstance()))
              .setSchemaDescriptor(new AnnouncementServiceMethodDescriptorSupplier("CreateAnnouncement"))
              .build();
        }
      }
    }
    return getCreateAnnouncementMethod;
  }

  private static volatile io.grpc.MethodDescriptor<origin.protobuf.SearchAnnouncementProto,
      origin.protobuf.AnnouncementsProto> getFindAnnouncementsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FindAnnouncements",
      requestType = origin.protobuf.SearchAnnouncementProto.class,
      responseType = origin.protobuf.AnnouncementsProto.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<origin.protobuf.SearchAnnouncementProto,
      origin.protobuf.AnnouncementsProto> getFindAnnouncementsMethod() {
    io.grpc.MethodDescriptor<origin.protobuf.SearchAnnouncementProto, origin.protobuf.AnnouncementsProto> getFindAnnouncementsMethod;
    if ((getFindAnnouncementsMethod = AnnouncementServiceGrpc.getFindAnnouncementsMethod) == null) {
      synchronized (AnnouncementServiceGrpc.class) {
        if ((getFindAnnouncementsMethod = AnnouncementServiceGrpc.getFindAnnouncementsMethod) == null) {
          AnnouncementServiceGrpc.getFindAnnouncementsMethod = getFindAnnouncementsMethod =
              io.grpc.MethodDescriptor.<origin.protobuf.SearchAnnouncementProto, origin.protobuf.AnnouncementsProto>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FindAnnouncements"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  origin.protobuf.SearchAnnouncementProto.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  origin.protobuf.AnnouncementsProto.getDefaultInstance()))
              .setSchemaDescriptor(new AnnouncementServiceMethodDescriptorSupplier("FindAnnouncements"))
              .build();
        }
      }
    }
    return getFindAnnouncementsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<origin.protobuf.FindAnnouncementProto,
      origin.protobuf.AnnouncementProto> getGetAnnouncementMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAnnouncement",
      requestType = origin.protobuf.FindAnnouncementProto.class,
      responseType = origin.protobuf.AnnouncementProto.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<origin.protobuf.FindAnnouncementProto,
      origin.protobuf.AnnouncementProto> getGetAnnouncementMethod() {
    io.grpc.MethodDescriptor<origin.protobuf.FindAnnouncementProto, origin.protobuf.AnnouncementProto> getGetAnnouncementMethod;
    if ((getGetAnnouncementMethod = AnnouncementServiceGrpc.getGetAnnouncementMethod) == null) {
      synchronized (AnnouncementServiceGrpc.class) {
        if ((getGetAnnouncementMethod = AnnouncementServiceGrpc.getGetAnnouncementMethod) == null) {
          AnnouncementServiceGrpc.getGetAnnouncementMethod = getGetAnnouncementMethod =
              io.grpc.MethodDescriptor.<origin.protobuf.FindAnnouncementProto, origin.protobuf.AnnouncementProto>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAnnouncement"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  origin.protobuf.FindAnnouncementProto.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  origin.protobuf.AnnouncementProto.getDefaultInstance()))
              .setSchemaDescriptor(new AnnouncementServiceMethodDescriptorSupplier("GetAnnouncement"))
              .build();
        }
      }
    }
    return getGetAnnouncementMethod;
  }

  private static volatile io.grpc.MethodDescriptor<origin.protobuf.AnnouncementProto,
      origin.protobuf.AnnouncementProto> getUpdateAnnouncementMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateAnnouncement",
      requestType = origin.protobuf.AnnouncementProto.class,
      responseType = origin.protobuf.AnnouncementProto.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<origin.protobuf.AnnouncementProto,
      origin.protobuf.AnnouncementProto> getUpdateAnnouncementMethod() {
    io.grpc.MethodDescriptor<origin.protobuf.AnnouncementProto, origin.protobuf.AnnouncementProto> getUpdateAnnouncementMethod;
    if ((getUpdateAnnouncementMethod = AnnouncementServiceGrpc.getUpdateAnnouncementMethod) == null) {
      synchronized (AnnouncementServiceGrpc.class) {
        if ((getUpdateAnnouncementMethod = AnnouncementServiceGrpc.getUpdateAnnouncementMethod) == null) {
          AnnouncementServiceGrpc.getUpdateAnnouncementMethod = getUpdateAnnouncementMethod =
              io.grpc.MethodDescriptor.<origin.protobuf.AnnouncementProto, origin.protobuf.AnnouncementProto>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateAnnouncement"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  origin.protobuf.AnnouncementProto.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  origin.protobuf.AnnouncementProto.getDefaultInstance()))
              .setSchemaDescriptor(new AnnouncementServiceMethodDescriptorSupplier("UpdateAnnouncement"))
              .build();
        }
      }
    }
    return getUpdateAnnouncementMethod;
  }

  private static volatile io.grpc.MethodDescriptor<origin.protobuf.FindAnnouncementProto,
      origin.protobuf.ResponseStatus> getDeleteAnnouncementMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteAnnouncement",
      requestType = origin.protobuf.FindAnnouncementProto.class,
      responseType = origin.protobuf.ResponseStatus.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<origin.protobuf.FindAnnouncementProto,
      origin.protobuf.ResponseStatus> getDeleteAnnouncementMethod() {
    io.grpc.MethodDescriptor<origin.protobuf.FindAnnouncementProto, origin.protobuf.ResponseStatus> getDeleteAnnouncementMethod;
    if ((getDeleteAnnouncementMethod = AnnouncementServiceGrpc.getDeleteAnnouncementMethod) == null) {
      synchronized (AnnouncementServiceGrpc.class) {
        if ((getDeleteAnnouncementMethod = AnnouncementServiceGrpc.getDeleteAnnouncementMethod) == null) {
          AnnouncementServiceGrpc.getDeleteAnnouncementMethod = getDeleteAnnouncementMethod =
              io.grpc.MethodDescriptor.<origin.protobuf.FindAnnouncementProto, origin.protobuf.ResponseStatus>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteAnnouncement"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  origin.protobuf.FindAnnouncementProto.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  origin.protobuf.ResponseStatus.getDefaultInstance()))
              .setSchemaDescriptor(new AnnouncementServiceMethodDescriptorSupplier("DeleteAnnouncement"))
              .build();
        }
      }
    }
    return getDeleteAnnouncementMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AnnouncementServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AnnouncementServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AnnouncementServiceStub>() {
        @java.lang.Override
        public AnnouncementServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AnnouncementServiceStub(channel, callOptions);
        }
      };
    return AnnouncementServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AnnouncementServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AnnouncementServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AnnouncementServiceBlockingStub>() {
        @java.lang.Override
        public AnnouncementServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AnnouncementServiceBlockingStub(channel, callOptions);
        }
      };
    return AnnouncementServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AnnouncementServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AnnouncementServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AnnouncementServiceFutureStub>() {
        @java.lang.Override
        public AnnouncementServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AnnouncementServiceFutureStub(channel, callOptions);
        }
      };
    return AnnouncementServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class AnnouncementServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void createAnnouncement(origin.protobuf.AnnouncementProto request,
        io.grpc.stub.StreamObserver<origin.protobuf.AnnouncementProto> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateAnnouncementMethod(), responseObserver);
    }

    /**
     */
    public void findAnnouncements(origin.protobuf.SearchAnnouncementProto request,
        io.grpc.stub.StreamObserver<origin.protobuf.AnnouncementsProto> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFindAnnouncementsMethod(), responseObserver);
    }

    /**
     */
    public void getAnnouncement(origin.protobuf.FindAnnouncementProto request,
        io.grpc.stub.StreamObserver<origin.protobuf.AnnouncementProto> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAnnouncementMethod(), responseObserver);
    }

    /**
     */
    public void updateAnnouncement(origin.protobuf.AnnouncementProto request,
        io.grpc.stub.StreamObserver<origin.protobuf.AnnouncementProto> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateAnnouncementMethod(), responseObserver);
    }

    /**
     */
    public void deleteAnnouncement(origin.protobuf.FindAnnouncementProto request,
        io.grpc.stub.StreamObserver<origin.protobuf.ResponseStatus> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteAnnouncementMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateAnnouncementMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                origin.protobuf.AnnouncementProto,
                origin.protobuf.AnnouncementProto>(
                  this, METHODID_CREATE_ANNOUNCEMENT)))
          .addMethod(
            getFindAnnouncementsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                origin.protobuf.SearchAnnouncementProto,
                origin.protobuf.AnnouncementsProto>(
                  this, METHODID_FIND_ANNOUNCEMENTS)))
          .addMethod(
            getGetAnnouncementMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                origin.protobuf.FindAnnouncementProto,
                origin.protobuf.AnnouncementProto>(
                  this, METHODID_GET_ANNOUNCEMENT)))
          .addMethod(
            getUpdateAnnouncementMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                origin.protobuf.AnnouncementProto,
                origin.protobuf.AnnouncementProto>(
                  this, METHODID_UPDATE_ANNOUNCEMENT)))
          .addMethod(
            getDeleteAnnouncementMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                origin.protobuf.FindAnnouncementProto,
                origin.protobuf.ResponseStatus>(
                  this, METHODID_DELETE_ANNOUNCEMENT)))
          .build();
    }
  }

  /**
   */
  public static final class AnnouncementServiceStub extends io.grpc.stub.AbstractAsyncStub<AnnouncementServiceStub> {
    private AnnouncementServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AnnouncementServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AnnouncementServiceStub(channel, callOptions);
    }

    /**
     */
    public void createAnnouncement(origin.protobuf.AnnouncementProto request,
        io.grpc.stub.StreamObserver<origin.protobuf.AnnouncementProto> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateAnnouncementMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void findAnnouncements(origin.protobuf.SearchAnnouncementProto request,
        io.grpc.stub.StreamObserver<origin.protobuf.AnnouncementsProto> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFindAnnouncementsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAnnouncement(origin.protobuf.FindAnnouncementProto request,
        io.grpc.stub.StreamObserver<origin.protobuf.AnnouncementProto> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAnnouncementMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateAnnouncement(origin.protobuf.AnnouncementProto request,
        io.grpc.stub.StreamObserver<origin.protobuf.AnnouncementProto> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateAnnouncementMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteAnnouncement(origin.protobuf.FindAnnouncementProto request,
        io.grpc.stub.StreamObserver<origin.protobuf.ResponseStatus> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteAnnouncementMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class AnnouncementServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<AnnouncementServiceBlockingStub> {
    private AnnouncementServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AnnouncementServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AnnouncementServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public origin.protobuf.AnnouncementProto createAnnouncement(origin.protobuf.AnnouncementProto request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateAnnouncementMethod(), getCallOptions(), request);
    }

    /**
     */
    public origin.protobuf.AnnouncementsProto findAnnouncements(origin.protobuf.SearchAnnouncementProto request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFindAnnouncementsMethod(), getCallOptions(), request);
    }

    /**
     */
    public origin.protobuf.AnnouncementProto getAnnouncement(origin.protobuf.FindAnnouncementProto request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAnnouncementMethod(), getCallOptions(), request);
    }

    /**
     */
    public origin.protobuf.AnnouncementProto updateAnnouncement(origin.protobuf.AnnouncementProto request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateAnnouncementMethod(), getCallOptions(), request);
    }

    /**
     */
    public origin.protobuf.ResponseStatus deleteAnnouncement(origin.protobuf.FindAnnouncementProto request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteAnnouncementMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class AnnouncementServiceFutureStub extends io.grpc.stub.AbstractFutureStub<AnnouncementServiceFutureStub> {
    private AnnouncementServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AnnouncementServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AnnouncementServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<origin.protobuf.AnnouncementProto> createAnnouncement(
        origin.protobuf.AnnouncementProto request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateAnnouncementMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<origin.protobuf.AnnouncementsProto> findAnnouncements(
        origin.protobuf.SearchAnnouncementProto request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFindAnnouncementsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<origin.protobuf.AnnouncementProto> getAnnouncement(
        origin.protobuf.FindAnnouncementProto request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAnnouncementMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<origin.protobuf.AnnouncementProto> updateAnnouncement(
        origin.protobuf.AnnouncementProto request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateAnnouncementMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<origin.protobuf.ResponseStatus> deleteAnnouncement(
        origin.protobuf.FindAnnouncementProto request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteAnnouncementMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_ANNOUNCEMENT = 0;
  private static final int METHODID_FIND_ANNOUNCEMENTS = 1;
  private static final int METHODID_GET_ANNOUNCEMENT = 2;
  private static final int METHODID_UPDATE_ANNOUNCEMENT = 3;
  private static final int METHODID_DELETE_ANNOUNCEMENT = 4;

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

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_ANNOUNCEMENT:
          serviceImpl.createAnnouncement((origin.protobuf.AnnouncementProto) request,
              (io.grpc.stub.StreamObserver<origin.protobuf.AnnouncementProto>) responseObserver);
          break;
        case METHODID_FIND_ANNOUNCEMENTS:
          serviceImpl.findAnnouncements((origin.protobuf.SearchAnnouncementProto) request,
              (io.grpc.stub.StreamObserver<origin.protobuf.AnnouncementsProto>) responseObserver);
          break;
        case METHODID_GET_ANNOUNCEMENT:
          serviceImpl.getAnnouncement((origin.protobuf.FindAnnouncementProto) request,
              (io.grpc.stub.StreamObserver<origin.protobuf.AnnouncementProto>) responseObserver);
          break;
        case METHODID_UPDATE_ANNOUNCEMENT:
          serviceImpl.updateAnnouncement((origin.protobuf.AnnouncementProto) request,
              (io.grpc.stub.StreamObserver<origin.protobuf.AnnouncementProto>) responseObserver);
          break;
        case METHODID_DELETE_ANNOUNCEMENT:
          serviceImpl.deleteAnnouncement((origin.protobuf.FindAnnouncementProto) request,
              (io.grpc.stub.StreamObserver<origin.protobuf.ResponseStatus>) responseObserver);
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

  private static abstract class AnnouncementServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AnnouncementServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return origin.protobuf.Protobuf.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AnnouncementService");
    }
  }

  private static final class AnnouncementServiceFileDescriptorSupplier
      extends AnnouncementServiceBaseDescriptorSupplier {
    AnnouncementServiceFileDescriptorSupplier() {}
  }

  private static final class AnnouncementServiceMethodDescriptorSupplier
      extends AnnouncementServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AnnouncementServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (AnnouncementServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AnnouncementServiceFileDescriptorSupplier())
              .addMethod(getCreateAnnouncementMethod())
              .addMethod(getFindAnnouncementsMethod())
              .addMethod(getGetAnnouncementMethod())
              .addMethod(getUpdateAnnouncementMethod())
              .addMethod(getDeleteAnnouncementMethod())
              .build();
        }
      }
    }
    return result;
  }
}

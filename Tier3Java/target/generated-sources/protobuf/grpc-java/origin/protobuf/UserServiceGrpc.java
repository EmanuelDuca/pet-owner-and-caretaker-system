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
public final class UserServiceGrpc {

  private UserServiceGrpc() {}

  public static final String SERVICE_NAME = "UserService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<origin.protobuf.UserProto,
      origin.protobuf.UserProto> METHOD_CREATE_USER =
      io.grpc.MethodDescriptor.<origin.protobuf.UserProto, origin.protobuf.UserProto>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "UserService", "CreateUser"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              origin.protobuf.UserProto.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              origin.protobuf.UserProto.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<origin.protobuf.LoginUserProto,
      origin.protobuf.UserProto> METHOD_LOG_IN =
      io.grpc.MethodDescriptor.<origin.protobuf.LoginUserProto, origin.protobuf.UserProto>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "UserService", "LogIn"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              origin.protobuf.LoginUserProto.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              origin.protobuf.UserProto.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<origin.protobuf.FindUserProto,
      origin.protobuf.UserProto> METHOD_FIND_USER =
      io.grpc.MethodDescriptor.<origin.protobuf.FindUserProto, origin.protobuf.UserProto>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "UserService", "FindUser"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              origin.protobuf.FindUserProto.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              origin.protobuf.UserProto.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<origin.protobuf.SearchUsersProto,
      origin.protobuf.UsersProto> METHOD_SEARCH_USER =
      io.grpc.MethodDescriptor.<origin.protobuf.SearchUsersProto, origin.protobuf.UsersProto>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "UserService", "SearchUser"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              origin.protobuf.SearchUsersProto.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              origin.protobuf.UsersProto.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<origin.protobuf.UserProto,
      origin.protobuf.UserProto> METHOD_UPDATE_USER =
      io.grpc.MethodDescriptor.<origin.protobuf.UserProto, origin.protobuf.UserProto>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "UserService", "UpdateUser"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              origin.protobuf.UserProto.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              origin.protobuf.UserProto.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<origin.protobuf.FindUserProto,
      origin.protobuf.ResponseStatus> METHOD_DELETE_USER =
      io.grpc.MethodDescriptor.<origin.protobuf.FindUserProto, origin.protobuf.ResponseStatus>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "UserService", "DeleteUser"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              origin.protobuf.FindUserProto.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              origin.protobuf.ResponseStatus.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<origin.protobuf.AnnouncementProto,
      origin.protobuf.Void> METHOD_START_SERVICE =
      io.grpc.MethodDescriptor.<origin.protobuf.AnnouncementProto, origin.protobuf.Void>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "UserService", "StartService"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              origin.protobuf.AnnouncementProto.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              origin.protobuf.Void.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static UserServiceStub newStub(io.grpc.Channel channel) {
    return new UserServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UserServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new UserServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static UserServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new UserServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class UserServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void createUser(origin.protobuf.UserProto request,
        io.grpc.stub.StreamObserver<origin.protobuf.UserProto> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_CREATE_USER, responseObserver);
    }

    /**
     */
    public void logIn(origin.protobuf.LoginUserProto request,
        io.grpc.stub.StreamObserver<origin.protobuf.UserProto> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_LOG_IN, responseObserver);
    }

    /**
     */
    public void findUser(origin.protobuf.FindUserProto request,
        io.grpc.stub.StreamObserver<origin.protobuf.UserProto> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_FIND_USER, responseObserver);
    }

    /**
     */
    public void searchUser(origin.protobuf.SearchUsersProto request,
        io.grpc.stub.StreamObserver<origin.protobuf.UsersProto> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SEARCH_USER, responseObserver);
    }

    /**
     */
    public void updateUser(origin.protobuf.UserProto request,
        io.grpc.stub.StreamObserver<origin.protobuf.UserProto> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_UPDATE_USER, responseObserver);
    }

    /**
     */
    public void deleteUser(origin.protobuf.FindUserProto request,
        io.grpc.stub.StreamObserver<origin.protobuf.ResponseStatus> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_DELETE_USER, responseObserver);
    }

    /**
     */
    public void startService(origin.protobuf.AnnouncementProto request,
        io.grpc.stub.StreamObserver<origin.protobuf.Void> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_START_SERVICE, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_CREATE_USER,
            asyncUnaryCall(
              new MethodHandlers<
                origin.protobuf.UserProto,
                origin.protobuf.UserProto>(
                  this, METHODID_CREATE_USER)))
          .addMethod(
            METHOD_LOG_IN,
            asyncUnaryCall(
              new MethodHandlers<
                origin.protobuf.LoginUserProto,
                origin.protobuf.UserProto>(
                  this, METHODID_LOG_IN)))
          .addMethod(
            METHOD_FIND_USER,
            asyncUnaryCall(
              new MethodHandlers<
                origin.protobuf.FindUserProto,
                origin.protobuf.UserProto>(
                  this, METHODID_FIND_USER)))
          .addMethod(
            METHOD_SEARCH_USER,
            asyncUnaryCall(
              new MethodHandlers<
                origin.protobuf.SearchUsersProto,
                origin.protobuf.UsersProto>(
                  this, METHODID_SEARCH_USER)))
          .addMethod(
            METHOD_UPDATE_USER,
            asyncUnaryCall(
              new MethodHandlers<
                origin.protobuf.UserProto,
                origin.protobuf.UserProto>(
                  this, METHODID_UPDATE_USER)))
          .addMethod(
            METHOD_DELETE_USER,
            asyncUnaryCall(
              new MethodHandlers<
                origin.protobuf.FindUserProto,
                origin.protobuf.ResponseStatus>(
                  this, METHODID_DELETE_USER)))
          .addMethod(
            METHOD_START_SERVICE,
            asyncUnaryCall(
              new MethodHandlers<
                origin.protobuf.AnnouncementProto,
                origin.protobuf.Void>(
                  this, METHODID_START_SERVICE)))
          .build();
    }
  }

  /**
   */
  public static final class UserServiceStub extends io.grpc.stub.AbstractStub<UserServiceStub> {
    private UserServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserServiceStub(channel, callOptions);
    }

    /**
     */
    public void createUser(origin.protobuf.UserProto request,
        io.grpc.stub.StreamObserver<origin.protobuf.UserProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_CREATE_USER, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void logIn(origin.protobuf.LoginUserProto request,
        io.grpc.stub.StreamObserver<origin.protobuf.UserProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_LOG_IN, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void findUser(origin.protobuf.FindUserProto request,
        io.grpc.stub.StreamObserver<origin.protobuf.UserProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_FIND_USER, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void searchUser(origin.protobuf.SearchUsersProto request,
        io.grpc.stub.StreamObserver<origin.protobuf.UsersProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SEARCH_USER, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateUser(origin.protobuf.UserProto request,
        io.grpc.stub.StreamObserver<origin.protobuf.UserProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_UPDATE_USER, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteUser(origin.protobuf.FindUserProto request,
        io.grpc.stub.StreamObserver<origin.protobuf.ResponseStatus> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_DELETE_USER, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void startService(origin.protobuf.AnnouncementProto request,
        io.grpc.stub.StreamObserver<origin.protobuf.Void> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_START_SERVICE, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class UserServiceBlockingStub extends io.grpc.stub.AbstractStub<UserServiceBlockingStub> {
    private UserServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public origin.protobuf.UserProto createUser(origin.protobuf.UserProto request) {
      return blockingUnaryCall(
          getChannel(), METHOD_CREATE_USER, getCallOptions(), request);
    }

    /**
     */
    public origin.protobuf.UserProto logIn(origin.protobuf.LoginUserProto request) {
      return blockingUnaryCall(
          getChannel(), METHOD_LOG_IN, getCallOptions(), request);
    }

    /**
     */
    public origin.protobuf.UserProto findUser(origin.protobuf.FindUserProto request) {
      return blockingUnaryCall(
          getChannel(), METHOD_FIND_USER, getCallOptions(), request);
    }

    /**
     */
    public origin.protobuf.UsersProto searchUser(origin.protobuf.SearchUsersProto request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SEARCH_USER, getCallOptions(), request);
    }

    /**
     */
    public origin.protobuf.UserProto updateUser(origin.protobuf.UserProto request) {
      return blockingUnaryCall(
          getChannel(), METHOD_UPDATE_USER, getCallOptions(), request);
    }

    /**
     */
    public origin.protobuf.ResponseStatus deleteUser(origin.protobuf.FindUserProto request) {
      return blockingUnaryCall(
          getChannel(), METHOD_DELETE_USER, getCallOptions(), request);
    }

    /**
     */
    public origin.protobuf.Void startService(origin.protobuf.AnnouncementProto request) {
      return blockingUnaryCall(
          getChannel(), METHOD_START_SERVICE, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class UserServiceFutureStub extends io.grpc.stub.AbstractStub<UserServiceFutureStub> {
    private UserServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<origin.protobuf.UserProto> createUser(
        origin.protobuf.UserProto request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_CREATE_USER, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<origin.protobuf.UserProto> logIn(
        origin.protobuf.LoginUserProto request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_LOG_IN, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<origin.protobuf.UserProto> findUser(
        origin.protobuf.FindUserProto request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_FIND_USER, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<origin.protobuf.UsersProto> searchUser(
        origin.protobuf.SearchUsersProto request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SEARCH_USER, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<origin.protobuf.UserProto> updateUser(
        origin.protobuf.UserProto request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_UPDATE_USER, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<origin.protobuf.ResponseStatus> deleteUser(
        origin.protobuf.FindUserProto request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_DELETE_USER, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<origin.protobuf.Void> startService(
        origin.protobuf.AnnouncementProto request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_START_SERVICE, getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_USER = 0;
  private static final int METHODID_LOG_IN = 1;
  private static final int METHODID_FIND_USER = 2;
  private static final int METHODID_SEARCH_USER = 3;
  private static final int METHODID_UPDATE_USER = 4;
  private static final int METHODID_DELETE_USER = 5;
  private static final int METHODID_START_SERVICE = 6;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final UserServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(UserServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_USER:
          serviceImpl.createUser((origin.protobuf.UserProto) request,
              (io.grpc.stub.StreamObserver<origin.protobuf.UserProto>) responseObserver);
          break;
        case METHODID_LOG_IN:
          serviceImpl.logIn((origin.protobuf.LoginUserProto) request,
              (io.grpc.stub.StreamObserver<origin.protobuf.UserProto>) responseObserver);
          break;
        case METHODID_FIND_USER:
          serviceImpl.findUser((origin.protobuf.FindUserProto) request,
              (io.grpc.stub.StreamObserver<origin.protobuf.UserProto>) responseObserver);
          break;
        case METHODID_SEARCH_USER:
          serviceImpl.searchUser((origin.protobuf.SearchUsersProto) request,
              (io.grpc.stub.StreamObserver<origin.protobuf.UsersProto>) responseObserver);
          break;
        case METHODID_UPDATE_USER:
          serviceImpl.updateUser((origin.protobuf.UserProto) request,
              (io.grpc.stub.StreamObserver<origin.protobuf.UserProto>) responseObserver);
          break;
        case METHODID_DELETE_USER:
          serviceImpl.deleteUser((origin.protobuf.FindUserProto) request,
              (io.grpc.stub.StreamObserver<origin.protobuf.ResponseStatus>) responseObserver);
          break;
        case METHODID_START_SERVICE:
          serviceImpl.startService((origin.protobuf.AnnouncementProto) request,
              (io.grpc.stub.StreamObserver<origin.protobuf.Void>) responseObserver);
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

  private static final class UserServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return origin.protobuf.Protobuf.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (UserServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new UserServiceDescriptorSupplier())
              .addMethod(METHOD_CREATE_USER)
              .addMethod(METHOD_LOG_IN)
              .addMethod(METHOD_FIND_USER)
              .addMethod(METHOD_SEARCH_USER)
              .addMethod(METHOD_UPDATE_USER)
              .addMethod(METHOD_DELETE_USER)
              .addMethod(METHOD_START_SERVICE)
              .build();
        }
      }
    }
    return result;
  }
}

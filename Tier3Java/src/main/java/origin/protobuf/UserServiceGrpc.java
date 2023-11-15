package origin.protobuf;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.39.0)",
    comments = "Source: protobuf.proto")
public final class UserServiceGrpc {

  private UserServiceGrpc() {}

  public static final String SERVICE_NAME = "UserService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<origin.protobuf.UserProto,
      origin.protobuf.UserProto> getCreateUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateUser",
      requestType = origin.protobuf.UserProto.class,
      responseType = origin.protobuf.UserProto.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<origin.protobuf.UserProto,
      origin.protobuf.UserProto> getCreateUserMethod() {
    io.grpc.MethodDescriptor<origin.protobuf.UserProto, origin.protobuf.UserProto> getCreateUserMethod;
    if ((getCreateUserMethod = UserServiceGrpc.getCreateUserMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getCreateUserMethod = UserServiceGrpc.getCreateUserMethod) == null) {
          UserServiceGrpc.getCreateUserMethod = getCreateUserMethod =
              io.grpc.MethodDescriptor.<origin.protobuf.UserProto, origin.protobuf.UserProto>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  origin.protobuf.UserProto.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  origin.protobuf.UserProto.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("CreateUser"))
              .build();
        }
      }
    }
    return getCreateUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<origin.protobuf.LoginUserProto,
      origin.protobuf.UserProto> getLogInMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LogIn",
      requestType = origin.protobuf.LoginUserProto.class,
      responseType = origin.protobuf.UserProto.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<origin.protobuf.LoginUserProto,
      origin.protobuf.UserProto> getLogInMethod() {
    io.grpc.MethodDescriptor<origin.protobuf.LoginUserProto, origin.protobuf.UserProto> getLogInMethod;
    if ((getLogInMethod = UserServiceGrpc.getLogInMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getLogInMethod = UserServiceGrpc.getLogInMethod) == null) {
          UserServiceGrpc.getLogInMethod = getLogInMethod =
              io.grpc.MethodDescriptor.<origin.protobuf.LoginUserProto, origin.protobuf.UserProto>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "LogIn"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  origin.protobuf.LoginUserProto.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  origin.protobuf.UserProto.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("LogIn"))
              .build();
        }
      }
    }
    return getLogInMethod;
  }

  private static volatile io.grpc.MethodDescriptor<origin.protobuf.FindUserProto,
      origin.protobuf.UserProto> getFindUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FindUser",
      requestType = origin.protobuf.FindUserProto.class,
      responseType = origin.protobuf.UserProto.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<origin.protobuf.FindUserProto,
      origin.protobuf.UserProto> getFindUserMethod() {
    io.grpc.MethodDescriptor<origin.protobuf.FindUserProto, origin.protobuf.UserProto> getFindUserMethod;
    if ((getFindUserMethod = UserServiceGrpc.getFindUserMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getFindUserMethod = UserServiceGrpc.getFindUserMethod) == null) {
          UserServiceGrpc.getFindUserMethod = getFindUserMethod =
              io.grpc.MethodDescriptor.<origin.protobuf.FindUserProto, origin.protobuf.UserProto>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FindUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  origin.protobuf.FindUserProto.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  origin.protobuf.UserProto.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("FindUser"))
              .build();
        }
      }
    }
    return getFindUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<origin.protobuf.SearchUsersProto,
      origin.protobuf.UsersProto> getSearchUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchUser",
      requestType = origin.protobuf.SearchUsersProto.class,
      responseType = origin.protobuf.UsersProto.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<origin.protobuf.SearchUsersProto,
      origin.protobuf.UsersProto> getSearchUserMethod() {
    io.grpc.MethodDescriptor<origin.protobuf.SearchUsersProto, origin.protobuf.UsersProto> getSearchUserMethod;
    if ((getSearchUserMethod = UserServiceGrpc.getSearchUserMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getSearchUserMethod = UserServiceGrpc.getSearchUserMethod) == null) {
          UserServiceGrpc.getSearchUserMethod = getSearchUserMethod =
              io.grpc.MethodDescriptor.<origin.protobuf.SearchUsersProto, origin.protobuf.UsersProto>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SearchUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  origin.protobuf.SearchUsersProto.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  origin.protobuf.UsersProto.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("SearchUser"))
              .build();
        }
      }
    }
    return getSearchUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<origin.protobuf.UserProto,
      origin.protobuf.UserProto> getUpdateUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateUser",
      requestType = origin.protobuf.UserProto.class,
      responseType = origin.protobuf.UserProto.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<origin.protobuf.UserProto,
      origin.protobuf.UserProto> getUpdateUserMethod() {
    io.grpc.MethodDescriptor<origin.protobuf.UserProto, origin.protobuf.UserProto> getUpdateUserMethod;
    if ((getUpdateUserMethod = UserServiceGrpc.getUpdateUserMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getUpdateUserMethod = UserServiceGrpc.getUpdateUserMethod) == null) {
          UserServiceGrpc.getUpdateUserMethod = getUpdateUserMethod =
              io.grpc.MethodDescriptor.<origin.protobuf.UserProto, origin.protobuf.UserProto>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  origin.protobuf.UserProto.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  origin.protobuf.UserProto.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("UpdateUser"))
              .build();
        }
      }
    }
    return getUpdateUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<origin.protobuf.FindUserProto,
      origin.protobuf.ResponseStatus> getDeleteUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteUser",
      requestType = origin.protobuf.FindUserProto.class,
      responseType = origin.protobuf.ResponseStatus.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<origin.protobuf.FindUserProto,
      origin.protobuf.ResponseStatus> getDeleteUserMethod() {
    io.grpc.MethodDescriptor<origin.protobuf.FindUserProto, origin.protobuf.ResponseStatus> getDeleteUserMethod;
    if ((getDeleteUserMethod = UserServiceGrpc.getDeleteUserMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getDeleteUserMethod = UserServiceGrpc.getDeleteUserMethod) == null) {
          UserServiceGrpc.getDeleteUserMethod = getDeleteUserMethod =
              io.grpc.MethodDescriptor.<origin.protobuf.FindUserProto, origin.protobuf.ResponseStatus>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  origin.protobuf.FindUserProto.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  origin.protobuf.ResponseStatus.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("DeleteUser"))
              .build();
        }
      }
    }
    return getDeleteUserMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static UserServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UserServiceStub>() {
        @java.lang.Override
        public UserServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UserServiceStub(channel, callOptions);
        }
      };
    return UserServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UserServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UserServiceBlockingStub>() {
        @java.lang.Override
        public UserServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UserServiceBlockingStub(channel, callOptions);
        }
      };
    return UserServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static UserServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UserServiceFutureStub>() {
        @java.lang.Override
        public UserServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UserServiceFutureStub(channel, callOptions);
        }
      };
    return UserServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class UserServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void createUser(origin.protobuf.UserProto request,
        io.grpc.stub.StreamObserver<origin.protobuf.UserProto> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateUserMethod(), responseObserver);
    }

    /**
     */
    public void logIn(origin.protobuf.LoginUserProto request,
        io.grpc.stub.StreamObserver<origin.protobuf.UserProto> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getLogInMethod(), responseObserver);
    }

    /**
     */
    public void findUser(origin.protobuf.FindUserProto request,
        io.grpc.stub.StreamObserver<origin.protobuf.UserProto> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFindUserMethod(), responseObserver);
    }

    /**
     */
    public void searchUser(origin.protobuf.SearchUsersProto request,
        io.grpc.stub.StreamObserver<origin.protobuf.UsersProto> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSearchUserMethod(), responseObserver);
    }

    /**
     */
    public void updateUser(origin.protobuf.UserProto request,
        io.grpc.stub.StreamObserver<origin.protobuf.UserProto> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateUserMethod(), responseObserver);
    }

    /**
     */
    public void deleteUser(origin.protobuf.FindUserProto request,
        io.grpc.stub.StreamObserver<origin.protobuf.ResponseStatus> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteUserMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateUserMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                origin.protobuf.UserProto,
                origin.protobuf.UserProto>(
                  this, METHODID_CREATE_USER)))
          .addMethod(
            getLogInMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                origin.protobuf.LoginUserProto,
                origin.protobuf.UserProto>(
                  this, METHODID_LOG_IN)))
          .addMethod(
            getFindUserMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                origin.protobuf.FindUserProto,
                origin.protobuf.UserProto>(
                  this, METHODID_FIND_USER)))
          .addMethod(
            getSearchUserMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                origin.protobuf.SearchUsersProto,
                origin.protobuf.UsersProto>(
                  this, METHODID_SEARCH_USER)))
          .addMethod(
            getUpdateUserMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                origin.protobuf.UserProto,
                origin.protobuf.UserProto>(
                  this, METHODID_UPDATE_USER)))
          .addMethod(
            getDeleteUserMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                origin.protobuf.FindUserProto,
                origin.protobuf.ResponseStatus>(
                  this, METHODID_DELETE_USER)))
          .build();
    }
  }

  /**
   */
  public static final class UserServiceStub extends io.grpc.stub.AbstractAsyncStub<UserServiceStub> {
    private UserServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserServiceStub(channel, callOptions);
    }

    /**
     */
    public void createUser(origin.protobuf.UserProto request,
        io.grpc.stub.StreamObserver<origin.protobuf.UserProto> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void logIn(origin.protobuf.LoginUserProto request,
        io.grpc.stub.StreamObserver<origin.protobuf.UserProto> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getLogInMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void findUser(origin.protobuf.FindUserProto request,
        io.grpc.stub.StreamObserver<origin.protobuf.UserProto> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFindUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void searchUser(origin.protobuf.SearchUsersProto request,
        io.grpc.stub.StreamObserver<origin.protobuf.UsersProto> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSearchUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateUser(origin.protobuf.UserProto request,
        io.grpc.stub.StreamObserver<origin.protobuf.UserProto> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteUser(origin.protobuf.FindUserProto request,
        io.grpc.stub.StreamObserver<origin.protobuf.ResponseStatus> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteUserMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class UserServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<UserServiceBlockingStub> {
    private UserServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public origin.protobuf.UserProto createUser(origin.protobuf.UserProto request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateUserMethod(), getCallOptions(), request);
    }

    /**
     */
    public origin.protobuf.UserProto logIn(origin.protobuf.LoginUserProto request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLogInMethod(), getCallOptions(), request);
    }

    /**
     */
    public origin.protobuf.UserProto findUser(origin.protobuf.FindUserProto request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFindUserMethod(), getCallOptions(), request);
    }

    /**
     */
    public origin.protobuf.UsersProto searchUser(origin.protobuf.SearchUsersProto request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSearchUserMethod(), getCallOptions(), request);
    }

    /**
     */
    public origin.protobuf.UserProto updateUser(origin.protobuf.UserProto request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateUserMethod(), getCallOptions(), request);
    }

    /**
     */
    public origin.protobuf.ResponseStatus deleteUser(origin.protobuf.FindUserProto request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteUserMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class UserServiceFutureStub extends io.grpc.stub.AbstractFutureStub<UserServiceFutureStub> {
    private UserServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<origin.protobuf.UserProto> createUser(
        origin.protobuf.UserProto request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateUserMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<origin.protobuf.UserProto> logIn(
        origin.protobuf.LoginUserProto request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getLogInMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<origin.protobuf.UserProto> findUser(
        origin.protobuf.FindUserProto request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFindUserMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<origin.protobuf.UsersProto> searchUser(
        origin.protobuf.SearchUsersProto request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSearchUserMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<origin.protobuf.UserProto> updateUser(
        origin.protobuf.UserProto request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateUserMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<origin.protobuf.ResponseStatus> deleteUser(
        origin.protobuf.FindUserProto request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteUserMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_USER = 0;
  private static final int METHODID_LOG_IN = 1;
  private static final int METHODID_FIND_USER = 2;
  private static final int METHODID_SEARCH_USER = 3;
  private static final int METHODID_UPDATE_USER = 4;
  private static final int METHODID_DELETE_USER = 5;

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

  private static abstract class UserServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    UserServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return origin.protobuf.Protobuf.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("UserService");
    }
  }

  private static final class UserServiceFileDescriptorSupplier
      extends UserServiceBaseDescriptorSupplier {
    UserServiceFileDescriptorSupplier() {}
  }

  private static final class UserServiceMethodDescriptorSupplier
      extends UserServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    UserServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (UserServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new UserServiceFileDescriptorSupplier())
              .addMethod(getCreateUserMethod())
              .addMethod(getLogInMethod())
              .addMethod(getFindUserMethod())
              .addMethod(getSearchUserMethod())
              .addMethod(getUpdateUserMethod())
              .addMethod(getDeleteUserMethod())
              .build();
        }
      }
    }
    return result;
  }
}

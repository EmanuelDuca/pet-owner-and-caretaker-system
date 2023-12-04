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
      origin.protobuf.UsersProto> METHOD_SEARCH_USERS =
      io.grpc.MethodDescriptor.<origin.protobuf.SearchUsersProto, origin.protobuf.UsersProto>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "UserService", "SearchUsers"))
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
      origin.protobuf.Void> METHOD_DELETE_USER =
      io.grpc.MethodDescriptor.<origin.protobuf.FindUserProto, origin.protobuf.Void>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "UserService", "DeleteUser"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              origin.protobuf.FindUserProto.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              origin.protobuf.Void.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<origin.protobuf.DatePeriodOfCaretaker,
      origin.protobuf.Void> METHOD_ADD_DATE_PERIOD_TO_SCHEDULE_OF_CARETAKER =
      io.grpc.MethodDescriptor.<origin.protobuf.DatePeriodOfCaretaker, origin.protobuf.Void>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "UserService", "AddDatePeriodToScheduleOfCaretaker"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              origin.protobuf.DatePeriodOfCaretaker.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              origin.protobuf.Void.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<origin.protobuf.DatePeriodOfCaretaker,
      origin.protobuf.Void> METHOD_DELETE_DATE_PERIOD_TO_SCHEDULE_OF_CARETAKER =
      io.grpc.MethodDescriptor.<origin.protobuf.DatePeriodOfCaretaker, origin.protobuf.Void>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "UserService", "DeleteDatePeriodToScheduleOfCaretaker"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              origin.protobuf.DatePeriodOfCaretaker.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              origin.protobuf.Void.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<origin.protobuf.CareTakerScheduleRequest,
      origin.protobuf.CaretakerSchedule> METHOD_GET_SCHEDULE_OF_CARETAKER =
      io.grpc.MethodDescriptor.<origin.protobuf.CareTakerScheduleRequest, origin.protobuf.CaretakerSchedule>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "UserService", "GetScheduleOfCaretaker"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              origin.protobuf.CareTakerScheduleRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              origin.protobuf.CaretakerSchedule.getDefaultInstance()))
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
    public void searchUsers(origin.protobuf.SearchUsersProto request,
        io.grpc.stub.StreamObserver<origin.protobuf.UsersProto> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SEARCH_USERS, responseObserver);
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
        io.grpc.stub.StreamObserver<origin.protobuf.Void> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_DELETE_USER, responseObserver);
    }

    /**
     */
    public void addDatePeriodToScheduleOfCaretaker(origin.protobuf.DatePeriodOfCaretaker request,
        io.grpc.stub.StreamObserver<origin.protobuf.Void> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_ADD_DATE_PERIOD_TO_SCHEDULE_OF_CARETAKER, responseObserver);
    }

    /**
     */
    public void deleteDatePeriodToScheduleOfCaretaker(origin.protobuf.DatePeriodOfCaretaker request,
        io.grpc.stub.StreamObserver<origin.protobuf.Void> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_DELETE_DATE_PERIOD_TO_SCHEDULE_OF_CARETAKER, responseObserver);
    }

    /**
     */
    public void getScheduleOfCaretaker(origin.protobuf.CareTakerScheduleRequest request,
        io.grpc.stub.StreamObserver<origin.protobuf.CaretakerSchedule> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_SCHEDULE_OF_CARETAKER, responseObserver);
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
            METHOD_SEARCH_USERS,
            asyncUnaryCall(
              new MethodHandlers<
                origin.protobuf.SearchUsersProto,
                origin.protobuf.UsersProto>(
                  this, METHODID_SEARCH_USERS)))
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
                origin.protobuf.Void>(
                  this, METHODID_DELETE_USER)))
          .addMethod(
            METHOD_ADD_DATE_PERIOD_TO_SCHEDULE_OF_CARETAKER,
            asyncUnaryCall(
              new MethodHandlers<
                origin.protobuf.DatePeriodOfCaretaker,
                origin.protobuf.Void>(
                  this, METHODID_ADD_DATE_PERIOD_TO_SCHEDULE_OF_CARETAKER)))
          .addMethod(
            METHOD_DELETE_DATE_PERIOD_TO_SCHEDULE_OF_CARETAKER,
            asyncUnaryCall(
              new MethodHandlers<
                origin.protobuf.DatePeriodOfCaretaker,
                origin.protobuf.Void>(
                  this, METHODID_DELETE_DATE_PERIOD_TO_SCHEDULE_OF_CARETAKER)))
          .addMethod(
            METHOD_GET_SCHEDULE_OF_CARETAKER,
            asyncUnaryCall(
              new MethodHandlers<
                origin.protobuf.CareTakerScheduleRequest,
                origin.protobuf.CaretakerSchedule>(
                  this, METHODID_GET_SCHEDULE_OF_CARETAKER)))
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
    public void searchUsers(origin.protobuf.SearchUsersProto request,
        io.grpc.stub.StreamObserver<origin.protobuf.UsersProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SEARCH_USERS, getCallOptions()), request, responseObserver);
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
        io.grpc.stub.StreamObserver<origin.protobuf.Void> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_DELETE_USER, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addDatePeriodToScheduleOfCaretaker(origin.protobuf.DatePeriodOfCaretaker request,
        io.grpc.stub.StreamObserver<origin.protobuf.Void> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ADD_DATE_PERIOD_TO_SCHEDULE_OF_CARETAKER, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteDatePeriodToScheduleOfCaretaker(origin.protobuf.DatePeriodOfCaretaker request,
        io.grpc.stub.StreamObserver<origin.protobuf.Void> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_DELETE_DATE_PERIOD_TO_SCHEDULE_OF_CARETAKER, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getScheduleOfCaretaker(origin.protobuf.CareTakerScheduleRequest request,
        io.grpc.stub.StreamObserver<origin.protobuf.CaretakerSchedule> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_SCHEDULE_OF_CARETAKER, getCallOptions()), request, responseObserver);
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
    public origin.protobuf.UsersProto searchUsers(origin.protobuf.SearchUsersProto request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SEARCH_USERS, getCallOptions(), request);
    }

    /**
     */
    public origin.protobuf.UserProto updateUser(origin.protobuf.UserProto request) {
      return blockingUnaryCall(
          getChannel(), METHOD_UPDATE_USER, getCallOptions(), request);
    }

    /**
     */
    public origin.protobuf.Void deleteUser(origin.protobuf.FindUserProto request) {
      return blockingUnaryCall(
          getChannel(), METHOD_DELETE_USER, getCallOptions(), request);
    }

    /**
     */
    public origin.protobuf.Void addDatePeriodToScheduleOfCaretaker(origin.protobuf.DatePeriodOfCaretaker request) {
      return blockingUnaryCall(
          getChannel(), METHOD_ADD_DATE_PERIOD_TO_SCHEDULE_OF_CARETAKER, getCallOptions(), request);
    }

    /**
     */
    public origin.protobuf.Void deleteDatePeriodToScheduleOfCaretaker(origin.protobuf.DatePeriodOfCaretaker request) {
      return blockingUnaryCall(
          getChannel(), METHOD_DELETE_DATE_PERIOD_TO_SCHEDULE_OF_CARETAKER, getCallOptions(), request);
    }

    /**
     */
    public origin.protobuf.CaretakerSchedule getScheduleOfCaretaker(origin.protobuf.CareTakerScheduleRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_SCHEDULE_OF_CARETAKER, getCallOptions(), request);
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
    public com.google.common.util.concurrent.ListenableFuture<origin.protobuf.UsersProto> searchUsers(
        origin.protobuf.SearchUsersProto request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SEARCH_USERS, getCallOptions()), request);
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
    public com.google.common.util.concurrent.ListenableFuture<origin.protobuf.Void> deleteUser(
        origin.protobuf.FindUserProto request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_DELETE_USER, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<origin.protobuf.Void> addDatePeriodToScheduleOfCaretaker(
        origin.protobuf.DatePeriodOfCaretaker request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_ADD_DATE_PERIOD_TO_SCHEDULE_OF_CARETAKER, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<origin.protobuf.Void> deleteDatePeriodToScheduleOfCaretaker(
        origin.protobuf.DatePeriodOfCaretaker request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_DELETE_DATE_PERIOD_TO_SCHEDULE_OF_CARETAKER, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<origin.protobuf.CaretakerSchedule> getScheduleOfCaretaker(
        origin.protobuf.CareTakerScheduleRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_SCHEDULE_OF_CARETAKER, getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_USER = 0;
  private static final int METHODID_LOG_IN = 1;
  private static final int METHODID_FIND_USER = 2;
  private static final int METHODID_SEARCH_USERS = 3;
  private static final int METHODID_UPDATE_USER = 4;
  private static final int METHODID_DELETE_USER = 5;
  private static final int METHODID_ADD_DATE_PERIOD_TO_SCHEDULE_OF_CARETAKER = 6;
  private static final int METHODID_DELETE_DATE_PERIOD_TO_SCHEDULE_OF_CARETAKER = 7;
  private static final int METHODID_GET_SCHEDULE_OF_CARETAKER = 8;

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
        case METHODID_SEARCH_USERS:
          serviceImpl.searchUsers((origin.protobuf.SearchUsersProto) request,
              (io.grpc.stub.StreamObserver<origin.protobuf.UsersProto>) responseObserver);
          break;
        case METHODID_UPDATE_USER:
          serviceImpl.updateUser((origin.protobuf.UserProto) request,
              (io.grpc.stub.StreamObserver<origin.protobuf.UserProto>) responseObserver);
          break;
        case METHODID_DELETE_USER:
          serviceImpl.deleteUser((origin.protobuf.FindUserProto) request,
              (io.grpc.stub.StreamObserver<origin.protobuf.Void>) responseObserver);
          break;
        case METHODID_ADD_DATE_PERIOD_TO_SCHEDULE_OF_CARETAKER:
          serviceImpl.addDatePeriodToScheduleOfCaretaker((origin.protobuf.DatePeriodOfCaretaker) request,
              (io.grpc.stub.StreamObserver<origin.protobuf.Void>) responseObserver);
          break;
        case METHODID_DELETE_DATE_PERIOD_TO_SCHEDULE_OF_CARETAKER:
          serviceImpl.deleteDatePeriodToScheduleOfCaretaker((origin.protobuf.DatePeriodOfCaretaker) request,
              (io.grpc.stub.StreamObserver<origin.protobuf.Void>) responseObserver);
          break;
        case METHODID_GET_SCHEDULE_OF_CARETAKER:
          serviceImpl.getScheduleOfCaretaker((origin.protobuf.CareTakerScheduleRequest) request,
              (io.grpc.stub.StreamObserver<origin.protobuf.CaretakerSchedule>) responseObserver);
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
              .addMethod(METHOD_SEARCH_USERS)
              .addMethod(METHOD_UPDATE_USER)
              .addMethod(METHOD_DELETE_USER)
              .addMethod(METHOD_ADD_DATE_PERIOD_TO_SCHEDULE_OF_CARETAKER)
              .addMethod(METHOD_DELETE_DATE_PERIOD_TO_SCHEDULE_OF_CARETAKER)
              .addMethod(METHOD_GET_SCHEDULE_OF_CARETAKER)
              .build();
        }
      }
    }
    return result;
  }
}
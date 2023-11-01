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
public final class PetOwnerServiceGrpc {

  private PetOwnerServiceGrpc() {}

  public static final String SERVICE_NAME = "PetOwnerService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<PetOwner,
          PetOwner> METHOD_CREATE_PET_OWNER =
      io.grpc.MethodDescriptor.<PetOwner, PetOwner>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "PetOwnerService", "CreatePetOwner"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              PetOwner.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              PetOwner.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<LoginUser,
          PetOwner> METHOD_LOGIN_PET_OWNER =
      io.grpc.MethodDescriptor.<LoginUser, PetOwner>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "PetOwnerService", "LoginPetOwner"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              LoginUser.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              PetOwner.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<SearchField,
          PetOwner> METHOD_FIND_PET_OWNER =
      io.grpc.MethodDescriptor.<SearchField, PetOwner>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "PetOwnerService", "FindPetOwner"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              SearchField.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              PetOwner.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PetOwnerServiceStub newStub(io.grpc.Channel channel) {
    return new PetOwnerServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PetOwnerServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new PetOwnerServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PetOwnerServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new PetOwnerServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class PetOwnerServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void createPetOwner(PetOwner request,
                               io.grpc.stub.StreamObserver<PetOwner> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_CREATE_PET_OWNER, responseObserver);
    }

    /**
     */
    public void loginPetOwner(LoginUser request,
                              io.grpc.stub.StreamObserver<PetOwner> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_LOGIN_PET_OWNER, responseObserver);
    }

    /**
     */
    public void findPetOwner(SearchField request,
                             io.grpc.stub.StreamObserver<PetOwner> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_FIND_PET_OWNER, responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_CREATE_PET_OWNER,
            asyncUnaryCall(
              new MethodHandlers<
                      PetOwner,
                      PetOwner>(
                  this, METHODID_CREATE_PET_OWNER)))
          .addMethod(
            METHOD_LOGIN_PET_OWNER,
            asyncUnaryCall(
              new MethodHandlers<
                      LoginUser,
                      PetOwner>(
                  this, METHODID_LOGIN_PET_OWNER)))
          .addMethod(
            METHOD_FIND_PET_OWNER,
            asyncUnaryCall(
              new MethodHandlers<
                      SearchField,
                      PetOwner>(
                  this, METHODID_FIND_PET_OWNER)))
          .build();
    }
  }

  /**
   */
  public static final class PetOwnerServiceStub extends io.grpc.stub.AbstractStub<PetOwnerServiceStub> {
    private PetOwnerServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PetOwnerServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected PetOwnerServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PetOwnerServiceStub(channel, callOptions);
    }

    /**
     */
    public void createPetOwner(PetOwner request,
                               io.grpc.stub.StreamObserver<PetOwner> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_CREATE_PET_OWNER, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void loginPetOwner(LoginUser request,
                              io.grpc.stub.StreamObserver<PetOwner> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_LOGIN_PET_OWNER, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void findPetOwner(SearchField request,
                             io.grpc.stub.StreamObserver<PetOwner> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_FIND_PET_OWNER, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class PetOwnerServiceBlockingStub extends io.grpc.stub.AbstractStub<PetOwnerServiceBlockingStub> {
    private PetOwnerServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PetOwnerServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected PetOwnerServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PetOwnerServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public PetOwner createPetOwner(PetOwner request) {
      return blockingUnaryCall(
          getChannel(), METHOD_CREATE_PET_OWNER, getCallOptions(), request);
    }

    /**
     */
    public PetOwner loginPetOwner(LoginUser request) {
      return blockingUnaryCall(
          getChannel(), METHOD_LOGIN_PET_OWNER, getCallOptions(), request);
    }

    /**
     */
    public PetOwner findPetOwner(SearchField request) {
      return blockingUnaryCall(
          getChannel(), METHOD_FIND_PET_OWNER, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class PetOwnerServiceFutureStub extends io.grpc.stub.AbstractStub<PetOwnerServiceFutureStub> {
    private PetOwnerServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PetOwnerServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected PetOwnerServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PetOwnerServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<PetOwner> createPetOwner(
        PetOwner request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_CREATE_PET_OWNER, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<PetOwner> loginPetOwner(
        LoginUser request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_LOGIN_PET_OWNER, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<PetOwner> findPetOwner(
        SearchField request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_FIND_PET_OWNER, getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_PET_OWNER = 0;
  private static final int METHODID_LOGIN_PET_OWNER = 1;
  private static final int METHODID_FIND_PET_OWNER = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PetOwnerServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PetOwnerServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_PET_OWNER:
          serviceImpl.createPetOwner((PetOwner) request,
              (io.grpc.stub.StreamObserver<PetOwner>) responseObserver);
          break;
        case METHODID_LOGIN_PET_OWNER:
          serviceImpl.loginPetOwner((LoginUser) request,
              (io.grpc.stub.StreamObserver<PetOwner>) responseObserver);
          break;
        case METHODID_FIND_PET_OWNER:
          serviceImpl.findPetOwner((SearchField) request,
              (io.grpc.stub.StreamObserver<PetOwner>) responseObserver);
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

  private static final class PetOwnerServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return Protobuf.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (PetOwnerServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PetOwnerServiceDescriptorSupplier())
              .addMethod(METHOD_CREATE_PET_OWNER)
              .addMethod(METHOD_LOGIN_PET_OWNER)
              .addMethod(METHOD_FIND_PET_OWNER)
              .build();
        }
      }
    }
    return result;
  }
}

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
public final class CommunicationServiceGrpc {

  private CommunicationServiceGrpc() {}

  public static final String SERVICE_NAME = "CommunicationService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<origin.protobuf.UserProto,
      origin.protobuf.ResponseStatus> METHOD_OFFER_CARE =
      io.grpc.MethodDescriptor.<origin.protobuf.UserProto, origin.protobuf.ResponseStatus>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "CommunicationService", "OfferCare"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              origin.protobuf.UserProto.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              origin.protobuf.ResponseStatus.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CommunicationServiceStub newStub(io.grpc.Channel channel) {
    return new CommunicationServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CommunicationServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CommunicationServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CommunicationServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CommunicationServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class CommunicationServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void offerCare(origin.protobuf.UserProto request,
        io.grpc.stub.StreamObserver<origin.protobuf.ResponseStatus> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_OFFER_CARE, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_OFFER_CARE,
            asyncUnaryCall(
              new MethodHandlers<
                origin.protobuf.UserProto,
                origin.protobuf.ResponseStatus>(
                  this, METHODID_OFFER_CARE)))
          .build();
    }
  }

  /**
   */
  public static final class CommunicationServiceStub extends io.grpc.stub.AbstractStub<CommunicationServiceStub> {
    private CommunicationServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CommunicationServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CommunicationServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CommunicationServiceStub(channel, callOptions);
    }

    /**
     */
    public void offerCare(origin.protobuf.UserProto request,
        io.grpc.stub.StreamObserver<origin.protobuf.ResponseStatus> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_OFFER_CARE, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CommunicationServiceBlockingStub extends io.grpc.stub.AbstractStub<CommunicationServiceBlockingStub> {
    private CommunicationServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CommunicationServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CommunicationServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CommunicationServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public origin.protobuf.ResponseStatus offerCare(origin.protobuf.UserProto request) {
      return blockingUnaryCall(
          getChannel(), METHOD_OFFER_CARE, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CommunicationServiceFutureStub extends io.grpc.stub.AbstractStub<CommunicationServiceFutureStub> {
    private CommunicationServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CommunicationServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CommunicationServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CommunicationServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<origin.protobuf.ResponseStatus> offerCare(
        origin.protobuf.UserProto request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_OFFER_CARE, getCallOptions()), request);
    }
  }

  private static final int METHODID_OFFER_CARE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CommunicationServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CommunicationServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_OFFER_CARE:
          serviceImpl.offerCare((origin.protobuf.UserProto) request,
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

  private static final class CommunicationServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return origin.protobuf.Protobuf.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (CommunicationServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CommunicationServiceDescriptorSupplier())
              .addMethod(METHOD_OFFER_CARE)
              .build();
        }
      }
    }
    return result;
  }
}

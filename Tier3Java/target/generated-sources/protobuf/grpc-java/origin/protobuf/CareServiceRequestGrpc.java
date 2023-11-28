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
public final class CareServiceRequestGrpc {

  private CareServiceRequestGrpc() {}

  public static final String SERVICE_NAME = "CareServiceRequest";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<origin.protobuf.StartCareServiceRequest,
      origin.protobuf.ResponseStatus> METHOD_OFFER_CARE =
      io.grpc.MethodDescriptor.<origin.protobuf.StartCareServiceRequest, origin.protobuf.ResponseStatus>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "CareServiceRequest", "OfferCare"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              origin.protobuf.StartCareServiceRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              origin.protobuf.ResponseStatus.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CareServiceRequestStub newStub(io.grpc.Channel channel) {
    return new CareServiceRequestStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CareServiceRequestBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CareServiceRequestBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CareServiceRequestFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CareServiceRequestFutureStub(channel);
  }

  /**
   */
  public static abstract class CareServiceRequestImplBase implements io.grpc.BindableService {

    /**
     */
    public void offerCare(origin.protobuf.StartCareServiceRequest request,
        io.grpc.stub.StreamObserver<origin.protobuf.ResponseStatus> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_OFFER_CARE, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_OFFER_CARE,
            asyncUnaryCall(
              new MethodHandlers<
                origin.protobuf.StartCareServiceRequest,
                origin.protobuf.ResponseStatus>(
                  this, METHODID_OFFER_CARE)))
          .build();
    }
  }

  /**
   */
  public static final class CareServiceRequestStub extends io.grpc.stub.AbstractStub<CareServiceRequestStub> {
    private CareServiceRequestStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CareServiceRequestStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CareServiceRequestStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CareServiceRequestStub(channel, callOptions);
    }

    /**
     */
    public void offerCare(origin.protobuf.StartCareServiceRequest request,
        io.grpc.stub.StreamObserver<origin.protobuf.ResponseStatus> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_OFFER_CARE, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CareServiceRequestBlockingStub extends io.grpc.stub.AbstractStub<CareServiceRequestBlockingStub> {
    private CareServiceRequestBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CareServiceRequestBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CareServiceRequestBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CareServiceRequestBlockingStub(channel, callOptions);
    }

    /**
     */
    public origin.protobuf.ResponseStatus offerCare(origin.protobuf.StartCareServiceRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_OFFER_CARE, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CareServiceRequestFutureStub extends io.grpc.stub.AbstractStub<CareServiceRequestFutureStub> {
    private CareServiceRequestFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CareServiceRequestFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CareServiceRequestFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CareServiceRequestFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<origin.protobuf.ResponseStatus> offerCare(
        origin.protobuf.StartCareServiceRequest request) {
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
    private final CareServiceRequestImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CareServiceRequestImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_OFFER_CARE:
          serviceImpl.offerCare((origin.protobuf.StartCareServiceRequest) request,
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

  private static final class CareServiceRequestDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return origin.protobuf.Protobuf.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (CareServiceRequestGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CareServiceRequestDescriptorSupplier())
              .addMethod(METHOD_OFFER_CARE)
              .build();
        }
      }
    }
    return result;
  }
}

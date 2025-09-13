package com.dev;

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
    comments = "Source: schema.proto")
public final class BookAuthorServiceGrpc {

  private BookAuthorServiceGrpc() {}

  public static final String SERVICE_NAME = "com.dev.BookAuthorService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.dev.Author,
      com.dev.Author> METHOD_GET_AUTHOR =
      io.grpc.MethodDescriptor.<com.dev.Author, com.dev.Author>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.dev.BookAuthorService", "getAuthor"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.dev.Author.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.dev.Author.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static BookAuthorServiceStub newStub(io.grpc.Channel channel) {
    return new BookAuthorServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BookAuthorServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new BookAuthorServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static BookAuthorServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new BookAuthorServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class BookAuthorServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *unary - synchronous
     *client will send one request and server will respond with one response.
     * </pre>
     */
    public void getAuthor(com.dev.Author request,
        io.grpc.stub.StreamObserver<com.dev.Author> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_AUTHOR, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_GET_AUTHOR,
            asyncUnaryCall(
              new MethodHandlers<
                com.dev.Author,
                com.dev.Author>(
                  this, METHODID_GET_AUTHOR)))
          .build();
    }
  }

  /**
   */
  public static final class BookAuthorServiceStub extends io.grpc.stub.AbstractStub<BookAuthorServiceStub> {
    private BookAuthorServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BookAuthorServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BookAuthorServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BookAuthorServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     *unary - synchronous
     *client will send one request and server will respond with one response.
     * </pre>
     */
    public void getAuthor(com.dev.Author request,
        io.grpc.stub.StreamObserver<com.dev.Author> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_AUTHOR, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class BookAuthorServiceBlockingStub extends io.grpc.stub.AbstractStub<BookAuthorServiceBlockingStub> {
    private BookAuthorServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BookAuthorServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BookAuthorServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BookAuthorServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *unary - synchronous
     *client will send one request and server will respond with one response.
     * </pre>
     */
    public com.dev.Author getAuthor(com.dev.Author request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_AUTHOR, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class BookAuthorServiceFutureStub extends io.grpc.stub.AbstractStub<BookAuthorServiceFutureStub> {
    private BookAuthorServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BookAuthorServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BookAuthorServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BookAuthorServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *unary - synchronous
     *client will send one request and server will respond with one response.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.dev.Author> getAuthor(
        com.dev.Author request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_AUTHOR, getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_AUTHOR = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final BookAuthorServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(BookAuthorServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_AUTHOR:
          serviceImpl.getAuthor((com.dev.Author) request,
              (io.grpc.stub.StreamObserver<com.dev.Author>) responseObserver);
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

  private static final class BookAuthorServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.dev.Schema.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (BookAuthorServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new BookAuthorServiceDescriptorSupplier())
              .addMethod(METHOD_GET_AUTHOR)
              .build();
        }
      }
    }
    return result;
  }
}

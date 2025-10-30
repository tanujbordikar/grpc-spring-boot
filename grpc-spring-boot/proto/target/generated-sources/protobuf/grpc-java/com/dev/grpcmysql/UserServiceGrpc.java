package com.dev.grpcmysql;

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
    comments = "Source: user.proto")
public final class UserServiceGrpc {

  private UserServiceGrpc() {}

  public static final String SERVICE_NAME = "com.dev.grpcmysql.UserService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.dev.grpcmysql.UserRequest,
      com.dev.grpcmysql.UserResponse> METHOD_GET_USER =
      io.grpc.MethodDescriptor.<com.dev.grpcmysql.UserRequest, com.dev.grpcmysql.UserResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.dev.grpcmysql.UserService", "GetUser"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.dev.grpcmysql.UserRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.dev.grpcmysql.UserResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.dev.grpcmysql.UserRequest,
      com.dev.grpcmysql.UserResponse> METHOD_LIST_USERS =
      io.grpc.MethodDescriptor.<com.dev.grpcmysql.UserRequest, com.dev.grpcmysql.UserResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "com.dev.grpcmysql.UserService", "ListUsers"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.dev.grpcmysql.UserRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.dev.grpcmysql.UserResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.dev.grpcmysql.UserMessage,
      com.dev.grpcmysql.SummaryResponse> METHOD_UPLOAD_USERS =
      io.grpc.MethodDescriptor.<com.dev.grpcmysql.UserMessage, com.dev.grpcmysql.SummaryResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "com.dev.grpcmysql.UserService", "UploadUsers"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.dev.grpcmysql.UserMessage.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.dev.grpcmysql.SummaryResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.dev.grpcmysql.UserMessage,
      com.dev.grpcmysql.UserResponse> METHOD_CHAT_USERS =
      io.grpc.MethodDescriptor.<com.dev.grpcmysql.UserMessage, com.dev.grpcmysql.UserResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "com.dev.grpcmysql.UserService", "ChatUsers"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.dev.grpcmysql.UserMessage.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.dev.grpcmysql.UserResponse.getDefaultInstance()))
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
    public void getUser(com.dev.grpcmysql.UserRequest request,
        io.grpc.stub.StreamObserver<com.dev.grpcmysql.UserResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_USER, responseObserver);
    }

    /**
     */
    public void listUsers(com.dev.grpcmysql.UserRequest request,
        io.grpc.stub.StreamObserver<com.dev.grpcmysql.UserResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_LIST_USERS, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.dev.grpcmysql.UserMessage> uploadUsers(
        io.grpc.stub.StreamObserver<com.dev.grpcmysql.SummaryResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(METHOD_UPLOAD_USERS, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.dev.grpcmysql.UserMessage> chatUsers(
        io.grpc.stub.StreamObserver<com.dev.grpcmysql.UserResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(METHOD_CHAT_USERS, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_GET_USER,
            asyncUnaryCall(
              new MethodHandlers<
                com.dev.grpcmysql.UserRequest,
                com.dev.grpcmysql.UserResponse>(
                  this, METHODID_GET_USER)))
          .addMethod(
            METHOD_LIST_USERS,
            asyncServerStreamingCall(
              new MethodHandlers<
                com.dev.grpcmysql.UserRequest,
                com.dev.grpcmysql.UserResponse>(
                  this, METHODID_LIST_USERS)))
          .addMethod(
            METHOD_UPLOAD_USERS,
            asyncClientStreamingCall(
              new MethodHandlers<
                com.dev.grpcmysql.UserMessage,
                com.dev.grpcmysql.SummaryResponse>(
                  this, METHODID_UPLOAD_USERS)))
          .addMethod(
            METHOD_CHAT_USERS,
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.dev.grpcmysql.UserMessage,
                com.dev.grpcmysql.UserResponse>(
                  this, METHODID_CHAT_USERS)))
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
    public void getUser(com.dev.grpcmysql.UserRequest request,
        io.grpc.stub.StreamObserver<com.dev.grpcmysql.UserResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_USER, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listUsers(com.dev.grpcmysql.UserRequest request,
        io.grpc.stub.StreamObserver<com.dev.grpcmysql.UserResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(METHOD_LIST_USERS, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.dev.grpcmysql.UserMessage> uploadUsers(
        io.grpc.stub.StreamObserver<com.dev.grpcmysql.SummaryResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(METHOD_UPLOAD_USERS, getCallOptions()), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.dev.grpcmysql.UserMessage> chatUsers(
        io.grpc.stub.StreamObserver<com.dev.grpcmysql.UserResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(METHOD_CHAT_USERS, getCallOptions()), responseObserver);
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
    public com.dev.grpcmysql.UserResponse getUser(com.dev.grpcmysql.UserRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_USER, getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.dev.grpcmysql.UserResponse> listUsers(
        com.dev.grpcmysql.UserRequest request) {
      return blockingServerStreamingCall(
          getChannel(), METHOD_LIST_USERS, getCallOptions(), request);
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
    public com.google.common.util.concurrent.ListenableFuture<com.dev.grpcmysql.UserResponse> getUser(
        com.dev.grpcmysql.UserRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_USER, getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_USER = 0;
  private static final int METHODID_LIST_USERS = 1;
  private static final int METHODID_UPLOAD_USERS = 2;
  private static final int METHODID_CHAT_USERS = 3;

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
        case METHODID_GET_USER:
          serviceImpl.getUser((com.dev.grpcmysql.UserRequest) request,
              (io.grpc.stub.StreamObserver<com.dev.grpcmysql.UserResponse>) responseObserver);
          break;
        case METHODID_LIST_USERS:
          serviceImpl.listUsers((com.dev.grpcmysql.UserRequest) request,
              (io.grpc.stub.StreamObserver<com.dev.grpcmysql.UserResponse>) responseObserver);
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
        case METHODID_UPLOAD_USERS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.uploadUsers(
              (io.grpc.stub.StreamObserver<com.dev.grpcmysql.SummaryResponse>) responseObserver);
        case METHODID_CHAT_USERS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.chatUsers(
              (io.grpc.stub.StreamObserver<com.dev.grpcmysql.UserResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class UserServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.dev.grpcmysql.UserServiceProto.getDescriptor();
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
              .addMethod(METHOD_GET_USER)
              .addMethod(METHOD_LIST_USERS)
              .addMethod(METHOD_UPLOAD_USERS)
              .addMethod(METHOD_CHAT_USERS)
              .build();
        }
      }
    }
    return result;
  }
}

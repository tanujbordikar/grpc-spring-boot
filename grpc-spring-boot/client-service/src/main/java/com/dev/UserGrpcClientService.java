package com.dev;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

import com.dev.grpcmysql.UserRequest;
import com.dev.grpcmysql.UserResponse;
import com.dev.grpcmysql.UserServiceGrpc;
import com.google.protobuf.Descriptors;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.client.inject.GrpcClient;

@Service
public class UserGrpcClientService {
	@GrpcClient("grpc-dev-service")
	private final UserServiceGrpc.UserServiceBlockingStub synchronousClient;
	
	@GrpcClient("grpc-dev-service")
	private final UserServiceGrpc.UserServiceStub asynchronousClient;

    public UserGrpcClientService() {
        ManagedChannel channel = ManagedChannelBuilder
            .forAddress("localhost", 12000)
            .usePlaintext()
            .build();
        this.synchronousClient = UserServiceGrpc.newBlockingStub(channel);
        this.asynchronousClient = UserServiceGrpc.newStub(channel);
    }
    
    public Map<Descriptors.FieldDescriptor, Object> getUserById(int id) {
    	UserRequest req = UserRequest.newBuilder().setId(id).build();
    	UserResponse resp = synchronousClient.getUser(req);
    	return resp.getAllFields();
    }
    
    public List<Map<Descriptors.FieldDescriptor, Object>> listAllUsers() throws InterruptedException {
    	UserRequest req = UserRequest.newBuilder().setId(0).build();
    	CountDownLatch latch = new CountDownLatch(1);
    	List<Map<Descriptors.FieldDescriptor, Object>> resp = new ArrayList<>();
    	asynchronousClient.listUsers(req, new StreamObserver<UserResponse>() {

			@Override
			public void onNext(UserResponse value) {
				resp.add(value.getAllFields());
			}

			@Override
			public void onError(Throwable t) {
				latch.countDown();
			}

			@Override
			public void onCompleted() {
				latch.countDown();
			}
    		
    	});
    	boolean await = latch.await(1, TimeUnit.MINUTES);
    	return await ? resp : Collections.EMPTY_LIST;
    }
}

package com.dev.entity;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.dev.grpcmysql.SummaryResponse;
import com.dev.grpcmysql.UserMessage;
import com.dev.grpcmysql.UserRequest;
import com.dev.grpcmysql.UserResponse;
import com.dev.grpcmysql.UserServiceGrpc.UserServiceImplBase;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;


@GrpcService
public class UserGrpcService extends UserServiceImplBase{
	
	private UserService userService;
	
	@Autowired
	public UserGrpcService(UserService userService) {
		this.userService = userService;
	}
	
	@PostConstruct
	public void init() {
	    System.out.println("✅ UserGrpcService initialized with userService = " + userService);
	}


	@Override
	public void getUser(UserRequest request, StreamObserver<UserResponse> responseObserver) {
		User u = userService.getUser(request.getId());
		if (u == null) {
            responseObserver.onNext(UserResponse.newBuilder().setId(0).setName("Not Found").setEmail("").build());
            responseObserver.onCompleted();
            return;
        }
		UserResponse resp = UserResponse.newBuilder()
                .setId(u.getId())
                .setName(u.getName())
                .setEmail(u.getEmail())
                .build();
		responseObserver.onNext(resp);
        responseObserver.onCompleted();
	}

	@Override
	public void listUsers(UserRequest request, StreamObserver<UserResponse> responseObserver) {
		List<User> listOfUsers = userService.listAll();
		for(User u: listOfUsers) {
			UserResponse resp = UserResponse.newBuilder()
	                .setId(u.getId())
	                .setName(u.getName())
	                .setEmail(u.getEmail())
	                .build();
			responseObserver.onNext(resp);
		}
		responseObserver.onCompleted();
	}

	@Override
	public StreamObserver<UserMessage> uploadUsers(StreamObserver<SummaryResponse> responseObserver) {
		List<User> listOfUsers = new ArrayList<>();
		return new StreamObserver<UserMessage>(){

			@Override
			public void onNext(UserMessage value) {
				User user = new User(null, value.getEmail(), value.getName());
				listOfUsers.add(user);
			}

			@Override
			public void onError(Throwable t) {
				System.err.println("Stream error: " + t.getMessage());
			}

			@Override
			public void onCompleted() {
				userService.saveAll(listOfUsers);
				SummaryResponse response = SummaryResponse.newBuilder().setCreatedCount(listOfUsers.size()).build();
				responseObserver.onNext(response);
				responseObserver.onCompleted();
				System.out.println("✅ Uploaded " + listOfUsers.size() + " users to DB.");
			}
			
		};
	}

	@Override
	public StreamObserver<UserMessage> chatUsers(StreamObserver<UserResponse> responseObserver) {
		// TODO Auto-generated method stub
		return super.chatUsers(responseObserver);
	}

	
}

package com.dev;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dev.grpcmysql.SummaryResponse;
import com.dev.grpcmysql.UserMessage;
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
    	return await ? resp : Collections.emptyList();
    }
    
    public Map<Descriptors.FieldDescriptor, Object> createUsers(MultipartFile file) throws InterruptedException, IOException{
    	 try (InputStream inputStream = file.getInputStream();
                 Workbook workbook = WorkbookFactory.create(inputStream)) {
    		 Sheet sheet = workbook.getSheetAt(0);
    		 CountDownLatch latch = new CountDownLatch(1);
    		 List<Map<Descriptors.FieldDescriptor, Object>> result = new ArrayList<>();
    		 StreamObserver<SummaryResponse> responseObserver = new StreamObserver<SummaryResponse>(){

				@Override
				public void onNext(SummaryResponse value) {
					System.out.println("Users created: "+ value.getCreatedCount());
					result.add(value.getAllFields());
				}

				@Override
				public void onError(Throwable t) {
					System.err.println("Client Error: "+ t.getStackTrace());
					latch.countDown();
				}

				@Override
				public void onCompleted() {
					System.out.println("All users uploaded successfully!");
					latch.countDown();
				}
    		 };
    		 StreamObserver<UserMessage> requestObserver = asynchronousClient.uploadUsers(responseObserver);
    		 for(Row row: sheet) {
    			 if (row.getRowNum() == 0) continue; // Skip header row

                 Cell nameCell = row.getCell(0);
                 Cell emailCell = row.getCell(1);
                 if (nameCell == null || emailCell == null) continue;

                 String name = nameCell.getStringCellValue();
                 String email = emailCell.getStringCellValue();

                 UserMessage userMsg = UserMessage.newBuilder()
                         .setName(name)
                         .setEmail(email)
                         .build();

                 requestObserver.onNext(userMsg);
    		 }
    		 requestObserver.onCompleted();
             latch.await();
             return result.get(0);
    	 }
    }
}

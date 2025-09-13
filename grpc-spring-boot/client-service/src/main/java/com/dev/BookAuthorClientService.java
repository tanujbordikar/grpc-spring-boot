package com.dev;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.google.protobuf.Descriptors;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

@Service
public class BookAuthorClientService {
	
	private final BookAuthorServiceGrpc.BookAuthorServiceBlockingStub synchronousClient;

    public BookAuthorClientService() {
        ManagedChannel channel = ManagedChannelBuilder
            .forAddress("localhost", 12000)
            .usePlaintext()
            .build();
        this.synchronousClient = BookAuthorServiceGrpc.newBlockingStub(channel);
    }
    
	public Map<Descriptors.FieldDescriptor, Object> getAuthor(int authorId) {
		Author authorRequest = Author.newBuilder().setAuthorId(authorId).build();
		Author authorResponse = synchronousClient.getAuthor(authorRequest);
		return authorResponse.getAllFields();
	}
}

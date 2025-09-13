package com.dev;

import com.dev.BookAuthorServiceGrpc.BookAuthorServiceImplBase;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class BookAuthorServerService extends BookAuthorServiceImplBase {

	@Override
	public void getAuthor(Author request, StreamObserver<Author> responseObserver) {
		TempDB
			.getAuthorsFromTempDb()
			.stream()
			.filter(author -> author.getAuthorId()==request.getAuthorId())
			.findFirst()
			.ifPresent(responseObserver::onNext);
		responseObserver.onCompleted();
	}

}

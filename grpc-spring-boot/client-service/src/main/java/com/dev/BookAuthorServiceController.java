package com.dev;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.FieldDescriptor;

@RestController
public class BookAuthorServiceController {
	private BookAuthorClientService bookAuthorClientService;
	private UserGrpcClientService userGrpcClientService;

	BookAuthorServiceController(BookAuthorClientService bookAuthorClientService,
			UserGrpcClientService userGrpcClientService) {
		this.bookAuthorClientService = bookAuthorClientService;
		this.userGrpcClientService = userGrpcClientService;
	}

	@GetMapping("/author/{id}")
	public Map<Descriptors.FieldDescriptor, Object> getAuthor(@PathVariable("id") String id) {
		return bookAuthorClientService.getAuthor(Integer.parseInt(id));
	}

	@GetMapping("/book/{id}")
	public List<Map<Descriptors.FieldDescriptor, Object>> getBookByAuthor(@PathVariable("id") String id)
			throws InterruptedException {
		return bookAuthorClientService.getBooksByAuthor(Integer.parseInt(id));
	}

	@GetMapping("/book")
	public Map<String, Map<Descriptors.FieldDescriptor, Object>> getExpensiveBook() throws InterruptedException {
		return bookAuthorClientService.getExpensiveBook();
	}

	@GetMapping("/book/author/{gender}")
	public List<Map<Descriptors.FieldDescriptor, Object>> getBookByGender(@PathVariable("gender") String gender)
			throws InterruptedException {
		return bookAuthorClientService.getBooksByGender(gender);
	}

	@GetMapping("/grpcmysql/users/{id}")
	public Map<Descriptors.FieldDescriptor, Object> getUsersfromMySql(@PathVariable("id") String id) {
		return userGrpcClientService.getUserById(Integer.parseInt(id));
	}

	@GetMapping("/grpcmysql/users")
	public List<Map<Descriptors.FieldDescriptor, Object>> listAllUsers() throws InterruptedException {
		return userGrpcClientService.listAllUsers();
	}

	@PostMapping("/grpcmysql/upload")
	public Map<FieldDescriptor, Object> uploadExcel(@RequestParam("file") MultipartFile file)
			throws InterruptedException, IOException {
		Map<FieldDescriptor, Object> result = userGrpcClientService.createUsers(file);
		return result;
	}
}

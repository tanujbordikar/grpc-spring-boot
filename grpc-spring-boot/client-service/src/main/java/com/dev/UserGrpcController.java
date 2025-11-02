package com.dev;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.FieldDescriptor;

@RestController
@RequestMapping("/grpcmysql")
public class UserGrpcController {
	private UserGrpcClientService userGrpcClientService;
	
	public UserGrpcController(UserGrpcClientService userGrpcClientService) {
		this.userGrpcClientService = userGrpcClientService;
	}
	
	@GetMapping("/users/{id}")
	public Map<Descriptors.FieldDescriptor, Object> getUsersfromMySql(@PathVariable("id") String id) {
		return userGrpcClientService.getUserById(Integer.parseInt(id));
	}

	@GetMapping("/users")
	public List<Map<Descriptors.FieldDescriptor, Object>> listAllUsers() throws InterruptedException {
		return userGrpcClientService.listAllUsers();
	}

	@PostMapping("/upload")
	public Map<FieldDescriptor, Object> uploadExcel(@RequestParam("file") MultipartFile file)
			throws InterruptedException, IOException {
		Map<FieldDescriptor, Object> result = userGrpcClientService.createUsers(file);
		return result;
	}
}

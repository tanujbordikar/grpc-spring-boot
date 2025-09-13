package com.dev;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.google.protobuf.Descriptors;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class BookAuthorServiceController {
	private BookAuthorClientService bookAuthorClientService;
	
	BookAuthorServiceController(BookAuthorClientService bookAuthorClientService){
		this.bookAuthorClientService = bookAuthorClientService;
	}
	
	@GetMapping("/author/{id}")
	public Map<Descriptors.FieldDescriptor, Object> getAuthor(@PathVariable("id") String id){
		return bookAuthorClientService.getAuthor(Integer.parseInt(id));
	}
}

package com.dev;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.google.protobuf.Descriptors;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class BookAuthorServiceController {
	private final BookAuthorClientService bookAuthorClientService = new BookAuthorClientService();

//	BookAuthorServiceController(BookAuthorClientService bookAuthorClientService){
//		this.bookAuthorClientService = bookAuthorClientService;
//	}

//	@GetMapping("/author/{id}")
//	public Map<Descriptors.FieldDescriptor, Object> getAuthor(@PathVariable("id") String id) {
//		return bookAuthorClientService.getAuthor(Integer.parseInt(id));
//	}

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
    public List<Map<Descriptors.FieldDescriptor, Object>> getBookByGender(@PathVariable("gender") String gender) throws InterruptedException {
        return bookAuthorClientService.getBooksByGender(gender);
    }
	
	@GetMapping("/mysql/author/{id}")
	public Map<Descriptors.FieldDescriptor, Object> getAuthorfromMySql(@PathVariable("id") String id) {
		return bookAuthorClientService.getAuthorfromMySql(Integer.parseInt(id));
	}
}

package com.dev.entity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

//    UserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    public User getUser(Long id) { return (User) userRepository.findById(id).orElse(null); }
    public List<User> listAll() { return (List<User>) userRepository.findAll(); }
    public User save(User user) { return (User) userRepository.save(user); }
}

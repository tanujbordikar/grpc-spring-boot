package com.dev;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.dev.entity.User;
import com.dev.entity.UserService;

@Configuration
@EnableScheduling
public class ServiceScheduler {
	private UserService userService;
	public ServiceScheduler(UserService userService) {
		this.userService=userService;
	}
	
	@Scheduled(initialDelay = 1000)
	public void scheduleFixedDelayTask() {
		List<User> user = userService.listAll();
		System.out.println(user.get(0).toString());
	}
}

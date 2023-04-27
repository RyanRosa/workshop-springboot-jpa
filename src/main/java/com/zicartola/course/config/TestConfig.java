package com.zicartola.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.zicartola.course.entites.Order;
import com.zicartola.course.entites.User;
import com.zicartola.course.repositories.OrderRepository;
import com.zicartola.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {

		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "98291283901", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "jkluio9", "123489056");
		Order o1 = new Order(null, Instant.parse("2023-04-27T06:14:13Z"), u1);
		Order o2 = new Order(null, Instant.parse("2023-04-27T06:11:13Z"), u2);

		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1,o2));
	}

}

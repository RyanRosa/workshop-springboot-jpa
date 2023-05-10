package com.zicartola.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.zicartola.course.entites.Category;
import com.zicartola.course.entites.Order;
import com.zicartola.course.entites.OrderItem;
import com.zicartola.course.entites.Product;
import com.zicartola.course.entites.User;
import com.zicartola.course.entites.enums.OrderStatus;
import com.zicartola.course.repositories.CategoryRepository;
import com.zicartola.course.repositories.OrderItemRepository;
import com.zicartola.course.repositories.OrderRepository;
import com.zicartola.course.repositories.ProductReposity;
import com.zicartola.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductReposity productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Override
	public void run(String... args) throws Exception {

		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "98291283901", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "jkluio9", "123489056");
		Order o1 = new Order(null, Instant.parse("2023-04-27T06:14:13Z"), OrderStatus.CANCELED, u1);
		Order o2 = new Order(null, Instant.parse("2023-04-27T06:11:13Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2022-02-10T01:12:00Z"), OrderStatus.DELIVERED, u1);
		Category c1 = new Category(null, "Esporte");
		Category c2 = new Category(null, "Fantasia");
		Product p1 = new Product(null, "Clean Code", "1234", 2000.0, "https://teste.com");
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		categoryRepository.saveAll(Arrays.asList(c1, c2));
		
		
		p1.getCategories().add(c1);
		
		productRepository.save(p1);
		
		
		OrderItem oi1 = new OrderItem(o1,p1,2,p1.getPrice());
		OrderItem oi2 = new OrderItem(o1,p1,1,p1.getPrice());
		OrderItem oi3 = new OrderItem(o1,p1,4,p1.getPrice());
		OrderItem oi4 = new OrderItem(o3,p1,2,p1.getPrice());
		
		orderItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));
		
	}

}

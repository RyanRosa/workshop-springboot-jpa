package com.zicartola.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zicartola.course.entites.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{
	

}

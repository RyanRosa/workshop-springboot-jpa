package com.zicartola.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zicartola.course.entites.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}

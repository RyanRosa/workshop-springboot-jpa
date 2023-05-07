package com.zicartola.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zicartola.course.entites.Product;

public interface ProductReposity extends JpaRepository<Product, Long>{

}

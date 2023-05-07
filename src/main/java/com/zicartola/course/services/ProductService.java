package com.zicartola.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zicartola.course.entites.Product;
import com.zicartola.course.repositories.ProductReposity;

@Service
public class ProductService {
	
	@Autowired
	private ProductReposity repository;
	
	public List<Product> findAll(){
		return repository.findAll();
	}

	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get();
	}
}

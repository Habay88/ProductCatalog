package com.prunny.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.prunny.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query(value= "SELECT * FROM product where product_name = ?1", nativeQuery = true)
	List<Product> getProductsByName(String productName);
	
	List<Product> findByCategoryId(Long categoryId);
	
    List<Product> findByPriceBetween(Long minimumPrice, Long maximumPrice);
}
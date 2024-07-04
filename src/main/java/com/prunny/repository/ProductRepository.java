package com.prunny.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.prunny.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	/*
	 * @Query(value= "SELECT * FROM product where product_name = ?1", nativeQuery =
	 * true) List<Product> getProductsByName(String productName);
	 */
	
	Page<Product> findById(Long id,Pageable pageable);
	
    Page<Product> findByPriceBetween(Long minimumPrice, Long maximumPrice,Pageable pageable);
    Page<Product> findByproductNameContaining(String productName , Pageable pageable);
}
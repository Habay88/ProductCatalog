package com.prunny.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.prunny.entity.Product;
import com.prunny.request.ProductRequest;
import com.prunny.response.ProductResponse;

public interface ProductService {

	  long addProduct(ProductRequest productRequest);

	    ProductResponse getProductById(long productId);

	    void reduceQuantity(long productId, long quantity);

		Page<Product> getAllProducts(Pageable pageable);

		Product updateProduct(long productId, Product product);

		Product deleteproduct(long productId);

		//List<Product> getProductsByName(String productName);

		Page<Product> findByproductId(long productId,Pageable pageable);

		

		Page<Product> getProductsByName(String productName, Pageable pageable);

		Page<Product> findByPriceRange(long minimumPrice, long maximumPrice, Pageable pageable);

		

		

		
}
package com.prunny.service;

import java.util.List;

import com.prunny.entity.Product;
import com.prunny.request.ProductRequest;
import com.prunny.response.ProductResponse;

public interface ProductService {

	  long addProduct(ProductRequest productRequest);

	    ProductResponse getProductById(long productId);

	    void reduceQuantity(long productId, long quantity);

		List<ProductResponse> getAllProducts();

		Product updateProduct(long productId, Product product);

		Product deleteproduct(long productId);

		List<Product> getProductsByName(String productName);

		List<Product> findByCategoryId(long id);

		List<Product> findByPriceRange(long minimumPrice, long maximumPrice);
}
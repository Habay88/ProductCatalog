package com.prunny.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.prunny.entity.Product;
import com.prunny.request.ProductRequest;
import com.prunny.response.ProductResponse;
import com.prunny.service.ProductService;

//http://localhost:8083/swagger-ui/index.html
@RestController
@RequestMapping("api/product")
public class ProductController {

	 @Autowired
	    private ProductService productService;
	 
	 @ManagedOperation(description = "Creates new product")
	 @PostMapping("/save")
	 public ResponseEntity<Long> addProduct(@RequestBody ProductRequest productRequest) {
	        long productId = productService.addProduct(productRequest);
	        return new ResponseEntity<>(productId, HttpStatus.CREATED);
	    }
	
	 @GetMapping("/{id}")
	    public ResponseEntity<ProductResponse> getProductById(@PathVariable("id") long productId) {
	        ProductResponse productResponse
	                = productService.getProductById(productId);
	        return new ResponseEntity<>(productResponse, HttpStatus.OK);
	    }
	  @GetMapping
	    public ResponseEntity<Page<Product>> getAllProducts(Pageable pageable) {
	        return ResponseEntity.ok(productService.getAllProducts(pageable));
	    }

	 @GetMapping ("/all")
	 public Page<Product> getAvailableProducts(Pageable pageable){
		 return productService.getAllProducts(pageable);
	 }
	 
	 // update existing 
	 @PutMapping("/product")
	 public ResponseEntity<Product> updateProduct(@RequestParam(name="productId")long productId,@RequestBody Product product){
		
		 Product updatedProduct = productService.updateProduct(productId,product);
		 return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
	 }
	 
	  // delete an existing product in the database
	   @DeleteMapping("/product")
	   public ResponseEntity<Product> deleteProduct(@RequestParam(name ="productId") long productId) {
	       Product deletedProduct = productService.deleteproduct(productId);
	       return new ResponseEntity<>(deletedProduct, HttpStatus.OK);
	   }
	   
	   // get product by name using a raw SQL statement
	   @GetMapping("/products-by-name")
	   public Page<Product> getProductsByName(@RequestParam(name ="productName") String productName,Pageable pageable) {
	       return productService.getProductsByName(productName,pageable);
	   }
	 
	    @PutMapping("/reduceQuantity/{id}")
	    public ResponseEntity<Void> reduceQuantity(
	            @PathVariable("id") long productId,@RequestParam long quantity ) {
	            productService.reduceQuantity(productId,quantity);
	            return new ResponseEntity<>(HttpStatus.OK);
	    }
	    
	    @GetMapping("/category/{id}")
	    public ResponseEntity<Page<Product>> getProductsByCategory(@PathVariable long productId, Pageable pageable) {
	        return ResponseEntity.ok(productService.findByproductId(productId,pageable));
	    }

	    @GetMapping("/price-range")
	    public ResponseEntity<Page<Product>> getProductsByPriceRange(@RequestParam long minimumPrice, @RequestParam long maximumPrice,Pageable pageable) {
	        return ResponseEntity.ok(productService.findByPriceRange(minimumPrice, maximumPrice, pageable));
	    }
	
}

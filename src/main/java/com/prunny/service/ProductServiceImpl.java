package com.prunny.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prunny.entity.Product;
import com.prunny.exception.ProductServiceCustomException;
import com.prunny.repository.ProductRepository;
import com.prunny.request.ProductRequest;
import com.prunny.response.ProductResponse;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public long addProduct(ProductRequest productRequest) {
       log.info("Adding Product..");

        Product product
                = Product.builder()
                .productName(productRequest.getName())
                .quantity(productRequest.getQuantity())
                .price(productRequest.getPrice())
                .build();

        productRepository.save(product);

        log.info("Product Created");
        return product.getProductId();

    }

    @Override
    public ProductResponse getProductById(long productId) {
        log.info("Get the product for productId: {}", productId);

        Product product = productRepository.findById(productId)
                .orElseThrow(
                        () -> new ProductServiceCustomException("Product with given id not found","PRODUCT_NOT_FOUND"));

        ProductResponse productResponse  = new ProductResponse();

        BeanUtils.copyProperties(product, productResponse);

        return productResponse;
    }
public List<ProductResponse> getAllProducts(){
	
	List<Product> products = productRepository.findAll();
	return products.stream().map(this::mapToDtoResponse).toList();		
}
private ProductResponse mapToDtoResponse(Product product) {
	return ProductResponse.builder()
			.productId(product.getProductId())
			.productName(product.getProductName())
		    .quantity(product.getQuantity())
		    .price(product.getPrice())
			
			.build();
}
//    private void copyProperties(Product product, ProductResponse productResponse) {
//		// TODO Auto-generated method stub
//		
//	}

	@Override
    public void reduceQuantity(long productId, long quantity) {
        log.info("Reduce Quantity {} for Id: {}", quantity,productId);

        Product product
                = productRepository.findById(productId)
                .orElseThrow(() -> new ProductServiceCustomException(
                        "Product with given Id not found",
                        "PRODUCT_NOT_FOUND"
                ));

        if(product.getQuantity() < quantity) {
            throw new ProductServiceCustomException(
                    "Product does not have sufficient Quantity",
                    "INSUFFICIENT_QUANTITY"
            );
        }

        product.setQuantity(product.getQuantity() - quantity);
        productRepository.save(product);
        log.info("Product Quantity updated Successfully");
    }

	/*
	 * @Override public List<Product> getAllProducts() { // TODO Auto-generated
	 * method stub return productRepository.findAll(); }
	 */
	@Override
	public Product updateProduct(long productId, Product product) {
		Product existingProduct = productRepository.findById(productId).orElseThrow(() -> new ProductServiceCustomException(
                "Product with given Id not found",
                "PRODUCT_NOT_FOUND"
        ));
		existingProduct.setPrice(product.getPrice());
		existingProduct.setProductName(product.getProductName());
		existingProduct.setQuantity(product.getQuantity());
		productRepository.save(existingProduct);
		
		return existingProduct;
	}

	@Override
	public Product deleteproduct(long productId) {
		Product existingProduct = productRepository.findById(productId).orElseThrow(() -> new ProductServiceCustomException(
                "Product with given Id not found",
                "PRODUCT_NOT_FOUND"
        ));
		 productRepository.deleteById(productId);
	       return existingProduct;
	}

	@Override
	public List<Product> getProductsByName(String productName) {
		 return productRepository.getProductsByName(productName);
	}

	@Override
	public List<Product> findByCategoryId(long id) {
		// TODO Auto-generated method stub
		return productRepository.findByCategoryId(id);
	}

	@Override
	public List<Product> findByPriceRange(long minimumPrice, long maximumPrice) {
		// TODO Auto-generated method stub
		return productRepository.findByPriceBetween(minimumPrice, maximumPrice);
	}
}
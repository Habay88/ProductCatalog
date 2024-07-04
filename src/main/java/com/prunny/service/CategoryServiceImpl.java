package com.prunny.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prunny.entity.Category;
import com.prunny.entity.Product;
import com.prunny.exception.CategoryServiceCustomException;
import com.prunny.exception.ProductServiceCustomException;
import com.prunny.repository.CategoryRepository;
import com.prunny.request.CategoryRequest;
import com.prunny.request.ProductRequest;
import com.prunny.response.CategoryResponse;
import com.prunny.response.ProductResponse;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public long addCategory(CategoryRequest categoryRequest) {
		  log.info("Adding category..");
		  Category  category = Category.builder()
				  .name(categoryRequest.getName())
				  
				  .build();
		 categoryRepository.save(category);
		log.info("Category created");
		return category.getCategoryId();
	}

	@Override
	public CategoryResponse getCategoryById(long categoryId) {
	    log.info("Get the category for categoryId: {}", categoryId);
	    Category category = categoryRepository.findById(categoryId)
	    		.orElseThrow(
	    				()-> new CategoryServiceCustomException("Category with given id not found","CATEGORY_NOT_FOUND"));
	    CategoryResponse categoryResponse = new CategoryResponse();
	    BeanUtils.copyProperties(category, categoryResponse);
	    				
		return categoryResponse;
	}

  

	@Override
	public List<CategoryResponse> getAllCategories() {
		List<Category> categories = categoryRepository.findAll();
		return categories.stream().map(this::mapToDtoResponse).toList();
	}
	
	private CategoryResponse mapToDtoResponse(Category category) {
		return CategoryResponse.builder()
				.id(category.getCategoryId())
				.name(category.getName())
			
				
				.build();
	}

	@Override
	public Category updateCategory(long categoryId, Category category) {
     Category existingCategory = categoryRepository.findById(categoryId).orElseThrow(
     ()-> new CategoryServiceCustomException("Category with given id not found","CATEGORY_NOT_FOUND"));
     existingCategory.setName(category.getName());
   
     categoryRepository.save(existingCategory);
     return existingCategory;
	}
	


	@Override
	public Category deleteCategory(long categoryId) {
		 Category existingCategory = categoryRepository.findById(categoryId).orElseThrow(
			     ()-> new CategoryServiceCustomException("Category with given id not found","CATEGORY_NOT_FOUND"));
		 categoryRepository.deleteById(categoryId);
		return existingCategory;
	}


	@Override
	public List<Category> getCatgoriesByName(String name) {
		// TODO Auto-generated method stub
		return categoryRepository.getCategoriesByName(name);
	}
	
}

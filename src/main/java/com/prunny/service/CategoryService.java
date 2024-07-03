package com.prunny.service;

import java.util.List;

import com.prunny.entity.Category;
import com.prunny.request.CategoryRequest;
import com.prunny.response.CategoryResponse;



public interface CategoryService {

	  long addCategory(CategoryRequest categoryRequest);

	    CategoryResponse getCategoryById(long categoryId);

	    

		List<CategoryResponse> getAllCategories();

		Category updateCategory(long categoryId, Category category);

		Category deleteCategory(long categoryId);

		List<Category> getCatgoriesByName(String name);
}

package com.prunny.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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

import com.prunny.entity.Category;
import com.prunny.entity.Product;
import com.prunny.request.CategoryRequest;
import com.prunny.request.ProductRequest;
import com.prunny.response.CategoryResponse;
import com.prunny.response.ProductResponse;
import com.prunny.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/save")
    public ResponseEntity<Long> createCategory(@Validated @RequestBody CategoryRequest categoryRequest) {
    	long categoryId = categoryService.addCategory(categoryRequest);
        return new ResponseEntity<>(categoryId, HttpStatus.CREATED);
    }
	

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CategoryResponse> getAllCategories() {
        return categoryService.getAllCategories();
    }


    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getCategoryById(@PathVariable("id") long id) {
    	CategoryResponse categoryResponse = categoryService.getCategoryById(id);
    	return new ResponseEntity<>(categoryResponse, HttpStatus.OK);
    }
 
    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @Validated @RequestBody Category category) {
        category.setid(id);
        return ResponseEntity.ok(categoryService.updateCategory(id,category));
    }

	/*
	 * @PutMapping("/{id}") public ResponseEntity<Category>
	 * updateCategory(@RequestParam(name="id") long id, @Validated @RequestBody
	 * Category category) { Category updatedCategory =
	 * categoryService.updateCategory(id, category); return new
	 * ResponseEntity<>(updatedCategory, HttpStatus.OK); }
	 */
    

    

    @DeleteMapping("/{id}")
    public ResponseEntity<Category> deleteCategory(@RequestParam(name ="id") long id) {
       Category deletedCategory = categoryService.deleteCategory(id);
    	
        return new ResponseEntity<>(deletedCategory, HttpStatus.OK);
    }
    

}
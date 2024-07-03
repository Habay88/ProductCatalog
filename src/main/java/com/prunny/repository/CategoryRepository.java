package com.prunny.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prunny.entity.Category;
import com.prunny.entity.Product;

public interface CategoryRepository extends JpaRepository<Category, Long> {

	List<Category> getCategoriesByName(String name);

	 
}

package com.prunny.request;

import com.prunny.entity.Category;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class ProductRequest {
	 private String name;
	    private long price;
	    private long quantity;
		@ManyToOne
    @JoinColumn(name = "category_id",nullable = false)
    private Category category;
}

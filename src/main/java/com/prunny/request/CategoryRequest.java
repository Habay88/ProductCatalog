package com.prunny.request;

import java.util.List;

import com.prunny.entity.Product;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
public class CategoryRequest {

	private String name;
    private String description;
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Product> products;
}

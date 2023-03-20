package com.Shop.model;

import com.Shop.entity.Product;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class CategoryDTO {

	
	private long categoryId;
	
	@NotNull
	private String categoryName;
	
	private Product product;
}

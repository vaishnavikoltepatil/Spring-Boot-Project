package com.Shop.model;

import jakarta.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {

	private long productId;
	@NotNull
	private String productName;
	private long price;
	private long quantity;
	
	private CustomerDTO Customer;
}


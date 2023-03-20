package com.Shop.model;

import com.Shop.entity.ShopManager;

import jakarta.validation.constraints.Email;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CustomerDTO {
  
	private int customer_id;
	@NotNull(message="Customer Name should not be null")
	
	private String customerName;
	
	@NotNull(message="Customer contactno should not be null")
	private String contactNo;
	
	
	private String address;
	
	@NotNull
	@Email(message="Customer emailId should not be null")
	private String emailId;
	
	private ShopManager sm;
	
}

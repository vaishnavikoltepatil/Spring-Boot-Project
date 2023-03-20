package com.Shop.model;

import java.util.List;


import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ShopManagerDTO {
	private int Shopmanager_Id;
	
	
	@NotNull
	private String  shopmanagerName;
	private List<CustomerDTO> customer;
	
}



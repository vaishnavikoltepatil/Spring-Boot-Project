package com.Shop.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.Shop.entity.Customer;
import com.Shop.model.CustomerDTO;

@Component
public class customerConverter {
	
	//converts from Customer entity to CustomerDTO
	public CustomerDTO convertEntityToCustomerDTO (Customer customer)
	{
		 CustomerDTO customerDTO = new CustomerDTO();
		 if(customer != null)
		 {
			 BeanUtils.copyProperties(customer, customerDTO);
			 
		 }
		 return customerDTO;
	}
	//converts from CustomerDTO to Customer entity
	public Customer convertDTOToCoustomer(CustomerDTO customerDTO)
	{
		Customer customer = new Customer();
		if(customerDTO!=null)
		{
			BeanUtils.copyProperties(customerDTO, customer);
			
		}
		return customer;
	}
	
	
}

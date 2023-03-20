package com.Shop.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Shop.entity.Customer;
import com.Shop.model.CustomerDTO;
import com.Shop.service.CustomerService;
import com.Shop.util.customerConverter;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private customerConverter  customerconverter;

	@PostMapping("/createCustomer")
	public String createCustomer (@Valid @RequestBody CustomerDTO customerDTO)
{
		final Customer customer= customerconverter.convertDTOToCoustomer(customerDTO);
	   return customerService.createCustomer(customer) ;
	
				
}
	@GetMapping("/getCustomerById/{id}")
	public CustomerDTO getCustomerById (@PathVariable("customer_id") int  customer_id)
{
	return customerService.getCustomerById(customer_id);
}

	@GetMapping("/getAllCustomer")
	public List<CustomerDTO> getAllCustomer(){
		return customerService.getAllCustomers();
		
	}
	
	@PutMapping("/updateCustomer/{customer_id}")
	public CustomerDTO updateCustomer (@PathVariable("customer_id") int customer_id,
			   @Valid @RequestBody CustomerDTO customerDTO)
	{
		Customer customer1 =customerconverter.convertDTOToCoustomer(customerDTO);
		return customerService.updateCustomer(customer_id, customer1);
		
	}
	@DeleteMapping("/deleteById/{customer_id}")
	public String deleteCustomerById(@PathVariable("customer_id") int customer_id)
	{
		return customerService.deleteCustomerById(customer_id);
		
	}
	@DeleteMapping("/deleteAllCustomers")
	public ResponseEntity<String> deleteAllCustomers()
	{
		customerService.deleteAllCustomers();
		return new ResponseEntity<String>("All customer details got deleted!!",
				HttpStatus.OK);
	}
	@GetMapping("/getCustomerByName/{customerName}")
	public List<CustomerDTO>  getCustomerByName(@PathVariable("customerName") String customerName)
	{
		return customerService.getCustomerByName(customerName);
		
	}
	@GetMapping("/getCustomerDTOByemail/{emailId}")
	public List<CustomerDTO> getCustomer(@PathVariable("emailId") String emailId)
	{
		return customerService.findByEmailId(emailId);
	}
	
	@PostMapping("/assignCustomerToShopManager/{customerid}/{Shopmanagerid}")
	public CustomerDTO assignCustomerToShopManager (@PathVariable ("customerid") int customerId,
		@PathVariable("Shopmanagerid") int ShopmanagerId)
{
	return customerService.assignCustomerToShopManager(customerId,ShopmanagerId);
}
}  


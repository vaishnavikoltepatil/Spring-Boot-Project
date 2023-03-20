package com.Shop.service;

import java.util.List;

import com.Shop.entity.Customer;
import com.Shop.model.CustomerDTO;

public interface CustomerService {
	String createCustomer(Customer customer); //save a new customer
	CustomerDTO getCustomerById(int customer_id); //fetch data of a customer using the id
	List<CustomerDTO> getAllCustomers();//fetch all customer
	CustomerDTO updateCustomer (int customer_id, Customer customer);//fetch and update the customer details
	String deleteCustomerById(int customer_id); //deleting a customer using id
	void deleteAllCustomers(); //delete all the customers
	List<CustomerDTO> getCustomerByName(String customerName);
	List<CustomerDTO> findByEmailId(String emailId);
	CustomerDTO assignCustomerToShopManager(int customerId,int ShopmanagerId);
}

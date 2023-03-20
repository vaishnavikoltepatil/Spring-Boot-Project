package com.Shop.CustomerTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.Shop.Repository.CustomerRepository;
import com.Shop.entity.Customer;
import com.Shop.model.CustomerDTO;
import com.Shop.service.CustomerService;
import com.Shop.util.customerConverter;

@SpringBootTest
public class CustomerServiceTest {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private customerConverter  customerconverter;
	

	@MockBean
	private CustomerRepository customerRepository;
	
	@Test
	void testCreateCustomer()
	{
		Customer customer=Customer.builder().customerName("Rutuja.").address("pune").contactNo("9874555555").emailId("Rutuja@gmail.com").build();
		Mockito.when(customerRepository.save(customer)).thenReturn(customer);
//		assertEquals("Customer details added successfully!!",
//				customerService.createCustomer(customer));
		
		assertThat(customerService.createCustomer(customer)).isEqualTo("Customer details added successfully!!");
			
	}
	@Test
	void testGetCustomerById()
	{
		Customer customer1= Customer.builder().customer_id(2).customerName("Rutuja.").address("pune").contactNo("9874555555").emailId("Rutuja@gmail.com").build();
		Mockito.when(customerRepository.save(customer1)).thenReturn(customer1);
		assertEquals("Rutuja.",customer1.getCustomerName());
	}
	
	@Test
	void testGetAllCustomers()
	{
		Customer customer=Customer.builder().customerName("Nikita").address("ABC Briged").contactNo("9954128454").emailId("nikita@gmail.com").build();
		Customer customer1=Customer.builder().customerName("Rutuja").address("pune").contactNo("9874555555").emailId("Rutuja@gmail.com").build();
				List<Customer>list=new ArrayList<Customer>();
				list.add(customer1);
				list.add(customer);
				
				Mockito.when(customerRepository.findAll()).thenReturn(list);
				
				List<CustomerDTO>dto =customerService.getAllCustomers();
				
				List<Customer> customers=new ArrayList<Customer>();
				dto.forEach(customerDto->
				customers.add(customerconverter.convertDTOToCoustomer(customerDto))
						);
				assertThat(customers.get(0).getCustomerName()).isEqualTo(list.get(0).getCustomerName());
	}
	
	@Test
	void testUpdateCustomer()
	{
		Customer customer=Customer.builder().customerName("Rutuja.").address("Pune").contactNo("9874555555").emailId("Rutuja@gmail.com").build();
		Optional<Customer> opCustomer= Optional.of(customer);
		
		Mockito.when(customerRepository.findById(customer.getCustomer_id())).thenReturn(opCustomer);
		
		Customer c =opCustomer.get();
		customer.setCustomerName("Nikita");
		
		Mockito.when(customerRepository.save(customer)).thenReturn(c);
		
		CustomerDTO dto=customerService.updateCustomer(customer.getCustomer_id(),customer);
		assertEquals(dto.getCustomerName(),c.getCustomerName());
				
				}
}

package com.Shop.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Shop.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
 
	@Query("from Customer a where a.customerName like %:c%")
	List<Customer> findByCustomerName(@Param("c")String customerName);
	
	List<Customer> findByEmailId (String emailId);
	
}

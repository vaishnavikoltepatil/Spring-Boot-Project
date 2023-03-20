package com.Shop.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customer_id;
	
	@NotNull(message= "Customer Name should not be null")
	@Column(length= 60, name="customerName")
	private String customerName;
	
	@NotNull(message= "Customer Address should not be null")
	@Column(length= 70)
	private String address;
	
	@NotNull
	@Pattern(regexp="^\\d{10}$", message="Phone number should have 10 digits")
	private String contactNo;
	
	@NotNull(message= "Customer EmailId should not be null")
	private String emailId;
	
	@JoinColumn
	@ManyToOne (cascade= CascadeType.ALL)
	private ShopManager sm;
	
	@Builder
	public Customer(int customer_id,String customerName,String address, String contactNo, String emailId) {
		super();
		this.customer_id=customer_id;
		this.customerName=customerName;
		this.address=address;
		this.contactNo=contactNo;
		this.emailId=emailId;
	}

	@OneToMany
	private List<Product> product;
	

	
		
}
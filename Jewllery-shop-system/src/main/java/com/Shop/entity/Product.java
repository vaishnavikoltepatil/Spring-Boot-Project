package com.Shop.entity;

import java.util.ArrayList;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
	@Table(name = "products")
	public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long productId;
	
	@Column(length= 50)
	private String productName;
	
	@Column(length= 50)
	private long price;
	
	@Column(length= 50)
	private long quantity;
	
	
	@ManyToOne
	private Customer customer;

	@Builder
	public Product(long productId,String productName, long price, long quantity)
	{
		super();
		this.productId=productId;
		this.productName=productName;
		this.price=price;
		this.quantity=quantity;
		
	}
	
	@ManyToOne
	private Category category;
	
	
	}
	
	

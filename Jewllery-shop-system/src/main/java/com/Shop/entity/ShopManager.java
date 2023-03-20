package com.Shop.entity;

import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class ShopManager {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Shopmanager_id;
	
	@Column(length = 50, nullable=false)
	private String shopmanagerName;
	
	
	@OneToMany(cascade =CascadeType.ALL)
	private List<Customer> customer;
	
	@Builder
	public ShopManager(int Shopmanager_id,String shopmanagerName) {
		super();
		this.Shopmanager_id=Shopmanager_id;
		this.shopmanagerName=shopmanagerName;
	}
}

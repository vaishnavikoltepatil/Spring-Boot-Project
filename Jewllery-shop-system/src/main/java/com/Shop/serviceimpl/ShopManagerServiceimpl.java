package com.Shop.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Shop.Repository.ShopManagerRepository;
import com.Shop.entity.ShopManager;
import com.Shop.model.ShopManagerDTO;
import com.Shop.service.ShopManagerService;
import com.Shop.util.ShopManagerConverter;

@Service
public class ShopManagerServiceimpl implements ShopManagerService{
	@Autowired
	private ShopManagerRepository shopmanagerRepository;
	@Autowired
	private ShopManagerConverter shopmanagerconverter;

	@Override
	public String createShopManager (ShopManager sm) {
		String message= null;
		
		
		 
		shopmanagerRepository.save(sm);
		
		if(sm!=null)
		{
			message="Shop details added successfully!!!!!";
		}
		return message;
	}

	@Override
	public ShopManagerDTO getShopManagerById(int ShopManager_id) {
		ShopManager sm= shopmanagerRepository.findById(ShopManager_id).get();
		return shopmanagerconverter.convertEntityToShopManagerDTO(sm);
			
	}

	@Override
	public List<ShopManagerDTO> getAllShopManager() {
		List<ShopManager> sm=shopmanagerRepository.findAll();
		List<ShopManagerDTO> shopmanagerDTO=new ArrayList<>();
		for(ShopManager s:sm)
		{
			shopmanagerDTO.add(shopmanagerconverter.convertEntityToShopManagerDTO(s));
		}
		return shopmanagerDTO;
	}

	@Override
	public ShopManagerDTO updateShopManager(int Shopmanager_id, ShopManager sm) {
		ShopManager existingShopManager = shopmanagerRepository.findById(Shopmanager_id).get();
		
		existingShopManager.setShopmanagerName(sm.getShopmanagerName());
		
		shopmanagerRepository.save(existingShopManager);
		
		return shopmanagerconverter.convertEntityToShopManagerDTO(existingShopManager);
	}

	@Override
	public List<ShopManagerDTO> getShopmanagerByshopmanagername(String shopmanagername) {
		List<ShopManager> shopmanager=shopmanagerRepository.findByShopmanagerName(shopmanagername);
		List<ShopManagerDTO> shopmanagerDTO =new ArrayList<>();
		for(ShopManager s: shopmanager)
		{
			shopmanagerDTO.add(shopmanagerconverter.convertEntityToShopManagerDTO(s));
		}
		return shopmanagerDTO;
	}

	
	}

	
	


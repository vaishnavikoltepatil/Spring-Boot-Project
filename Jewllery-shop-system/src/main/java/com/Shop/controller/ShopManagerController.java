package com.Shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Shop.entity.ShopManager;
import com.Shop.model.ShopManagerDTO;
import com.Shop.service.ShopManagerService;
import com.Shop.util.ShopManagerConverter;

import jakarta.validation.Valid;

@RestController
public class ShopManagerController {

	@Autowired
	private ShopManagerService shopmanagerService;
	
	@Autowired
	private ShopManagerConverter shopmanagerconverter;
	
	@PostMapping("/createShopManager")
	public String createShopManager (@Valid @RequestBody ShopManagerDTO shopmanagerDTO)
	{
		final ShopManager sm= shopmanagerconverter.convertDTOToShopManager(shopmanagerDTO);
		return shopmanagerService.createShopManager(sm) ;
		
	}
	@GetMapping("/getCustomerById/{Shopmanager_id}")
	public ShopManagerDTO getShopById(@PathVariable("Shopmanager_id") int Shopmanager_id)
	{
		return shopmanagerService.getShopManagerById(Shopmanager_id);
		
	
}
	@GetMapping("/getAllShopManager")
	public List<ShopManagerDTO> getAllShopManager(){
		return shopmanagerService.getAllShopManager();
		
	}
	
	@PutMapping("/updateShopManager/{id}")
	public ShopManagerDTO updateShopManager (@PathVariable("Shopmanager_id") int Shopmanager_id, 
			@RequestBody ShopManagerDTO shopmanagerDTO)
	{
		
		ShopManager sm1 = shopmanagerconverter.convertDTOToShopManager(shopmanagerDTO);
		return shopmanagerService.updateShopManager(Shopmanager_id, sm1);
		
	}
	@GetMapping("/getShopmanagerByName/{shopmanagername}")
	public List<ShopManagerDTO> getShopmanagerByName(@PathVariable("shopmanagername") String shopmanagername)
	{
		return shopmanagerService.getShopmanagerByshopmanagername(shopmanagername);
		
	}
}

package com.Shop.service;

import java.util.List;

import com.Shop.entity.ShopManager;
import com.Shop.model.ShopManagerDTO;

public interface ShopManagerService {
	String createShopManager(ShopManager sm);
	ShopManagerDTO getShopManagerById(int ShopManager_id);
	List<ShopManagerDTO> getAllShopManager();
	ShopManagerDTO updateShopManager (int Shopmanager_id, ShopManager sm);
	List<ShopManagerDTO> getShopmanagerByshopmanagername(String shopmanagername);
	
}

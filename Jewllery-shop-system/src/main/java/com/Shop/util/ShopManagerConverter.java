package com.Shop.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.Shop.entity.ShopManager;
import com.Shop.model.ShopManagerDTO;
@Component
public class ShopManagerConverter {
	
	public ShopManagerDTO  convertEntityToShopManagerDTO (ShopManager sm)
	{
		ShopManagerDTO shopmanagerDTO = new ShopManagerDTO();
		if(sm!=null)
		{
			BeanUtils.copyProperties(sm, shopmanagerDTO);
			
		}
		return shopmanagerDTO;
		
	}
	public ShopManager convertDTOToShopManager (ShopManagerDTO shopmanagerDTO)
	{
		ShopManager sm= new ShopManager();
		if(shopmanagerDTO != null)
		{
			BeanUtils.copyProperties(shopmanagerDTO, sm);
			
			
		}
		return sm;
	}

}


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

import com.Shop.Repository.ShopManagerRepository;
import com.Shop.entity.ShopManager;
import com.Shop.model.ShopManagerDTO;
import com.Shop.service.ShopManagerService;
import com.Shop.util.ShopManagerConverter;

@SpringBootTest
public class ShopManagerServiceTest {

	@Autowired
	private ShopManagerService shopmanagerService;
	
	@Autowired
	private ShopManagerConverter shopmanagerconverter;
	
	@MockBean
	private ShopManagerRepository shopmanagerRepository;
	
	@Test
	void testCreateShopManager()
	{
		ShopManager sm= ShopManager.builder().shopmanagerName("Adity shah").build();
		
		Mockito.when(shopmanagerRepository.save(sm)).thenReturn(sm);
		
		assertEquals("Shop details added successfully!!!!!",
				shopmanagerService.createShopManager(sm));
		
		assertThat(shopmanagerService.createShopManager(sm)).isEqualTo("Shop details added successfully!!!!!");
		
		
	}
	@Test
	void testGetShopManagerById()
	{
		ShopManager sm1 = ShopManager.builder().Shopmanager_id(2).shopmanagerName("Adity shah").build();
		
		Mockito.when(shopmanagerRepository.save(sm1)).thenReturn(sm1);
		assertEquals("Adity shah",sm1.getShopmanagerName());
		
	}
	@Test
	void testGetAllShopManager()
	{
		ShopManager sm= ShopManager.builder().shopmanagerName("Raj Gupta").build();
		ShopManager sm1= ShopManager.builder().shopmanagerName("Adity shah").build();
		
		List<ShopManager>list=new ArrayList<>();
		list.add(sm1);
		list.add(sm);
		
		Mockito.when(shopmanagerRepository.findAll()).thenReturn(list);
		
		List<ShopManagerDTO>dto= shopmanagerService.getAllShopManager();
		
		List<ShopManager> shopmanagers=new ArrayList<>();
		dto.forEach(shopmanagerDto->
		shopmanagers.add(shopmanagerconverter.convertDTOToShopManager(shopmanagerDto))
		);
		
		assertThat(shopmanagers.get(0).getShopmanagerName()).isEqualTo(list.get(0).getShopmanagerName());
		
	}
	@Test
		void testUpdateShopManager()
		{
			ShopManager sm =ShopManager.builder().shopmanagerName("Adity shah").build();
			
			Optional<ShopManager> opShopManager=Optional.of(sm);
			
			Mockito.when(shopmanagerRepository.findById(sm.getShopmanager_id())).thenReturn(opShopManager);
			
			ShopManager s= opShopManager.get();
			sm.setShopmanagerName("Raj Gupta");
			
			Mockito.when(shopmanagerRepository.save(sm)).thenReturn(s);
			
			ShopManagerDTO dto = shopmanagerService.updateShopManager(sm.getShopmanager_id(),sm);
			
			assertEquals(dto.getShopmanagerName(),s.getShopmanagerName());
		}
	}


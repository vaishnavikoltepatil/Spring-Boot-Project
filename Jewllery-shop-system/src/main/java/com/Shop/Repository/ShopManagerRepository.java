package com.Shop.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Shop.entity.ShopManager;

public interface ShopManagerRepository extends JpaRepository<ShopManager, Integer> {
	
	@Query("from ShopManager b where b.shopmanagerName like %:a%")
	List<ShopManager> findByShopmanagerName (@Param("a")  String shopmanagerName);
}

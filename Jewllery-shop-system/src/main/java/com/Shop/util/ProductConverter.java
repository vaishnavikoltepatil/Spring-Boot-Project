package com.Shop.util;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

import com.Shop.entity.Product;
import com.Shop.model.ProductDTO;

@Component
public class ProductConverter {

	public ProductDTO convertEntityToProductDTO (Product products)
	{
		ProductDTO productDTO = new ProductDTO();
		if(products != null)
		{
			BeanUtils.copyProperties(products, productDTO);
		}
		return productDTO;
	}
	
	public Product convertDTOToProduct(ProductDTO productDTO)
	{
		Product product = new Product();
		if(productDTO != null)
		{
			BeanUtils.copyProperties(productDTO, product);
		}
		return product;
	}
	
}


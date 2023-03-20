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

import com.Shop.Repository.ProductRepository;
import com.Shop.entity.Product;
import com.Shop.model.ProductDTO;
import com.Shop.service.ProductService;
import com.Shop.util.ProductConverter;

@SpringBootTest
public class ProductServiceTest {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductConverter productConverter;
	
	@MockBean
	private ProductRepository productRepository;
	
	@Test
	void testCreateProduct()
	{
		Product product= Product.builder().productName("Diamond Ring").price(1500000).quantity(1).build();
		
		Mockito.when(productRepository.save(product)).thenReturn(product);
//		assertEquals(" Product details added successfully",
//				productService.createProduct(product));
		
		assertThat(productService.createProduct(product)).isEqualTo("Product details added successfully");
	}
	
	@Test
	void testGetProductById()
	{
		Product product1= Product.builder().productId(2).productName("Diamond Ring").price(1500000).quantity(1).build();
		
		Mockito.when(productRepository.save(product1)).thenReturn(product1);
		 assertEquals("Diamond Ring",product1.getProductName());
	}
	
	@Test
	void testGetAllProducts()
	{
		Product product=Product.builder().productName("Necklace").price(250000).quantity(1).build();
		Product Product1=Product.builder().productName("Diamond Ring").price(1500000).quantity(1).build();
		
		List<Product>list= new ArrayList<>();
		list.add(Product1);
		list.add(product);
		
		Mockito.when(productRepository.findAll()).thenReturn(list);
		
		List<ProductDTO> dto= productService.getAllProducts();
		List<Product> products= new ArrayList<Product>();
		dto.forEach(productDto->
		products.add(productConverter.convertDTOToProduct(productDto))
		);
		
		assertThat(products.get(0).getProductName()).isEqualTo(list.get(0).getProductName());
		
	}
	@Test
		void testUpdateProduct()
		{
			Product product=Product.builder().productName("Diamond Ring").price(1500000).quantity(1).build();
			
			Optional<Product>opProduct= Optional.of(product);
			
			Mockito.when(productRepository.findById(product.getProductId())).thenReturn(opProduct);
			
			Product p=opProduct.get();
			product.setProductName("Necklace");
			
			Mockito.when(productRepository.save(product)).thenReturn(p);
			
			ProductDTO dto= productService.updateProduct(product.getProductId(),product);
			
			assertEquals(dto.getProductName(),p.getProductName());
		}
		
	}
	


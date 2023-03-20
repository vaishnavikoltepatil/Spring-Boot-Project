package com.Shop.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Shop.entity.Product;
import com.Shop.model.ProductDTO;
import com.Shop.service.ProductService;
import com.Shop.util.ProductConverter;

import jakarta.validation.Valid;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductConverter productConverter;
	
	@PostMapping("/createProduct")
	public String createCustomer(@Valid @RequestBody ProductDTO productDTO)
	{
		final Product products = productConverter.convertDTOToProduct(productDTO);
		return productService.createProduct(products);
	}
	
	@GetMapping("/getProductById/{productId}")
	public ProductDTO getProductById(@PathVariable("productId") long productId)
	{
		return productService.getProductById(productId);
	}
	
	@GetMapping("/getAllProducts")
	public List<ProductDTO> getAllProducts()
	{
		return productService.getAllProducts();
	}
	
	@PutMapping("/updateProduct/{producId}")
	public ProductDTO updateProduct(@PathVariable("productId") long productId,
			@RequestBody ProductDTO productDTO)	
	{
		Product prducts = productConverter.convertDTOToProduct(productDTO);
		return productService.updateProduct(productId, prducts);
	}
	
	@DeleteMapping("/deleteProductById/{productId}")
	public String deleteProductById(@PathVariable("productId") long productId)
	{
		return productService.deleteProductById(productId);
	}
	
	@DeleteMapping("/deleteAllProducts")
	public ResponseEntity<String> deleteAllProducts()
	{
		productService.deleteAllProducts();
		return new ResponseEntity<String>("All product details got deleted!",
				HttpStatus.OK);
	}
	
	@GetMapping("/getProductByName/{productName}")
	public List<ProductDTO> getProductByName(@PathVariable("productName") String productName)
	{
		return productService.getProductByName(productName);
}
}

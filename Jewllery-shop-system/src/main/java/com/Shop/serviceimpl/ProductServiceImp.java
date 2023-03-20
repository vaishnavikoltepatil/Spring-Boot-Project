package com.Shop.serviceimpl;

import java.util.ArrayList;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Shop.Repository.ProductRepository;
import com.Shop.entity.Product;
import com.Shop.exception.ResourceNotFoundException;
import com.Shop.model.ProductDTO;
import com.Shop.service.ProductService;
import com.Shop.util.ProductConverter;


@Service
public class ProductServiceImp implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductConverter productConverter;
	
	@Override
	public String createProduct(Product products) {
		String message = null;
		products.setProductName(products.getProductName());
		products.setPrice(products.getPrice());
		products.setQuantity(products.getQuantity());
		
		productRepository.save(products);
		if(products != null)
		{
			message="Product details added successfully";
		}		
		return message;
	}

	@Override
	public ProductDTO getProductById(long productId) {
		Product product = productRepository.findById(productId).get();
		return productConverter.convertEntityToProductDTO(product);
	}
	

	@Override
	public List<ProductDTO> getAllProducts() {
		List<Product> products = productRepository.findAll();
		List<ProductDTO> productDTO = new ArrayList<>();
		for(Product p : products)
		{
			productDTO.add(productConverter.convertEntityToProductDTO(p));
		}
		return productDTO;
	}

	@Override
	public ProductDTO updateProduct(long productId, Product products) {
Product existingProduct = productRepository.findById(productId).get();
		
		existingProduct.setProductName(products.getProductName());
		existingProduct.setPrice(products.getPrice());
		existingProduct.setQuantity(products.getQuantity());
		
		productRepository.save(existingProduct);
		return productConverter.convertEntityToProductDTO(existingProduct);
	}

	@Override
	public String deleteProductById(long productId) {
		String message = null;
		Optional<Product> products = productRepository.findById(productId);
		
		if(products.isPresent())
		{
			productRepository.deleteById(productId);
			message ="Product deleted successfully";
		}
		else
		{
			throw new ResourceNotFoundException("Product", "productId", productId);
		}
		return message;
	
	}

	@Override
	public void deleteAllProducts() {
		productRepository.deleteAll();
		
	}

	@Override
	public List<ProductDTO> getProductByName(String productName) {
		
		List<Product> products = productRepository.findByProductName(productName);
		List<ProductDTO> productDTO = new ArrayList<>();
		for(Product p : products)
		{
			productDTO.add(productConverter.convertEntityToProductDTO(p));
		}
		return productDTO;

	
		
	}
}
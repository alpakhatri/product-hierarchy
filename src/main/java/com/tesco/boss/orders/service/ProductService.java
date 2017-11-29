package com.tesco.boss.orders.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tesco.boss.orders.domain.Category;
import com.tesco.boss.orders.domain.Product;
import com.tesco.boss.orders.repo.CustomRepository;
import com.tesco.boss.orders.repo.ProductRepository;

@Service
public class ProductService {

	Logger logger = LoggerFactory.getLogger(ProductService.class);

	@Autowired
	 private ProductRepository productRepository;

	@Autowired
	 private CustomRepository customRepository;

	public Product create(Product product) {
		return productRepository.save(product);
	}

	public Product findById(int id) {
		return productRepository.findOne(id);
	}

	public List<Product> findByProductNameForCategories(String name, List<Category> categories) {
		List<Product> products = new ArrayList<>();
		categories.forEach(category -> {
			Product product = productRepository.findByCategoryIdAndName(category.getId(), name);
			if(product != null)
				products.add(product);
			
		});
		return products;
	}

	public List<Product> findProductByName(String name) {
		List<Product> products = new ArrayList<>();
		customRepository.searchByName(name).forEach(product -> products.add(product));
		return products;
	}

	public Map<String, Double> findProductPriceByName(String name) {
		Map<String, Double> priceByName = new HashMap<>();
		List<Product> products = productRepository.findProductByName(name);
		products.forEach(product -> priceByName.put(product.getName(), Double.valueOf(product.getPrice())));
		return priceByName;
	}

	public List<Product> findProductForPrice(double price, List<Category> categories) {
		List<Product> products = new ArrayList<>();
		categories.forEach(category -> products.addAll(productRepository.findByCategoryIdAndPriceLessThan(category.getId(),price)));
		return products;
	}
	   
	
}

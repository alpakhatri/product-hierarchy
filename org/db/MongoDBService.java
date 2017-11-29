package com.tesco.boss.orders.db;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.tesco.boss.orders.entity.Category;
import org.tesco.boss.orders.entity.Product;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.Block;

public class MongoDBService implements DBService{ 
	  
	private static final String PRODUCT_COLLECTION = "productDetails";
	private static final String CATEGORY_COLLECTION = "categoryDetails";
	private static final String PRODUCT_DB = "productDB";
	private static final List<Category> categories = new ArrayList<>();
	private static final List<Product> products = new ArrayList<>();

	public MongoDBService(){
		initializeCategories();
		initializeProducts();
	}
	private void initializeProducts(){
		MongoDBUtils.getCollection(PRODUCT_DB, PRODUCT_COLLECTION).find().forEach((Block<Document>)document -> {
			try {
				Product readValue = new ObjectMapper().readValue(document.toJson(), Product.class);
				products.add(readValue);
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		});
	}
	
	private void initializeCategories(){
		MongoDBUtils.getCollection(PRODUCT_DB, CATEGORY_COLLECTION).find().forEach((Block<Document>)document -> {
			try {
				Category readValue = new ObjectMapper().readValue(document.toJson(), Category.class);
				categories.add(readValue);
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		});
	}
	
	@Override
	public  List<Product> getProducts(){
		return products;
		
	}
	
	@Override
	public  List<Category> getCategories(){
		return categories;
		
	}
}

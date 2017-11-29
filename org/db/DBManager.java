package com.tesco.boss.orders.db;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.tesco.boss.orders.entity.Category;
import org.tesco.boss.orders.entity.Product;

public class DBManager{
	
	private static Map<String,Product> productDetailsByName = new HashMap<>();
	private static Map<Integer,Category> categoryDetailsById = new HashMap<>();

	public DBManager(){
	
		DBService service = DBStrategyFactory.getDBServiceFor("Mongo");

		List<Product> products = service.getProducts();
		products.forEach(productdetail -> getProductsByName().put(productdetail.getName(), productdetail));

		List<Category> categories = service.getCategories();
		categories.forEach(categorydetail -> getCategoriesById().put(categorydetail.getId(), categorydetail));

	}

	public  Map<String,Product> getProductsByName() {
		return productDetailsByName;
	}

	public  Map<Integer,Category> getCategoriesById() {
		return categoryDetailsById;
	}
}

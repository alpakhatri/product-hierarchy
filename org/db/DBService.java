package com.tesco.boss.orders.db;

import java.util.List;

import org.tesco.boss.orders.entity.Category;
import org.tesco.boss.orders.entity.Product;

public interface DBService {

	public List<Product> getProducts();
	
	public List<Category> getCategories();
}

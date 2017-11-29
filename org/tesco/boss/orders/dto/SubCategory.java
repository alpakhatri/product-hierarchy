package org.tesco.boss.orders.dto;

import java.util.List;

public class SubCategory {

	public SubCategory(){
		
	}
	
	
	String name;
	List<Product> products ;
	

	public List<Product> getProducts() {
		return products;
	}

}

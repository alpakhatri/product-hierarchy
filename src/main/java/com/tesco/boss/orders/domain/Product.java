	package com.tesco.boss.orders.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Product")
public class Product{

	 @Id
	 @GeneratedValue
	 private int id;
	
	 private String name;
	
	 private double price;

	 private int categoryId;

	protected Product(){
		
	}
	
	
	@ManyToOne
	@JoinColumn(name = "categoryId")
	private Category category;
	
	public Product( String name, double price,int categoryId) {
		this.setName(name);
		this.setPrice(price);
		this.setCategoryId(categoryId);
	}
	
	@Override
	public String toString() {
	    return   this.getName() + " : "+this.getPrice() ;
	}

	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}

	private void setName(String name) {
		this.name = name;
	}

	private void setPrice(double price) {
		this.price = price;
	}
	
	public int getId() {
		return id;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

}

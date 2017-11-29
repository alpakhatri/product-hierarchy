package org.tesco.boss.orders.dto;

public class Product implements Comparable<Product>{
	
	public Product(String name, double price) {
		this.name  = name;
		this.price = price;
	}
	
	public Product(){
		
	}
	private int id;
	private String name;
	private double price;

	
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	
	@Override
	public String toString() {
	    return this.name + " : "+this.price;
	}

	@Override
	public int compareTo(Product product) {
		if(product.getName() !=null && product.getName().equals(this.getName()))
			return 0;
		else if (!product.getName().equals(this.getName()) && product.getPrice() == this.getPrice())
			return 0;
		else if(!product.getName().equals(this.getName()) && (this.getPrice() - product.getPrice()) > 0 )
			return 1;
		else if(!product.getName().equals(this.getName()) && (this.getPrice() - product.getPrice()) < 0 )
			return -1;
		return 0;
	}

	public Product getProduct(){
		return this;
	}
}

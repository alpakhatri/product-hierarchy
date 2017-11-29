package org.tesco.boss.orders.utils;

import java.util.Comparator;

import org.tesco.boss.orders.dto.Product;

public class ProductNameComparator implements Comparator<Product>{
	@Override
	public int compare(Product p1, Product p2) {
		return  p1.getName().compareTo(p2.getName());
	}
}

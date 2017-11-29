package com.tesco.boss.orders.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tesco.boss.orders.domain.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product,Integer>{
	
	Product findByName(String name);
	
	List<Product> findByPrice(double price);
	
	List<Product> findByCategoryId(int categoryId);

	Product findByCategoryIdAndName(int categoryId, String name);

	List<Product> findProductByName(String name);

	List<Product> findByCategoryIdAndPriceLessThan(int id, double price);

}

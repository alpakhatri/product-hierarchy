package com.tesco.boss.orders.repo;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.tesco.boss.orders.domain.Product;

@Repository
public class CustomRepository {


	@Autowired
	MongoTemplate mongoTemplate;
	
	public Collection<Product> searchByName(String name){
		Query query = new Query();
		query.addCriteria(Criteria.where("name").regex(name));
		return mongoTemplate.find(query , Product.class);
	}
}

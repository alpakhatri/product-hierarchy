package com.tesco.boss.orders;

import java.util.HashMap;
import java.util.Map;

public class DBConfigFactory {
	
	public static Map<String,Database> map = new HashMap<String,Database>();
	
	static{
		map.put("Mongo",new MongoConfiguration());
	}
	
	public static Database getDatabaseFor(String key){
		return map.get(key);
	}
}

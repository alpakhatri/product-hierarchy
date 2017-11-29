package com.tesco.boss.orders.db;

import java.util.HashMap;
import java.util.Map;

public class DBStrategyFactory {
	static Map<String,DBService> dbServiceByDBName = new HashMap<>();
	
	static{
		dbServiceByDBName.put("Mongo",new MongoDBService());
	}
	
	public static DBService getDBServiceFor(String key){
		return dbServiceByDBName.get(key);
	}
}

package com.tesco.boss.orders.db;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ReadPreference;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDBUtils {
	
	private static final String HOST = "localhost:27017";
	private static volatile MongoClient client = null;
	private static Object lockKey = new Object();
	
	private MongoDBUtils(){
		
	}
	
	public static MongoClient getMongoClient(){
		if(client != null)
		{
			return client;
		}
		synchronized(lockKey)
		{
			if(client == null){
				MongoClientOptions settings = MongoClientOptions.builder().readPreference(ReadPreference.primary())
					    .codecRegistry(com.mongodb.MongoClient.getDefaultCodecRegistry()).build();
				client = new MongoClient(HOST ,settings);
			}
			return client;
		}
	}
	
	
	public static MongoDatabase getDatabase(String dbName){
		return getMongoClient().getDatabase(dbName);
	}
	
	public static  MongoCollection<Document> getCollection(String dbName , String collectionName){
		return getDatabase(dbName).getCollection(collectionName);
	}
	
	public static  <T> MongoCollection<T> getCollection(String dbName , String collectionName,Class<T> docClass){
		return getDatabase(dbName).getCollection(collectionName,docClass);
	}
}

package com.amazonaws.lambda.java_api;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName="users")
public class user_object {
	private long id;
	private String name;
	private long followers;
	private String lang;
	
	@DynamoDBHashKey(attributeName="id")
	public long getId() { return id; }
	public void setId(long id) { this.id = id; }
	
	@DynamoDBAttribute(attributeName="name")
	public String getName() { return name;	}
	public void setName(String name) {	this.name = name; }
	
	@DynamoDBAttribute(attributeName="followers")
	public long getFollowers() { return followers; }
	public void setFollowers(long followers) { this.followers = followers; }
	
	@DynamoDBAttribute(attributeName="lang")
	public String getLang() { return lang; }
	public void setLang(String lang) { this.lang = lang; }
	
	@Override
	public String toString() {
		return "user_object [id=" + id + ", name=" + name + ", followers=" + followers + ", lang=" + lang + "]";
	}	
	
	public String toJSON() {
		return "{\"id\":" + id + ",\"name\":\"" + name + "\",\"followers\":" + followers + ",\"lang\":\"" + lang + "\"}";
	}
}

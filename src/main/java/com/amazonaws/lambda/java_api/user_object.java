package com.amazonaws.lambda.java_api;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName="users")
public class user_object {
	private Long id;
	private String name;
	private Long followers;
	private String lang;
	
	@DynamoDBHashKey(attributeName="id")
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	
	@DynamoDBAttribute(attributeName="name")
	public String getName() { return name;	}
	public void setName(String name) {	this.name = name; }
	
	@DynamoDBAttribute(attributeName="followers")
	public Long getFollowers() { return followers; }
	public void setFollowers(Long followers) { this.followers = followers; }
	
	@DynamoDBAttribute(attributeName="lang")
	public String getLang() { return lang; }
	public void setLang(String lang) { this.lang = lang; }
	
	@Override
	public String toString() {
		return "user_object [id=" + id + ", name=" + name + ", followers=" + followers + ", lang=" + lang + "]";
	}	
}

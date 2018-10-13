package com.amazonaws.lambda.java_api;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;


@DynamoDBTable(tableName="tweets")
public class tweet_object {
	private Integer id;
    private String category;
    private String text;
    private Integer timestamp;
    private Integer user_id;
    private String user_name;
    private Integer user_followers;
    private String lang;
    
    @DynamoDBHashKey(attributeName="id")
	public Integer getId() {return id;	}
	public void setId(Integer id) {	this.id = id; }
	
	@DynamoDBAttribute(attributeName="category")
	public String getCategory() { return category; }
	public void setCategory(String category) { this.category = category; }
	
	@DynamoDBAttribute(attributeName="text")
	public String getText() { return text; }
	public void setText(String text) { this.text = text; }
	
	@DynamoDBAttribute(attributeName="date_time")
	public Integer getTimestamp() { return timestamp; }
	public void setTimestamp(Integer timestamp) { this.timestamp = timestamp; }
	
	@DynamoDBAttribute(attributeName="user_id")
	public Integer getUser_id() { return user_id; }
	public void setUser_id(Integer user_id) { this.user_id = user_id; }
	
	@DynamoDBAttribute(attributeName="user_name")
	public String getUser_name() { return user_name; }
	public void setUser_name(String user_name) { this.user_name = user_name; }
	
	@DynamoDBRangeKey(attributeName="user_followers")
	public Integer getUser_followers() { return user_followers; }
	public void setUser_followers(Integer user_followers) { this.user_followers = user_followers; }
	
	@DynamoDBAttribute(attributeName="user_lang")
	public String getLang() { return lang; }
	public void setLang(String lang) { this.lang = lang; }
	
	@Override
	public String toString() {
		return "tweet_object [id=" + id + ", category=" + category + ", text=" + text + ", timestamp=" + timestamp
				+ ", user_id=" + user_id + ", user_name=" + user_name + ", user_followers=" + user_followers + ", lang="
				+ lang + "]";
	}    
}

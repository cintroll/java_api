package com.amazonaws.lambda.java_api;

import com.amazonaws.lambda.java_api.user_object;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;


@DynamoDBTable(tableName="tweets")
public class tweet_object {
	private long id;
    private String hashtag;
    private String text;
    private String datetime;
    private long user_id;
    private user_object user;
    
    @DynamoDBHashKey(attributeName="id")
	public long getId() {return id;	}
	public void setId(long id) { this.id = id; }
	
	@DynamoDBAttribute(attributeName="hashtag")
	public String getCategory() { return hashtag; }
	public void setCategory(String category) { this.hashtag = category; }
	
	@DynamoDBAttribute(attributeName="text")
	public String getText() { return text; }
	public void setText(String text) { this.text = text; }
	
	@DynamoDBAttribute(attributeName="date_time")
	public String getTimestamp() { return datetime; }
	public void setTimestamp(String timestamp) { this.datetime = timestamp; }
	
	@DynamoDBAttribute(attributeName="user_id")
	public long getUser_id() { return user_id; }
	public void setUser_id(long user_id) { this.user_id = user_id; }
	
	public void setUser(user_object user) { this.user = user; } 
	
	@Override
	public String toString() {
		return "tweet_object [id=" + id + ", hashtag=" + hashtag + ", text=" + text + ", datetime=" + datetime
				+ ", user=  " + user + "]";
	}   
	
	public String toJson() {
		return "{\"id\":" + id + ",\"hashtag\":\"" + hashtag + "\",\"text\":\"" + text + "\",\"datetime\":\"" + datetime
				+ "\",\"user\":" + user.toJSON() + "}";
	}   
}

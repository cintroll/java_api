package com.amazonaws.lambda.java_api;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.GetItemSpec;

public class tweet_query {		
	static AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().withRegion(Regions.SA_EAST_1).build();
    static DynamoDB dynamoDB = new DynamoDB(client);

    
    public String five_more_followed_users() {
    	Table statistics_table = dynamoDB.getTable("statistics");
    	
    	DynamoDBMapper mapper = new DynamoDBMapper(client);
    	
    	GetItemSpec spec = new GetItemSpec()
    		    .withPrimaryKey("id", 1)
    		    .withConsistentRead(true);
    	
    	Item item = statistics_table.getItem(spec);

    	JSONArray queryResult = new JSONArray(item.getJSON("data"));
    	JSONObject JSONItem = null;   
    	user_object user = null;
    	for(int i = 0; i < queryResult.length(); ++i) {
    		JSONItem = queryResult.getJSONObject(i);
    		user = mapper.load(user_object.class, JSONItem.get("user_id"));
    		
    		JSONItem.put("user_name", user.getName());    		
    	}
    	
    	return queryResult.toString();    
    }
    
    public String hour_day_group() {
    	Table statistics_table = dynamoDB.getTable("statistics");
    	
    	GetItemSpec spec = new GetItemSpec()
    		    .withPrimaryKey("id", 2)
    		    .withConsistentRead(true);
    	
    	Item item = statistics_table.getItem(spec);

    	JSONArray queryResult = new JSONArray(item.getJSON("data"));
    	
    	return queryResult.toString();    
    }	
    
    public String hashtag_lang_group() {
    	Table statistics_table = dynamoDB.getTable("statistics");
    	
    	GetItemSpec spec = new GetItemSpec()
    		    .withPrimaryKey("id", 3)
    		    .withConsistentRead(true);
    	
    	Item item = statistics_table.getItem(spec);

    	JSONArray queryResult = new JSONArray(item.getJSON("data"));
    	
    	return queryResult.toString();    
    }
    
    public String query_tweets() {    	
    	DynamoDBMapper mapper = new DynamoDBMapper(client);
    	
    	List<tweet_object> tweets = mapper.parallelScan(tweet_object.class, new DynamoDBScanExpression(), 4);
    	
    	JSONArray JSONOut = new JSONArray();    	
    	for (tweet_object tweet : tweets) {
    		tweet.setUser(mapper.load(user_object.class, tweet.getUser_id()));
    		try {

        		JSONOut.put(new JSONObject(tweet.toJson()));
    		}
    		catch (org.json.JSONException e)
    		{
    			continue;
    		}
    	}
    	
    	return JSONOut.toString();
    }

}

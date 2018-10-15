package com.amazonaws.lambda.java_api;

import com.amazonaws.lambda.java_api.tweet_object;
import com.amazonaws.regions.Regions;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.ItemCollection;
import com.amazonaws.services.dynamodbv2.document.Page;
import com.amazonaws.services.dynamodbv2.document.QueryOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;

import org.json.*;

public class tweet_query {		
	static AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().withRegion(Regions.SA_EAST_1).build();
    static DynamoDB dynamoDB = new DynamoDB(client);

    
    public String five_more_followed_users() {
    	Table statistics_table = dynamoDB.getTable("statistics");
    	
    	DynamoDBMapper mapper = new DynamoDBMapper(client);
    	
    	QuerySpec spec = new QuerySpec()
    		    .withKeyConditionExpression("id = :v_id")
    		    .withValueMap(new ValueMap()
    		        .withNumber(":v_id", 1));
    	
    	ItemCollection<QueryOutcome> items = statistics_table.query(spec);

    	Iterator<Item> iterator = items.iterator();
    	Item item = null;
    	String out = new String();
    	while (iterator.hasNext()) {
    	    item = iterator.next();
    	    out += item.toJSONPretty();
    	}
    	
//    	Map<String, AttributeValue> eav = new HashMap<String, AttributeValue>();
//        eav.put(":val1", new AttributeValue().withN("1047886537344606210"));
//        eav.put(":val2", new AttributeValue().withS("apigateway"));
//    	
//    	DynamoDBQueryExpression<tweet_object> query = new DynamoDBQueryExpression<tweet_object>().
//    				withKeyConditionExpression("id = :val1 and hashtag = :val2").withExpressionAttributeValues(eav)
//    				.withScanIndexForward(false);
//    	query.setLimit(5);
//    	
//    	List<tweet_object> resp = mapper.query(tweet_object.class, query);
//    	
//    	String out = new String();
//    	for (tweet_object tweet : resp) {
//    		tweet.setUser(mapper.load(user_object.class, tweet.getUser_id()));
//			out += tweet.toString();
//		}
//    	
    	return out;
    }

}

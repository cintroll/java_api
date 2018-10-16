package com.amazonaws.lambda.java_api;

import com.amazonaws.lambda.java_api.tweet_query;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;

import org.json.*;

public class LambdaFunctionHandler implements RequestStreamHandler {

    @Override
    public void handleRequest(InputStream input, OutputStream output, Context context) throws IOException {

        // TODO: Implement your stream handler. See https://docs.aws.amazon.com/lambda/latest/dg/java-handler-io-type-stream.html for more information.
    	byte[] request = new byte[2048];
    	int requestSize = input.read(request);
    	if (requestSize > 0)
    	{
    		JSONObject requestJSON = new JSONObject(new String(request));
        	
        	tweet_query query = new tweet_query();
        	try {
        		switch(requestJSON.getInt("type")) {
            	case 0:
            		output.write(query.query_tweets().getBytes());
            		break;
            	case 1:
            		output.write(query.five_more_followed_users().getBytes());
            		break;
            	case 2:
            		output.write(query.hour_day_group().getBytes());
            		break;
            	case 3:
            		output.write(query.hashtag_lang_group().getBytes());
            		break;
            	default:
            		output.write("Invalid request".getBytes());
            		break;
            	}
        	}
        	catch (org.json.JSONException e) {
        		output.write("Invalid request".getBytes());
        	}        	
    	}
    	else
    	{
    		output.write("Invalid request".getBytes());
    	}
    }

}

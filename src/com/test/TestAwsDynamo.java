package com.test.dynamoDB;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.model.AttributeAction;
import com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.AttributeValueUpdate;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.CreateTableResult;
import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.services.dynamodbv2.model.KeyType;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.PutItemRequest;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;
import com.amazonaws.services.dynamodbv2.model.UpdateItemRequest;
import com.amazonaws.services.dynamodbv2.model.UpdateItemResult;
public class TestAwsDynamo {

	
	public static String ACCESS_KEY = "123";
	public static String SECRET_KEY = "456";
	
	private AmazonDynamoDBClient client;
	private String itemTable = "items";
	
	TestAwsDynamo(){
		AWSCredentials credentials = new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY);
		client  = new AmazonDynamoDBClient(credentials);
	}
	
	public void createTable(){
		ArrayList<AttributeDefinition> attrDefs = new ArrayList<AttributeDefinition>();
		attrDefs.add(new AttributeDefinition().withAttributeName("item_id").withAttributeType("N"));
		
		ArrayList<KeySchemaElement> schema = new ArrayList<KeySchemaElement>();
		schema.add(new KeySchemaElement()
					.withAttributeName("item_id").withKeyType(KeyType.HASH));
		
		ProvisionedThroughput throughPut = new ProvisionedThroughput().withReadCapacityUnits(1L).withWriteCapacityUnits(1L);
		
		
		CreateTableRequest request = new CreateTableRequest()
										.withTableName(itemTable)
										.withAttributeDefinitions(attrDefs)
										.withKeySchema(schema)
										.withProvisionedThroughput(throughPut);
		
		CreateTableResult result = client.createTable(request);
		
		System.out.println("Table created : "+ result.getTableDescription().getTableName());
		
		
	}
	
	public void insertData(){
		Map<String, AttributeValue> item = new HashMap<String,AttributeValue>();
		
		item.put("item_id", new AttributeValue().withN("1"));
		item.put("name", new AttributeValue().withS("iphone"));
		item.put("manufacturer", new AttributeValue().withS("Apple"));
		item.put("cost", new AttributeValue().withN("100"));
		item.put("selling_cost", new AttributeValue().withN("150"));
		
		PutItemRequest request = new PutItemRequest()
									.withTableName(itemTable)
									.withItem(item);
		
		client.putItem(request);
		
		System.out.println("Item inserted.");
		
	}
	
	public void getItems(){
		ScanRequest request = new ScanRequest().withTableName(itemTable);
		ScanResult result = client.scan(request);
		
		for(Map<String,AttributeValue> item : result.getItems()){
			System.out.println("item_id : "+item.get("item_id").getN());
			System.out.println("manufacturer : "+item.get("manufacturer").getS());
		}
		
	}
	
	
	public void updateItem(){
		Map<String, AttributeValue> pk = new HashMap<String,AttributeValue>();
		
		pk.put("item_id", new AttributeValue().withN("1"));
		
		Map<String, AttributeValueUpdate> item = new HashMap<String,AttributeValueUpdate>();
		item.put("selling_cost", new AttributeValueUpdate().withAction(AttributeAction.PUT)
				.withValue(new AttributeValue().withN("125")));
		
		UpdateItemRequest request = new UpdateItemRequest()
										.withTableName(itemTable)
										.withKey(pk)	
										.withAttributeUpdates(item);	
		
		client.updateItem(request);
		
		System.out.println("Updated Successfully");
		
	}
	
	public static void main(String[] args) {
		
		TestAwsDynamo dynamoDB = new TestAwsDynamo();
		//dynamoDB.createTable();
		//dynamoDB.insertData();
		//dynamoDB.getItems();
		
		dynamoDB.updateItem();
	}

}

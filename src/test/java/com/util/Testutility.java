package com.util;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.api.pojo.CreateJobPojo;
import com.api.pojo.Customer;
import com.api.pojo.CustomerProduct;
import com.api.pojo.Problems;
import com.api.pojo.customer_address;
import com.github.javafaker.Faker;
import com.google.gson.Gson;

public class Testutility {
	 public static  String convertPOJOToJSON (Object data) {
		 Gson gson = new Gson();
		 String result = gson.toJson(data); 
		 return result;
	 }
	 
	 public static String getPropertFrom(String propertyFileName , String Key) throws IOException {
			File myPropertyFile = new File(System.getProperty("user.dir")+ "\\Config\\qa.properties");
			FileReader fileReader = new FileReader(myPropertyFile);
			Properties properties = new Properties();
			properties.load(fileReader); 
			String value = properties.getProperty(Key);
			return value;
			
	 }
	 
		public static CreateJobPojo getCreateJobBodyRequest() {
	        
			Faker faker = new Faker();
			Customer customer = new Customer(faker.name().firstName(), faker.name().lastName(), faker.numerify("#########") ,faker.numerify("#########"), faker.internet().emailAddress(),faker.internet().emailAddress());
	        customer_address customer_address = new customer_address( faker.numerify("###"), faker.address().streetAddress(),  faker.address().streetAddress(),  faker.address().streetAddress(),  faker.address().streetAddress(), faker.numerify("######") , "India", "Maharashtra");
	        String imei = faker.numerify("##############");
	        CustomerProduct customer_Product = new CustomerProduct("2023-03-13T18:30:00.000Z", imei, imei, imei, "2023-03-13T18:30:00.000Z", 1, 1);
	        Problems[] problems =  new Problems[1];
	        problems[0] = new Problems(1, "Heating isssue");
	        CreateJobPojo createJobPOJO = new CreateJobPojo(0, 2, 2, 1, customer, customer_address, customer_Product, problems);
	        
	        return createJobPOJO ;
		}

}

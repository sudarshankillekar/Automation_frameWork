package com.util;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.hamcrest.Matchers;

import com.api.pojo.CreateJobPojo;
import com.api.pojo.Customer;
import com.api.pojo.CustomerProduct;
import com.api.pojo.LoginApiPojo;
import com.api.pojo.Problems;
import com.api.pojo.customer_address;
import com.github.javafaker.Faker;
import com.google.gson.Gson;

import io.restassured.http.Header;
import io.restassured.mapper.ObjectMapper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class Testutility {
	JsonPath jsonPath;
	
	
	public static int jobId ;
	
	
	
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

		
		public static String getAuthToken (ROLE role) {
		 LoginApiPojo loginApiPojo = null;
		if(role == ROLE.FD) {
			loginApiPojo = new LoginApiPojo("iamfd","password");
		}
		
		else if(role == ROLE.SUP)
		{
			loginApiPojo = new LoginApiPojo("iamsup","passwoord");
		}
		else if(role == ROLE.QC)
		{
			loginApiPojo = new LoginApiPojo("iamqc","passwoord");
		}
		else if(role == ROLE.ENGG)
		{
			loginApiPojo = new LoginApiPojo("iamengg","passwoord");
		}
		String Body = convertPOJOToJSON(loginApiPojo);
		 Response response =   given().header(new Header("Content-Type","application/json"))
		 .body(Body)
		 .post("/login");
		 
		 JsonPath jsonpath = new JsonPath(response.asPrettyString());
	     String Token = 	 jsonpath.getString("data.token");
	     return Token;
}

	
}

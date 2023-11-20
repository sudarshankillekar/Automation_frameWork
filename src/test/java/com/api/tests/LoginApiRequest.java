package com.api.tests;

import com.api.pojo.LoginApiPojo;

import static io.restassured.RestAssured.*;
import static com.util.Testutility.*;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class LoginApiRequest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	baseURI = "http://139.59.91.96:9000/v1";
	Response response = given()
		.header(new Header("Content-Type", "application/json"))
		.body(convertPOJOToJSON(new LoginApiPojo("iamfd", "password")))
		.post("/login");		
        System.out.println(response.asPrettyString());
        System.out.println(response.getStatusCode());
        System.out.println(response.getTime());
        
        JsonPath jsonPath = new JsonPath(response.asPrettyString());
        String data = jsonPath.getString("message"); 
        System.out.println(data);
	}

}

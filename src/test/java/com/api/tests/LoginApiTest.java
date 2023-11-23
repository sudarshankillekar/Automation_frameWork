package com.api.tests;

import com.api.pojo.LoginApiPojo;
import static org.hamcrest.Matcher.*;

import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.sql.Time;

import org.hamcrest.Matchers;
import org.hamcrest.core.StringContains;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.util.Testutility.*;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class LoginApiTest {
	
	@BeforeMethod
	public void setup() throws IOException {
		baseURI = getPropertFrom("qa.properties","BASE_URL");
	}
	
	
	@Test(description = "verify login using api request and check message as Success")
	public void loginApiTest() throws IOException {
	    given()
		.header(new Header("Content-Type", "application/json"))
		.body(convertPOJOToJSON(new LoginApiPojo("iamfd", "password")))
		.when()
		      .log().all()
		      .post("/login")
		 .then()
		      .log().all()
		      .assertThat()
		      .statusCode(200)
	          .time(Matchers.lessThan(5000L))
	          .body(Matchers.containsString("Success"));
	
       
 
	}

}

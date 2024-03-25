package com.api.tests;

import com.api.pojo.LoginApiPojo;
import static org.hamcrest.Matcher.*;

import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.sql.Time;

import org.hamcrest.Matchers;
import org.hamcrest.core.StringContains;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.util.Testutility.*;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import java.io.*;

public final class LoginApiTest extends  ApiTestBase {
	
	JsonPath jsonPath;
	File  jsonFilePath = new File( "C:\\Users\\Lenovo\\eclipse-workspace\\PhoenixAutomationFrameWork\\src\\test\\resources\\responseSchema\\loginResponseSchema.json");
	
	
	@Test(description = "verify login using api request and check message as Success", groups = {"e2e"} ,retryAnalyzer = com.util.MyRetryAnalyzer.class)
	public void loginApiTest() throws IOException {
	 jsonPath =    given()
		.header(new Header("Content-Type", "application/json"))
		.body(convertPOJOToJSON(new LoginApiPojo("iamfd", "password")))
		.when()
		      .log().all()
		      .post("login")
		 .then()
		      .log().all()
		      .assertThat()
		      .statusCode(200)
	          .time(Matchers.lessThan(5000L))
	          .body(JsonSchemaValidator.matchesJsonSchema(jsonFilePath))
	          .extract().jsonPath();
	    
	    Assert.assertEquals(jsonPath.getString("message"),"Success");
	    Assert.assertTrue(jsonPath.getString("data.token")!=null);
	    
	
       
 //test
	}

}

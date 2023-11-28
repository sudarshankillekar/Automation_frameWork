package com.api.tests;

import com.api.pojo.*;
import com.util.Testutility;

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
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public final class SearchJobApiTest extends  ApiTestBase {
	
	JsonPath jsonPath;
	
	
	@Test(description = "verify login using api request and check message as Success")
	public void loginApiTest() throws IOException {
	 jsonPath =    given()
		.header(new Header("Content-Type", "application/json"))
		.body(new  SearchjobApirequest(jobId))
		.when()
		      .log().all()
		      .post("job/search")
		 .then()
		      .log().all()
		      .assertThat()
		      .statusCode(200)
	          .time(Matchers.lessThan(5000L))
	          .extract().jsonPath();
	    
	    Assert.assertEquals(jsonPath.getString("message"),"Success");
	    Assert.assertTrue(jsonPath.getString("data.token")!=null);
	    
	   
 
	}

}

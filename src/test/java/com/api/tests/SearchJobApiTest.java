package com.api.tests;

import com.api.pojo.*;
import com.util.DataUtils;
import com.util.ROLE;
import com.util.Testutility;

import static org.hamcrest.Matcher.*;

import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Time;

import org.hamcrest.Matchers;
import org.hamcrest.core.StringContains;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.util.Testutility.*;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Order(3)
public final class SearchJobApiTest extends  ApiTestBase {
	
	

	JsonPath jsonPath;
	String jobId = Testutility.getJobIdFromFile("data.txt");
	//String jobId ;
	//String jobId = DataUtils.getData("jobId", String.class);
	//String jobId = "JOB_30179";
	@Test(description = "verify login using api request and check message as Success")
	public void loginApiTest() throws IOException {
	 jsonPath =    given()
		.header(new Header("Content-Type", "application/json"))
		.header(new Header("Authorization", getAuthToken(ROLE.FD)))
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

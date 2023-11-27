package com.api.tests;

import static com.util.Testutility.*;
import static com.util.Testutility.getPropertFrom;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import java.io.IOException;

import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.hamcrest.Matchers.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.api.pojo.LoginApiPojo;
import com.util.ROLE;
import com.util.Testutility;

import static com.util.Testutility.*;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyExtractionOptions;
import io.restassured.response.ValidatableResponse;

public final class CreateJobApiRequest extends ApiTestBase  {
JsonPath jsonPath;
private static String jobId;		

	 @Test
	 public void Test_api_create_joB() {
		     given()
			.header(new Header("Content-Type", "application/json")).header(new Header("Authorization", getAuthToken(ROLE.FD)))
			.body(Testutility.getCreateJobBodyRequest())
			.when()
			.log().all()
				      .post("/job/create")
			.then()
						      .log().all()
						      .assertThat()
						      .statusCode(200)
						      .assertThat()
							     .statusCode(200)
							     .body("data.mst_service_location_id", equalTo(1))
							     .body("message", equalTo("Job created successfully. "))
							     .body("data.id", notNullValue()) 
							     .body("data.tr_customer_product_id", notNullValue()) 
							     .body("data.tr_customer_id", notNullValue());
		 
		                       
	 }

}

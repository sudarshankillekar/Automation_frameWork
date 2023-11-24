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
import com.util.Testutility;

import static com.util.Testutility.*;

import io.restassured.http.Header;
import io.restassured.response.Response;

public class CreateJobApiRequest {
	
	@BeforeMethod
	public void setup() throws IOException {
		baseURI = getPropertFrom("qa.properties","BASE_URL");
	}
	

	 @Test
	 public void Test_api_create_joB() {
		 Job_Id = 	 given()
			.header(new Header("Content-Type", "application/json")).header(new Header("Authorization", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6NCwiZmlyc3RfbmFtZSI6ImZkIiwibGFzdF9uYW1lIjoiZmQiLCJsb2dpbl9pZCI6ImlhbWZkIiwibW9iaWxlX251bWJlciI6Ijg4OTk3NzY2NTUiLCJlbWFpbF9pZCI6Im1hcmtAZ21haWwuY29tIiwicGFzc3dvcmQiOiI1ZjRkY2MzYjVhYTc2NWQ2MWQ4MzI3ZGViODgyY2Y5OSIsInJlc2V0X3Bhc3N3b3JkX2RhdGUiOm51bGwsImxvY2tfc3RhdHVzIjowLCJpc19hY3RpdmUiOjEsIm1zdF9yb2xlX2lkIjo1LCJtc3Rfc2VydmljZV9sb2NhdGlvbl9pZCI6MSwiY3JlYXRlZF9hdCI6IjIwMjEtMTEtMDNUMDg6MDY6MjMuMDAwWiIsIm1vZGlmaWVkX2F0IjoiMjAyMS0xMS0wM1QwODowNjoyMy4wMDBaIiwicm9sZV9uYW1lIjoiRnJvbnREZXNrIiwic2VydmljZV9sb2NhdGlvbiI6IlNlcnZpY2UgQ2VudGVyIEEiLCJpYXQiOjE3MDA2NzkzODV9.1hmpJFpO3Ao8GA5ns-jXb3ciK2dZeJKO6EUwnUAQWXo"))
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

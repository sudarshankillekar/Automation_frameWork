package com.api.tests;

import static com.util.Testutility.*;
import static com.util.Testutility.getPropertFrom;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import java.io.IOException;
import java.security.PublicKey;

import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.hamcrest.Matchers.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.pojo.CreateJobPojo;
import com.api.pojo.LoginApiPojo;
import com.db.pojo.CustomerDAO;
import com.db.pojo.TR_Customer_pojo;
import com.util.DataUtils;
import com.util.ROLE;
import com.util.Testutility;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;



import static com.util.Testutility.*;

import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

@Listeners(com.listeners.myListener.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Order(2)
public final class CreateJobApiRequest extends ApiTestBase  {
	
	private JsonPath jsonPath;
    private int customerId;
    public String name;
    private String first_name;
    private  TR_Customer_pojo tr_Customer_pojo;
	 @Test
	 public void Test_api_create_joB() {

				
				jsonPath  = given()
							.header(new Header("Content-Type", "application/json"))
							.header(new Header("Authorization", getAuthToken(ROLE.FD)))
							.body(convertPOJOToJSON(getCreateJobBodyRequest()))
						.when()
							.log().all()
							.post("/job/create")
						.then()
							.log().all()
							.assertThat()
							.statusCode(200)
							.and()
							.body("message", equalTo("Job created successfully. "))
							.body("data.id", notNullValue()) 
						    .body("data.tr_customer_product_id", notNullValue()) 
						    .body("data.tr_customer_id", notNullValue())
							.and()
						.extract().jsonPath();
				
				DataUtils.storeData("jobId", jsonPath.getString("data.job_number"));
				Testutility.jobId = jsonPath.getString("data.job_number");
				customerId = jsonPath.getInt("data.tr_customer_id");
				   try {
			            FileOutputStream fos = new FileOutputStream("data.txt");
			            fos.write(jobId.getBytes(StandardCharsets.UTF_8));
			            fos.close();
			        } catch (IOException e) {
			            e.printStackTrace();
			        }
			    
			//	name = jsonPath.getString("customer.first_name");
			//	tr_customer_product_id = jsonPath.getInt("data.tr_customer_product_id");
				System.out.println(jobId);
				System.out.println(customerId);
	
	}
	 
	 @Test(description = "Verify customer data entered correctly in db" , groups = { "e2e" , "smoke" ,"sanity"}  )
	private void test_if_data_entered_correctly_in_DB() {
		CustomerDAO customerDAO = new CustomerDAO() ;
		tr_Customer_pojo =  customerDAO.getcustomerrecordsfromtheDB(customerId);
		Assert.assertEquals(customerId, tr_Customer_pojo.getId());
	//	Assert.assertEquals(tr_Customer_pojo.getFirst_name(),name);
		//test
	}
	 }


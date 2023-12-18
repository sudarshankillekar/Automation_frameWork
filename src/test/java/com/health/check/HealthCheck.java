package com.health.check;

import static com.util.Testutility.convertPOJOToJSON;
import static com.util.Testutility.getPropertFrom;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import com.api.tests.ApiTestBase;
import com.db.dao.DBConnectivity;



public class HealthCheck  {
	public void test_db_connect() {
		Assert.assertEquals(DBConnectivity.getConnection(),null);
	}
//tes
//test		
}

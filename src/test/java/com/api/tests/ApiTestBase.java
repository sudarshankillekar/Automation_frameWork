package com.api.tests;

import static com.util.Testutility.getPropertFrom;
import static io.restassured.RestAssured.baseURI;

import java.io.IOException;

import org.testng.annotations.BeforeClass;


public abstract class ApiTestBase {
	@BeforeClass(description = "setting up the base URL for the API using config file")
	public void setup() throws IOException {
		baseURI = getPropertFrom("qa.properties","BASE_URL");
	}
}

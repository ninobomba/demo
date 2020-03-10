package com.demo;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@DisplayName("Complete Rest User lifecycle")
@SpringBootTest
public class UserCrudTest
{

	final static Logger log = LoggerFactory.getLogger( UserCrudTest.class );

	@BeforeAll
	public static void init()
	{
		RestAssured.baseURI = "http://127.0.0.1:8080";

	}

	@Test
	void create() throws JSONException
	{
		final JSONObject requestParams = new JSONObject();
		requestParams.put("name",  "francisco");
		requestParams.put("age",  18);
		requestParams.put("status",  "OK");

		final RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		request.body( requestParams.toString() );

		final Response response = request.post( "/user" );

		JUnitTestUtils.logResponse( response );

		response
		.then()
		.statusCode( HttpStatus.CREATED.value() );

	}

}

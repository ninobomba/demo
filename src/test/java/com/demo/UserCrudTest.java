package com.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Calendar;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class UserCrudTest
{

	final String id = "1";

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
		requestParams.put("creationDate", String.valueOf(new java.sql.Date(Calendar.getInstance().getTime().getTime())));

		final RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		request.body( requestParams.toString() );

		final Response response = request.post( "/user" );

		JUnitTestUtils.logResponse( response );

		response
		.then()
		.statusCode( HttpStatus.CREATED.value() );

		final JsonPath jsonPathEvaluator = response.jsonPath();
		final long id = jsonPathEvaluator.get( "resourceId" );
		assertThat( id ).isNotZero();
	}

	@Test
	void read() throws JSONException
	{
		log.info( "GET:" );
		log.info( "Get by ID: " + id  );

		final RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		final Response response = request.get( "/user/" + id );

		JUnitTestUtils.logResponse( response );

		final int statusCode = response.getStatusCode();

		assertThat( statusCode ).isEqualTo( HttpStatus.OK.value() );

	}

	@Test
	void update() throws JSONException
	{
		log.info( "PUT:" );

		final JSONObject requestParams = new JSONObject();

		requestParams.put("id",  id );
		requestParams.put("name",  "francisco romero");
		requestParams.put("age",  28);
		requestParams.put("status",  "Changed");
		requestParams.put("creationDate", String.valueOf(new java.sql.Date(Calendar.getInstance().getTime().getTime())));

		final RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		request.body( requestParams.toString() );

		final Response response = request.put( "/user/" + id );

		JUnitTestUtils.logResponse( response );

		final int statusCode = response.getStatusCode();

		assertThat( statusCode ).isEqualTo( HttpStatus.OK.value() );
	}


	@Test
	void delete() throws JSONException
	{
		log.info( "DELETE:" );

		final RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");

		final Response response = request.delete( "/user/" + id );

		JUnitTestUtils.logResponse( response );

		final int statusCode = response.getStatusCode();

		assertThat( statusCode ).isEqualTo( HttpStatus.OK.value() );
	}
}

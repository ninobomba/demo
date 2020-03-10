package com.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.restassured.response.Response;

public class JUnitTestUtils {

	final static Logger log = LoggerFactory.getLogger( JUnitTestUtils.class );

	public static void logResponse( Response response )
	{
		log.info( "Response:" );
		log.info( "Status:  " + response.getStatusCode() );
		log.info( "Time:    " + response.getTime() + " ms" );
		log.info( "Headers:\n" + response.headers() );
		log.info( "Body:   \n" + response.getBody().asString() );
	}

}

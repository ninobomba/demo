package com.demo.bootstrap;

import java.util.Calendar;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.demo.entities.LocalUser;
import com.demo.repositories.LocalUserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class AppBootstrap implements CommandLineRunner
{

	@Resource
	LocalUserRepository userRepository;

	@Override
	public void run(String... args) throws Exception
	{
		log.debug( "Application has started" );

		final LocalUser user = new LocalUser();

		user.setName( "Fernando" );
		user.setAge( 39 );
		user.setCreationDate( new java.sql.Date(Calendar.getInstance().getTime().getTime()) );

		userRepository.save(user);
	}

}

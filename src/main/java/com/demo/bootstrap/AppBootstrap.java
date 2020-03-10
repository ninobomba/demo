package com.demo.bootstrap;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.demo.entities.LocalUser;
import com.demo.repositories.LocalUserRepository;

@Configuration
public class AppBootstrap implements CommandLineRunner
{

	@Resource
	LocalUserRepository userRepository;

	@Override
	public void run(String... args) throws Exception
	{

		final LocalUser user = new LocalUser();

		user.setName( "Fernando" );
		user.setAge( 39 );

		userRepository.save(user);
	}

}

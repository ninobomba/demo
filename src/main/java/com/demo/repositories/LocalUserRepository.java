package com.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.demo.entities.LocalUser;

@RepositoryRestResource(path = "user")
public interface LocalUserRepository extends JpaRepository<LocalUser, Long>{

}

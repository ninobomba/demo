package com.demo.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Entity
public class LocalUser
{

	@Id
	@GeneratedValue
	Long id;

	@NotBlank
	String name;

	Integer age;

	Date creationDate;

	String status;

}

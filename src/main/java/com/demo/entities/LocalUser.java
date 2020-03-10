package com.demo.entities;

import java.sql.Timestamp;

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

	Timestamp creationDate;

	String status;

	public LocalUser()
	{
		if( creationDate == null ) {
			creationDate = new Timestamp(System.currentTimeMillis());
		}
	}
}

package com.management.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator="native")
	//@GenericGenerator(name = "native",strategy = "native")
	@Column(name = "id")
	private int id;
	
	@Column(name = "firstname")
	private String firstname;
	@Column(name = "lastname")
	private String lastname;
	@Column(name = "email")
	private String email;
	@Column(name = "age")
	private int age;
	
	public Student() {}
	
	public Student(int id, String fistname, String lastname, int age, String email) {
		super();
		this.id = id;
		this.firstname = fistname;
		this.lastname = lastname;
		this.age = age;
		this.email = email;
	}
	
	public Student(String fistname, String lastname, int age, String email) {
		super();
		this.firstname = fistname;
		this.lastname = lastname;
		this.age = age;
		this.email = email;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}

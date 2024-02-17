package com.management.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "subject")
public class Subject {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator="native")
	//@GenericGenerator(name = "native",strategy = "native")
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "nb_hours")
	private String nbHours;
	
	public Subject(int id, String name, String nbHours) {
		super();
		this.id = id;
		this.name = name;
		this.nbHours = nbHours;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNbHours() {
		return nbHours;
	}

	public void setNbHours(String nbHours) {
		this.nbHours = nbHours;
	}
	
	
}

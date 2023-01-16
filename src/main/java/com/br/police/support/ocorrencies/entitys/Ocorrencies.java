package com.br.police.support.ocorrencies.entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ocorrencies")
public class Ocorrencies {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	public long getId() {
		return this.id;
	}

	@Column(name = "name", nullable = false, length = 255)
	private String name;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "description", nullable = false, length = 255)
	private String description;

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "location", nullable = false, length = 255)
	private String location;

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "[name : " + this.name + ", description : " + this.description + ", location: " + this.location + "]";
	}

}

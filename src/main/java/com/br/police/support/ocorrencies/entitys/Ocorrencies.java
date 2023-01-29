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

	@Column(name = "description", nullable = false, length = 255)
	private String description;

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "latitude", nullable = false, length = 22)
	private String latitude;
	
	public String getLatitude() {
		return this.latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	@Column(name = "longitude", nullable = false, length = 22)
	private String longitude;

	public String getLongitude() {
		return this.longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "[description : " + this.description + ", latitude: " + this.latitude + ", longitude: "+ this.longitude +"]";
	}

}

package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "driver")
public class Driver {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int driver_id;
	
	@Column(name = "driver_name")
	private String driver_name;
	
	@Column(name = "driver_contact")
	private String driver_contact;
	
	@Column(name = "driver_gender")
	private String driver_gender;

	@Column(name = "driver_age")
	private int driver_age;
	
	@Column(name = "car_model")
	private String car_model;
	
	@Column(name = "car_number")
	private String car_number;
	
	@Column(name = "driver_available")
	private Boolean driver_available;
	
	@Column(name = "driver_earning")
	private double driver_earning;
	
	@Column(name = "driver_lat")
	private int driver_lat;
	
	@Column(name = "driver_long")
	private int driver_long;
	
	

	public Driver() {
		
	}

	public Driver(int driver_id, String driver_name, String driver_contact, String driver_gender, int driver_age,
			String car_model, String car_number, Boolean driver_available, double driver_earning,int driver_lat,int driver_long) {
		super();
		this.driver_id = driver_id;
		this.driver_name = driver_name;
		this.driver_contact = driver_contact;
		this.driver_gender = driver_gender;
		this.driver_age = driver_age;
		this.car_model = car_model;
		this.car_number = car_number;
		this.driver_available = driver_available;
		this.driver_earning = driver_earning;
		this.driver_lat = driver_lat;
		this.driver_long = driver_long;
		
	}


	public int getDriver_id() {
		return driver_id;
	}

	public void setDriver_id(int driver_id) {
		this.driver_id = driver_id;
	}

	public String getDriver_name() {
		return driver_name;
	}

	public void setDriver_name(String driver_name) {
		this.driver_name = driver_name;
	}

	public String getDriver_gender() {
		return driver_gender;
	}

	public void setDriver_gender(String driver_gender) {
		this.driver_gender = driver_gender;
	}

	public int getDriver_age() {
		return driver_age;
	}

	public void setDriver_age(int driver_age) {
		this.driver_age = driver_age;
	}

	public String getCar_model() {
		return car_model;
	}

	public void setCar_model(String car_model) {
		this.car_model = car_model;
	}

	public String getCar_number() {
		return car_number;
	}

	public void setCar_number(String car_number) {
		this.car_number = car_number;
	}

	public Boolean getDriver_available() {
		return driver_available;
	}

	public void setDriver_available(Boolean driver_available) {
		this.driver_available = driver_available;
	}

	public String getDriver_contact() {
		return driver_contact;
	}

	public void setDriver_contact(String driver_contact) {
		this.driver_contact = driver_contact;
	}

	public double getDriver_earning() {
		return driver_earning;
	}

	public void setDriver_earning(double driver_earning) {
		this.driver_earning = driver_earning;
	}

	public int getDriver_lat() {
		return driver_lat;
	}

	public void setDriver_lat(int driver_lat) {
		this.driver_lat = driver_lat;
	}

	public int getDriver_long() {
		return driver_long;
	}

	public void setDriver_long(int driver_long) {
		this.driver_long = driver_long;
	}
	
	
	
}

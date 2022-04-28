package com.example.demo.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int user_id;
	
	@Column(name = "user_name")
	private String user_name;
	
	@Column(name = "user_contact")
	private String user_contact;
	
	@Column(name = "user_gender")
	private String user_gender;

	@Column(name = "user_age")
	private int user_age;
	
	@Column(name = "user_lat")
	private int user_lat;
	
	@Column(name = "user_long")
	private int user_long;

	
	
	public User() {
		
	}



	public User(int user_id, String user_name, String user_contact, String user_gender, int user_age, int user_lat,
			int user_long) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_contact = user_contact;
		this.user_gender = user_gender;
		this.user_age = user_age;
		this.user_lat = user_lat;
		this.user_long = user_long;
	}



	public int getUser_id() {
		return user_id;
	}



	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}



	public String getUser_name() {
		return user_name;
	}



	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}



	public String getUser_contact() {
		return user_contact;
	}



	public void setUser_contact(String user_contact) {
		this.user_contact = user_contact;
	}



	public String getUser_gender() {
		return user_gender;
	}



	public void setUser_gender(String user_gender) {
		this.user_gender = user_gender;
	}



	public int getUser_age() {
		return user_age;
	}



	public void setUser_age(int user_age) {
		this.user_age = user_age;
	}



	public double getUser_lat() {
		return user_lat;
	}



	public void setUser_lat(int user_lat) {
		this.user_lat = user_lat;
	}



	public double getUser_long() {
		return user_long;
	}



	public void setUser_long(int user_long) {
		this.user_long = user_long;
	}
	
	
	
	
	
}

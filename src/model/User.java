package model;

import java.util.ArrayList;

public class User {

	private int id;
	private String username;
	private String password;
	private String email;
	private String firstname;
	private String lastname;
	private ArrayList<Advertisement> ads;
	private ArrayList<Auction> aucs;
	private ArrayList<Message> msges;
	private ArrayList<Auction> outbitAucs;

	public User(String username, String password, String firstname, String lastname, String email) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.ads=new ArrayList<>();
		this.aucs=new ArrayList<>();
		this.msges=new ArrayList<>();
	}
	
	
	public String getUsername() {
		return username;
	}


	public String getPassword() {
		return password;
	}


	public String getEmail() {
		return email;
	}


	public String getFirstname() {
		return firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return " [id=" + id + "]";
	}
	

	
	
}



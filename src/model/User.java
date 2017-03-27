package model;

import java.util.ArrayList;

public class User {

	private long id;
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
	
	
	public void deleteAdvertisement(Advertisement ad){
		if (ad!=null) {
			this.ads.remove(ad);
		}
	}
	

	public void createAuction(Advertisement ad){
		if (this.ads.contains(ad) && ad!=null) {
			Auction auc=new Auction(ad);
			this.aucs.add(auc);
			}
	}
	
	
	public void addOutbidAucs (Auction auc) {
		this.outbitAucs.add(auc);
	}
	
	public void makeOutbid(Auction auc, double money){
			this.addOutbidAucs(auc);
			Outbid outbid=new Outbid(this, money);
			auc.addOutbid(outbid);
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


	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return " [id=" + id + "]";
	}
	

	
	
}



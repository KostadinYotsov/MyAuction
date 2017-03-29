package model;


import java.time.LocalDate;
import java.time.LocalDateTime;

public class Advertisement {
	private int id;
	private String title;
	private String description;
	private int userId;
	private int categoryID;
	private LocalDateTime date;
	private double price;
	private String category;
	
	public Advertisement(String title, String description, String category, double price){
		this.title = title;
		this.description = description;
		this.category=category;
		this.price = price;
		this.date=date.now();
		
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public int getCategoryID(){
		return this.categoryID;
	}

	public double getPrice() {
		return this.price;
	}
	
	//date getter
	public LocalDateTime getDate() {
		return date;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	@Override
	public String toString() {
		return "Title: " + title + ", Description: " + description + ", Price: " + price + ", Category: "+ category;
	}

}

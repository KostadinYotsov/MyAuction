package model;


import java.time.LocalDate;
import java.time.LocalDateTime;

public class Advertisement {
	private long id;
	private String title;
	private String description;
	private long userId;
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
	
	public void setId(long id) {
		this.id = id;
	}
	
	public long getUserId() {
		return userId;
	}
	
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	
	@Override
	public String toString() {
		return "Title: " + title +'\n'+ "Description: " + description +'\n'+ "Price: " + price +'\n'+ "Category: "+ category;
	}
	
	
}

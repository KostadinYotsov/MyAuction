package model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Advertisement {
	private String title;
	private String description;
	private User owner;
	private Category category;
	private LocalDateTime date;
	private double price;
	
	public Advertisement(User owner, String title, String description, Category category, double price){
		this.title = title;
		this.description = description;
		this.category = category;
		this.price = price;
		this.owner=owner;
		this.date=date.now();
		
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public Category getCategory(){
		return this.category;
	}

	public double getPrice() {
		return this.price;
	}
	
	public User getOwner() {
		return owner;
	}
	
	public LocalDateTime getDate() {
		return date;
	}
	
	@Override
	public String toString() {
		return this.owner + " : "+ this.category + ":" + this.title;
	}
}

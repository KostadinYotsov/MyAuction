package model;


import java.time.LocalDate;
import java.time.LocalDateTime;

public class Advertisement {
	private String title;
	private String description;
	private long owner;
	private String category;
	private LocalDateTime date;
	private double price;
	
	public Advertisement(long userId, String title, String description, String category, double price){
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
	
	public String getCategory(){
		return this.category;
	}

	public double getPrice() {
		return this.price;
	}
	
	//date getter
	public LocalDateTime getDate() {
		return date;
	}
	
	@Override
	public String toString() {
		return this.owner + " : "+ this.category + ":" + this.title;
	}
}

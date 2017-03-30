package model;


import java.io.Serializable;
import java.time.LocalDateTime;

public class Advertisement implements Serializable {
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
		this.date=LocalDateTime.now();
		
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
	
	public String getCategory() {
		return category;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Advertisement other = (Advertisement) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Title: " + title +'\n'+ "Description: " + description +'\n'+ "Price: " + price +'\n'+ "Category: "+ category;
	}

}

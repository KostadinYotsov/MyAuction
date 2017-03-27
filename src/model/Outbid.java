package model;

public class Outbid {
	
	private User user;
	private double money;
	
	public Outbid(User user, double money) {
		this.user = user;
		this.money = money;
	}

	public double getMoney() {
		return money;
	}
	
	
}

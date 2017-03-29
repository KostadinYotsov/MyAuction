package model;

import java.util.Stack;

public class Auction {

	private static final double SELL_PRICE_MULTIPLIER = 0.9;
	private static final double CUR_PRICE_MULTIPLIER = 0.5;
	
	private int id;
	private Advertisement ad;
	private int advertisementId;
	private String advertisementTitle;
	private double startingPrice;//po-niska ot tazi na obqvata
	private double currentPrice;//promqna pri naddavne
	private double sellPrice;//cenata, za koqto potrebitelq direktno q poluchava
	

	
	//TODO
	public Auction(Advertisement ad) {
		this.ad = ad;
		this.startingPrice=ad.getPrice()*CUR_PRICE_MULTIPLIER;
		this.currentPrice=startingPrice;
		this.sellPrice=ad.getPrice()*SELL_PRICE_MULTIPLIER;
		this.advertisementId=ad.getId();
		this.advertisementTitle=ad.getTitle();
	}
	

	public double getCurrentPrice() {
		return currentPrice;
	}

	public double getSellPrice() {
		return this.sellPrice;
	}
	
	public double getStartingPrice() {
		return startingPrice;
	}
	
	public int getAdvertisementId() {
		return advertisementId;
	}


	public void setId(int id) {
		this.id=id;
	}
	
	
	@Override
	public String toString() {
		return "Title:" + advertisementTitle + ", StartingPrice: " + startingPrice
				+ ", CurrentPrice: " + currentPrice + ", SellPrice: " + sellPrice;
	}
}

package model;

import java.util.Stack;

public class Auction {
	private static final double SELL_PRICE_MULTIPLIER = 0.9;
	private static final double CUR_PRICE_MULTIPLIER = 0.5;
	private static final int TIME_CONST = 7;
	private Advertisement ad;
	private int time;//7 ot 10
	private double startingPrice;//po-niska ot tazi na obqvata
	private double currentPrice;//promqna pri naddavne
	private double sellPrice;//cenata, za koqto potrebitelq direktno q poluchava
	private Stack<Outbid> biddings;

	
	//TODO
	public Auction(Advertisement ad) {
		this.ad = ad;
		this.time=TIME_CONST;
		this.startingPrice=ad.getPrice()*CUR_PRICE_MULTIPLIER;
		this.startingPrice=currentPrice;
		this.sellPrice=ad.getPrice()*SELL_PRICE_MULTIPLIER;
	}
	
	
	public Advertisement getAdvertisement(){
		return this.ad;
	}


	public double getCurrentPrice() {
		return currentPrice;
	}

	public void addOutbid(Outbid o) {
		this.biddings.push(o);
		this.currentPrice=o.getMoney();
	}


	public double getSellPrice() {
		return this.sellPrice;
	}
}

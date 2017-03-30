package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Advertisement;
import model.Auction;

public class AuctionDAO {

	private static AuctionDAO instance;
	private static final ArrayList<Auction> allAuctions = new ArrayList<>();
	
	private AuctionDAO(){
	}
	
	public static synchronized AuctionDAO getInstance(){
		if(instance == null){
			instance = new AuctionDAO();
		}
		return instance;
	}

	public synchronized void addAuction (Auction a) throws SQLException{
		String sql = "INSERT INTO auctions (startPrice, currentPrice, sellPrice, advertisement_id) values (?, ?, ?, ?)";
		PreparedStatement st = DBManager.getInstance().getConnection().prepareStatement(sql);
		st.setDouble(1, a.getStartingPrice());
		st.setDouble(2, a.getCurrentPrice());
		st.setDouble(3, a.getSellPrice());
		st.setInt(4, a.getAdvertisementId());		
		st.executeUpdate();
		ResultSet res = st.getGeneratedKeys();
		res.next();
		int id = res.getInt(1);
		a.setId(id);
		allAuctions.add(a);
	}
	
	public synchronized ArrayList<Auction>  getAllAuctionsByUser (int userId) {
		ArrayList<Auction> aucs=new ArrayList<>();
		String sql="SELECT a.id, a.title, a.price, au.startPrice, au.currentPrice, au.sellPrice FROM advertisements a JOIN auctions au ON (au.advertisement_id=a.id) WHERE user_id=?";
		PreparedStatement st;
		try {
			st = DBManager.getInstance().getConnection().prepareStatement(sql);
			st.setInt(1, userId);
			ResultSet res = st.executeQuery();
			while (res.next()) {
				int advId=res.getInt("id");
				Advertisement adv=new Advertisement(res.getString("title"), null, null, res.getDouble("price"));
				adv.setId(advId);
				Auction a=new Auction(adv);
				aucs.add(a);
			}
		} catch (SQLException e) {
			System.out.println("SQL : " + e.getMessage());
		}
		return aucs;
	}
	
	public synchronized ArrayList<Auction>  getAllAuctions (int userId) {
		ArrayList<Auction> aucs=new ArrayList<>();
		String sql="SELECT a.id, a.title, a.price, au.startPrice, au.currentPrice, au.sellPrice FROM advertisements a JOIN auctions au ON (au.advertisement_id=a.id) WHERE user_id!=?";
		PreparedStatement st;
		try {
			st = DBManager.getInstance().getConnection().prepareStatement(sql);
			st.setInt(1, userId);
			ResultSet res = st.executeQuery();
			while (res.next()) {
				int advId=res.getInt("id");
				Advertisement adv=new Advertisement(res.getString("title"), null, null, res.getDouble("price"));
				adv.setId(advId);
				Auction a=new Auction(adv);
				aucs.add(a);
			}
		} catch (SQLException e) {
			System.out.println("SQL : " + e.getMessage());
		}
		return aucs;
	}
}

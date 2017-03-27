package model.dao;

import java.security.Timestamp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

import model.Advertisement;
import model.User;

public class AdvertisementDAO {

	private static AdvertisementDAO instance;
	private static final HashMap<User, ArrayList<Advertisement>> usersAvertisement = new HashMap<>();//user - > all advertisement
	
	private AdvertisementDAO(){
	}
	
	public static synchronized AdvertisementDAO getInstance(){
		if(instance == null){
			instance = new AdvertisementDAO();
		}
		return instance;
	}

	public synchronized void addAdvertisement (Advertisement a) throws SQLException{
		String sql = "INSERT INTO advertisements (title, description, date, price, Categories_id, Users_id) values (?, ?, ?, ?, ?,?)";
		PreparedStatement st = DBManager.getInstance().getConnection().prepareStatement(sql);
		st.setString(1, a.getTitle());
		st.setString(2, a.getDescription());
		st.setTimestamp(3, java.sql.Timestamp.valueOf(a.getDate()));
		st.setDouble(4, a.getPrice());
		//st.setString(5, u.getEmail());
		st.executeUpdate();
		ResultSet res = st.getGeneratedKeys();
		res.next();
		long id = res.getLong(1);
		//u.setId(id);
		//allUsers.put(u.getUsername(), u);
	}
	
	
}


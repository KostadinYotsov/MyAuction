package model.dao;

import java.security.Timestamp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.HashMap;

import model.Advertisement;
import model.User;

public class AdvertisementDAO {

	private static AdvertisementDAO instance;
	private static final HashMap<String, User> allUsers = new HashMap<>();//username - > user
	
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
		st.setString(2, a.getDescription());//TODO hash pass
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
	
	public HashMap<String, User> getAllUsers() throws SQLException{
		if(allUsers.isEmpty()){
			String sql = "SELECT username, password, firstname, lastname, email FROM users;";
			PreparedStatement st = DBManager.getInstance().getConnection().prepareStatement(sql);
			ResultSet res = st.executeQuery();
			while(res.next()){
				User u =new User(
				res.getString("username"), res.getString("password"), res.getString("firstname"), res.getString("lastname"), res.getString("email"));
				u.setId(res.getLong("id"));
				allUsers.put(u.getUsername(), u);
			}
		}
		return allUsers;
	}

	public synchronized boolean validLogin(String username, String password) throws SQLException {
		HashMap<String, User> allUsers=getAllUsers();
		if(allUsers.containsKey(username)){
			User u=allUsers.get(username);
			return u.getPassword().equals(password);
		}
		return false;
	}
}


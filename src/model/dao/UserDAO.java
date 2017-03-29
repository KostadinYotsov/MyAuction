package model.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import exceptions.UserAlreadyExistException;
import model.User;

public class UserDAO {

	private static UserDAO instance;
	private static final HashMap<String, User> allUsers = new HashMap<>();//username - > user
	
	private UserDAO(){
		try {
			getAllUsers();
		} catch (SQLException e) {
			System.out.println("SQL : " + e.getMessage());
		}
		
	}
	
	public static synchronized UserDAO getInstance(){
		if(instance == null){
			instance = new UserDAO();
		}
		return instance;
	}

	public synchronized void addUser(User u) throws SQLException, UserAlreadyExistException {
		if (allUsers.containsKey(u.getUsername())) {
			throw new UserAlreadyExistException();
		}
		String sql = "INSERT INTO users (username, password, firstname, lastname, email) values (?, ?, ?, ?, ?)";
		PreparedStatement st = DBManager.getInstance().getConnection().prepareStatement(sql);
		st.setString(1, u.getUsername());
		st.setString(2, u.getPassword());//TODO hash pass
		st.setString(3, u.getFirstname());
		st.setString(4, u.getLastname());
		st.setString(5, u.getEmail());
		st.executeUpdate();
		ResultSet res = st.getGeneratedKeys();
		res.next();
		int id = res.getInt(1);
		u.setId(id);
		allUsers.put(u.getUsername(), u);
	}
	
	private HashMap<String, User> getAllUsers() throws SQLException{
		if(allUsers.isEmpty()){
			String sql = "SELECT id, username, password, firstname, lastname, email FROM users;";
			PreparedStatement st = DBManager.getInstance().getConnection().prepareStatement(sql);
			ResultSet res = st.executeQuery();
			while(res.next()){
				User u =new User(
				res.getString("username"), res.getString("password"), res.getString("firstname"), res.getString("lastname"), res.getString("email"));
				int id=res.getInt("id");
				u.setId(id);
				allUsers.put(u.getUsername(), u);
				
			}
		}
		return allUsers;
	}

	
	public synchronized boolean validLogin(String username, String password) throws SQLException {
//		HashMap<String, User> allusers=UserDAO.getInstance().getAllUsers();
//		for (java.util.Map.Entry<String, User> e: allusers.entrySet()) {
//			System.out.println( e.getKey() + ": " + e.getValue());
//		}
		if (allUsers.containsKey(username)) {
			User u=allUsers.get(username);
			return u.getPassword().equals(password);
		}
		return false;
	}
	
	public int getUserId (String username) {
		if (allUsers.containsKey(username)) {
			User u=allUsers.get(username);
			int id=u.getId();
			return id;
		}
		return 0;
	}
	
	public User getUser (String username) {
		if (allUsers.containsKey(username)) {
			User u=allUsers.get(username);
			return u;			
		}
		return null;
	}
}

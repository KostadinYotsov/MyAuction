package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import model.Advertisement;
import model.User;

public class CategoryDAO {
	
	private static CategoryDAO instance;
	private static final HashMap<String, Integer> categories = new HashMap<>();
	
	private CategoryDAO(){
	}
	
	public static synchronized CategoryDAO getInstance(){
		if(instance == null){
			instance = new CategoryDAO();
		}
		return instance;
	}
	
	public void getCategories() throws SQLException{
		String sql ="SELECT id, type FROM categories";
		PreparedStatement st = DBManager.getInstance().getConnection().prepareStatement(sql);
		ResultSet res = st.executeQuery();
		while(res.next()){
			int id=res.getInt("id");
			String type=res.getString("type");
			this.categories.put(type, id);
		}
	}
	
	public int getCategoryId (String type) {
		if (categories.containsKey(type)) {
			return categories.get(type);
		}
		return 0;
	}
	
	

}

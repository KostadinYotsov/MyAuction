package model.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import model.Advertisement;


public class AdvertisementDAO {

	private static AdvertisementDAO instance;
	private static final ArrayList<Advertisement> allAvertisement = new ArrayList<>();//user - > all advertisement
	
	private AdvertisementDAO(){
	}
	
	public static synchronized AdvertisementDAO getInstance(){
		if(instance == null){
			instance = new AdvertisementDAO();
		}
		return instance;
	}

	public synchronized void addAdvertisement (Advertisement a) throws SQLException{
		String sql = "INSERT INTO advertisements (title, description, date, price, category_id, user_id) values (?, ?, ?, ?, ?,?)";
		PreparedStatement st = DBManager.getInstance().getConnection().prepareStatement(sql);
		st.setString(1, a.getTitle());
		st.setString(2, a.getDescription());
		st.setTimestamp(3, java.sql.Timestamp.valueOf(a.getDate()));
		st.setDouble(4, a.getPrice());
		st.executeUpdate();
		ResultSet res = st.getGeneratedKeys();
		res.next();
		long id = res.getLong(1);
		a.setId(id);
		allAvertisement.add(a);
	}
	
	public synchronized ArrayList<Advertisement>  getAllAdvertisementsByUser (int userId) {
		ArrayList<Advertisement> ads=new ArrayList<>();
		String sql="SELECT a.title, a.description, a.price, c.type FROM advertisements a JOIN categories c ON (a.categorie_id=c.id) WHERE user_id="+userId;
		PreparedStatement st;
		try {
			st = DBManager.getInstance().getConnection().prepareStatement(sql);
			ResultSet res = st.executeQuery();
			while (res.next()) {
				Advertisement a=new Advertisement(res.getString("title"), res.getString("description"), res.getString("category"), res.getDouble("price"));
				ads.add(a);
			}
		} catch (SQLException e) {
			System.out.println("SQL : " + e.getMessage());
		}
		return ads;
	}
}


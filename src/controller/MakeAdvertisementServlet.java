package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Advertisement;
import model.dao.AdvertisementDAO;
import model.dao.CategoryDAO;
import model.dao.UserDAO;

@WebServlet("/advertisement")
public class MakeAdvertisementServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String username = (String) session.getAttribute("USER");
		String title = req.getParameter("title");
		String description = req.getParameter("description");
		String  priceText = req.getParameter("price");
		String category = req.getParameter("category");
		long userId=UserDAO.getInstance().getUserId(username);
		int categoryId=CategoryDAO.getInstance().getCategoryId(category);
		double price=Double.parseDouble(priceText);
		
		//make validation
		
		Advertisement a=new Advertisement(userId, title, description, category, price);
		try {
			AdvertisementDAO.getInstance().addAdvertisement(a);
		} catch (SQLException e) {
			System.out.println("");
		}
		
	}

}

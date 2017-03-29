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
import model.Auction;
import model.dao.AdvertisementDAO;
import model.dao.AuctionDAO;
import model.dao.CategoryDAO;
import model.dao.UserDAO;

@WebServlet("/makeAdvertisement")
public class MakeAuction extends HttpServlet{

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Boolean logged = (Boolean) req.getSession().getAttribute("logged");
		if (logged==null || logged==false) {
			resp.sendRedirect("index.html");
		}
		String username = (String) session.getAttribute("username");
		String title = req.getParameter("title");
		Advertisement adv=AdvertisementDAO.getInstance().getAdvertisement(username, title);
		boolean validData = false;
		
	    if (title != null && !title.trim().isEmpty() && adv!=null) {
				validData=true;
		}
		
	    String filename="makeAuctionFailed.html";
		
		if (validData) {
			filename="profile.jsp";
			Auction a=new Auction(adv);
			try {
				AuctionDAO.getInstance().addAuction(a);
			} catch (SQLException e) {
				filename="makeAuctionFailed.html";
				System.out.println("SQL "+e.getMessage());
			}
		}
		resp.sendRedirect(filename);
	}
}

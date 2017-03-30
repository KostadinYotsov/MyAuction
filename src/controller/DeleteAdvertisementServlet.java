package controller;

import java.io.IOException;
import java.util.HashSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Advertisement;
import model.dao.AdvertisementDAO;
import model.dao.AuctionDAO;


@WebServlet("/deleteAdvertisement")
public class DeleteAdvertisementServlet extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Boolean logged = (Boolean) req.getSession().getAttribute("logged");
		if (logged==null || logged==false) {
			resp.sendRedirect("login.html");
		}
		int id=Integer.parseInt(req.getParameter("id"));
		boolean validData = false;
		if (id>0) {
			validData=true;
		}
		String filename="deleteAdvertismentFailed.html";
		if (validData) {
			filename="profile.jsp";
			if (AuctionDAO.getInstance().hasAuction(id)) {
				AuctionDAO.getInstance().deleteAuctionByAdvertismentId(id);
			}
			AdvertisementDAO.getInstance().deleteAdvertisement(id);
		}
		resp.sendRedirect(filename);
	}

}

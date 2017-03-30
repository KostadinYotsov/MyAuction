package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Advertisement;
import model.dao.AdvertisementDAO;

@WebServlet("/addToCart")
public class AddToCartServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Boolean logged = (Boolean) req.getSession().getAttribute("logged");
		if (logged==null || logged==false) {
			resp.sendRedirect("login.html");
		}
		String title = req.getParameter("title");
		Advertisement a=AdvertisementDAO.getInstance().getAdvertisementByTitle(title);
		HashSet advertisements = (HashSet) session.getAttribute("advertisements");
		advertisements.add(a);
		resp.sendRedirect("advertisements.jsp");		
	}
}

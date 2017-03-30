package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/BuyAdvertisementServlet")
public class BuyAdvertisementServlet extends HttpServlet {
	
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
		String filename="makeAdvertismentFailed.html";
		if (validData) {
			filename="cart.jsp";
			
		}
	}

}

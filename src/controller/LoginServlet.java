package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Advertisement;
import model.dao.UserDAO;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		boolean validData = true;
		   if (username == null || username.trim().isEmpty() || password == null ||password.trim().isEmpty()) {
				validData=false;
			}
		String fileName=null;
		if (validData) {
			try {
				if(UserDAO.getInstance().validLogin(username, password)){
					HttpSession session=req.getSession();
					session.setAttribute("username", username);
					session.setAttribute("logged", true);
					session.setAttribute("advertisements", new HashSet<Advertisement>());
					fileName = "main.html";
					
				}
				else{
					fileName = "loginFailed.html";
				}
			} catch (SQLException e) {
				System.out.println("Error loging in - " + e.getMessage());
				fileName = "loginFailed.html";
				
			}
		}
		
		RequestDispatcher rd = req.getRequestDispatcher(fileName);
		rd.forward(req, resp);
	}
}


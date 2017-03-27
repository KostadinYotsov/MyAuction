package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exceptions.UserAlreadyExistException;
import model.User;
import model.dao.UserDAO;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String  password2 = req.getParameter("password2");
		String firstname = req.getParameter("firstname");
		String lastname = req.getParameter("lastname");
		String email = req.getParameter("email");
		System.out.println(username + password +password2+firstname+lastname+email);
		String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&*+=])(?=\\S+$).{8,}";
	    String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
		
	    boolean validData = false;
		
	    if (username != null && !username.trim().isEmpty() && password != null && !password.trim().isEmpty() &&
			firstname != null && !firstname.trim().isEmpty() && lastname != null && !lastname.trim().isEmpty() &&
			email != null && !email.trim().isEmpty() && email.matches(ePattern) 
			&& password.matches(pattern) && password.equals(password2)) {
				validData=true;
		}
		
	    String filename="registerFailed.html";
		
		if(validData){
			filename = "login.html";
			User u = new User(username, password, firstname, lastname, email);
			try {
				UserDAO.getInstance().addUser(u);
			} 
			catch (SQLException e) {
				System.out.println("SQL : " +e.getMessage());
				filename="registerFailed.html";
			}
			catch (UserAlreadyExistException e) {
				System.out.println("SQL : " +e.getMessage());
				filename="registerFailed.html";
			}
		}
		RequestDispatcher rd = req.getRequestDispatcher(filename);
		rd.forward(req, resp);
	}
}

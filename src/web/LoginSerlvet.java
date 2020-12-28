package web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Product;
import domain.ProductService;
import domain.User;
import domain.UserService;
import util.Status;

@WebServlet("/LoginSerlvet")
public class LoginSerlvet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher view = null;
		UserService UserService = null;
		ProductService ProductService = null;
		Status status = new Status();
		request.setAttribute("status", status);
		String userType = request.getParameter("userType");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		if (userType.equals("unknown")) {
			status.addException(new Exception("Please select a login type"));
		}
		if ((userName == null) || (userName.length() == 0)) {
			status.addException(new Exception("Please enter your username"));
		}
		if ((password == null) || (password.length() == 0)) {
			status.addException(new Exception("Please enter your password"));
		}
		User user = null;
		ArrayList<Product> products = null;
		try {
			UserService = new UserService();
			user = UserService.getUser(userType, userName, password);
			ProductService = new ProductService();
			products = ProductService.getAllProduct();
			if (user == null) {
				status.addException(new Exception("Please enter your user information in the right way"));
			}
			if (products == null) {
				status.addException(new Exception("The product database error"));
			}

			if (!status.isSuccessful()) {
				view = request.getRequestDispatcher("main.jsp");
				view.forward(request, response);
				return;
			}
			request.setAttribute("user", user);
			request.setAttribute("products", products);
		} catch (Exception e) {
			status.addException(e);
			view = request.getRequestDispatcher("main.jsp");
			view.forward(request, response);
		}
		if (userType.equals("A")) {
			view = request.getRequestDispatcher("admin/login.jsp");
			view.forward(request, response);
		}
		if (userType.equals("C")) {
			view = request.getRequestDispatcher("login.jsp");
			view.forward(request, response);
		}
	}
}

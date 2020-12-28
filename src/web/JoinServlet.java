package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.UserService;
import util.Status;

@WebServlet("/JoinServlet")
public class JoinServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		RequestDispatcher view = null;
		UserService UserService = null;
		Status status = new Status();
		request.setAttribute("status", status);

		try {
			String userName = request.getParameter("userName");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			String contact = request.getParameter("contact");
			String address = request.getParameter("address");

			if ((userName == null) || (userName.length() == 0)) {
				status.addException(new Exception("Please enter your username"));
			}
			if ((password == null) || (password.length() == 0)) {
				status.addException(new Exception("Please enter your password"));
			}
			if ((email == null) || (email.length() == 0)) {
				status.addException(new Exception("Please enter your email"));
			}
			if ((contact == null) || (contact.length() == 0)) {
				status.addException(new Exception("Please enter your contact"));
			}
			if ((address == null) || (address.length() == 0)) {
				status.addException(new Exception("Please enter your address"));
			}

			try {

				UserService = new UserService();
				UserService.userCreate("C", userName, password, email, contact, address);

				if (!status.isSuccessful()) {
					view = request.getRequestDispatcher("join.jsp");
					view.include(request, response);
					return;
				}

				view = request.getRequestDispatcher("joinconfirm.jsp");
				view.include(request, response);

			} catch (Exception e) {
				status.addException(e);
				view = request.getRequestDispatcher("join.jsp");
				view.include(request, response);
			}
		} catch (IllegalArgumentException e) {
			status.addException(e);
			view = request.getRequestDispatcher("join.jsp");
			view.include(request, response);
		}
	}

}

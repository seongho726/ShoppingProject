package web;

import java.io.IOException;
import java.sql.Date;

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
		RequestDispatcher view = null;
		UserService UserService = null;
		Status status = new Status();
		request.setAttribute("status", status);

		try {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			Date birthdate = java.sql.Date.valueOf(request.getParameter("birthdate"));
			String gender = request.getParameter("gender");
			String email = request.getParameter("email");
			String contact = request.getParameter("contact");
			String address = request.getParameter("address");

			if ((username == null) || (username.length() == 0)) {
				status.addException(new Exception("Please enter your username"));
			}
			if ((password == null) || (password.length() == 0)) {
				status.addException(new Exception("Please enter your password"));
			}
			if ((birthdate == null) || (password.length() == 0)) {
				status.addException(new Exception("Please enter your birthdate"));
			}
			if ((gender == null) || (gender.length() == 0) || !(gender.equals("Man") || gender.equals("Woman"))) {
				status.addException(new Exception("Please check your gender input"));
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
				UserService.userCreate("C", username, password, email, contact, address);

				if (!status.isSuccessful()) {
					view = request.getRequestDispatcher("join.jsp");
					view.forward(request, response);
					return;
				}

				view = request.getRequestDispatcher("joinconfirm.jsp");
				view.forward(request, response);

			} catch (Exception e) {
				status.addException(e);
				view = request.getRequestDispatcher("join.jsp");
				view.forward(request, response);
			}
		} catch (IllegalArgumentException e) {
			status.addException(e);
			view = request.getRequestDispatcher("join.jsp");
			view.forward(request, response);
		}
	}

}

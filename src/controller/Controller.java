package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Service;
import model.domain.User;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	public static Service instance = Service.getInstance();

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String command = request.getParameter("command");
		HttpSession session = request.getSession();
		try {
			if (command.equals("getUsers")) {
				getUsers(request, response);
			} else if (command.equals("getUser")) {
				getUser(request, response);
			} else if (command.equals("addUser")) {
				addUser(request, response);
			}
		} catch (Exception s) {
			request.getSession().setAttribute("errorMsg", s.getMessage());
			request.getRequestDispatcher("showError.jsp").forward(request, response);
			s.printStackTrace();
		}
	}

	public void getUsers(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			request.getSession().setAttribute("getUsers", Service.getUsers());
			request.getSession().setAttribute("successMsg", "모든 회원 검색");
			url = "userList.jsp";
		} catch (Exception e) {
			request.setAttribute("errorMsg", e.getMessage());
			e.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	public void getUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		int userId;
		try {
			userId = Integer.valueOf((String) request.getSession().getAttribute("userId"));

			request.setAttribute("getUser", Service.getUser(userId));
			url = "userDetail.jsp";
		} catch (Exception e) {
			request.setAttribute("errorMsg", e.getMessage());
			e.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	public void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User(request.getParameter("userName"), request.getParameter("password"),
				request.getParameter("email"), request.getParameter("contact"), request.getParameter("address"));
		String url = "showError.jsp";
		try {
			Service.getInstance();
			boolean result = Service.addUser(user.getUserName(), user.getPassword(), user.getEmail(), user.getContact(),
					user.getAddress());
			request.getSession().setAttribute("user", user);
			if (result = true) {
				url = "joinconfirm.jsp";
			} else {
				request.setAttribute("error", "가입 실패");
			}
		} catch (Exception e) {
			request.getSession().setAttribute("error", "입력 실패");
			e.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}

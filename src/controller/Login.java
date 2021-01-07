package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LoginDAO;
import model.Service;
import model.domain.User;

@WebServlet("/Login")
public class Login extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String t = request.getParameter("userType").trim().replaceAll("\\\"", "");
		String i = request.getParameter("userId").trim().replaceAll("\\\"", "");
		String p = request.getParameter("password").trim().replaceAll("\\\"", "");

		HttpSession session = request.getSession(false);
		if (session != null)
			session.setAttribute("userId", i);
		try {
			if (LoginDAO.validate(t, i, p)) {
				if (t.equals("C")) {
					User user = Service.validate(t, i, p);
					session.setAttribute("user", user);
					RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
					rd.forward(request, response);
				}
				if (t.equals("A")) {
					RequestDispatcher rd = request.getRequestDispatcher("admin/login.jsp");
					rd.forward(request, response);
				}
			} else {
				out.print("<p style=\"color:red\">Sorry username or password error</p>");
				RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
				rd.include(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		out.close();
	}

}

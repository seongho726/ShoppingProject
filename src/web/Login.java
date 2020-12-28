package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.LoginDAO;
import domain.User;
import domain.UserService;


@WebServlet("/Login")
public class Login extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("utf-8"); 
			response.setContentType("text/html");  
	        PrintWriter out = response.getWriter();  
	        
	        String t = request.getParameter("userType").trim().replaceAll("\\\"","");  
	        String n = request.getParameter("userName").trim().replaceAll("\\\"","");  
	        String p = request.getParameter("password").trim().replaceAll("\\\"",""); 
	        
	        HttpSession session = request.getSession(false);
	        if(session!=null)
	        session.setAttribute("name", n);
	        try {
				if(LoginDAO.validate(t, n, p)){
					if (t.equals("C")) {
					User user = UserService.getUserservice().getUser(t, n, p);
						session.setAttribute("user", user);
						RequestDispatcher rd=request.getRequestDispatcher("login.jsp"); 
					    rd.forward(request,response); }
					if (t.equals("A")) {
				RequestDispatcher rd=request.getRequestDispatcher("admin/login.jsp"); 
			    rd.forward(request,response);
				} } 
				else{  
				    out.print("<p style=\"color:red\">Sorry username or password error</p>");  
				    RequestDispatcher rd=request.getRequestDispatcher("main.jsp");  
				    rd.include(request,response);  
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}  

	        out.close();  
	    }  
	
	
	}

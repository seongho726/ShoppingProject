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

@WebServlet("/LoginSerlvet")
public class LoginServlet extends HttpServlet{

    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  

        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
        
        String n=request.getParameter("userName");  
        String p=request.getParameter("password"); 
        String t=request.getParameter("userType");
        HttpSession session = request.getSession(false);
        
        try {
			if(LoginDAO.validate(n, p, t)){  
			    RequestDispatcher rd=request.getRequestDispatcher("login.jsp");  
			    rd.forward(request,response);  
			}  
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

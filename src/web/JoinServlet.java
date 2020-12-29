package web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import domain.UserService;

@WebServlet("/JoinServlet")
public class JoinServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String command = request.getParameter("command");
		if(command.equals("insert")){  
			insert(request, response);
		}
	}	
	
	public void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User(request.getParameter("username").trim(), 
							request.getParameter("password").trim(),
							request.getParameter("email").trim(),
							request.getParameter("contact").trim(),
							request.getParameter("address").trim());
				
		String url = "joinfailure.jsp";	
			try {		
				boolean result = UserService.getUserService().userCreate(user.getUserName(), user.getPassword(),
									user.getEmail(), user.getContact(), user.getAddress());
					request.getSession().setAttribute("user", user);
					if(result = true) {
						url = "joinconfirm.jsp";
					}
					else {
						request.setAttribute("error","가입 실패");
						
					}
				} catch (SQLException e) {		
					request.getSession().setAttribute("error", "입력 실패");
					e.printStackTrace();
				}
				request.getRequestDispatcher(url).forward(request, response);
			}	
	}



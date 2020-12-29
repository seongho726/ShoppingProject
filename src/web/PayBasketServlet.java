package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Payment;
import domain.PaymentService;

/**
 * Servlet implementation class PayBasketServlet
 */
@WebServlet("/PayBasketServlet")
public class PayBasketServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); 
		response.setContentType("text/html");  
		String command = request.getParameter("command");

		if(command.equals("insert")){  
			insert(request, response);
		}
	}	
	
	public void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Payment payment = new Payment (Integer.parseInt(request.getParameter("userId").trim()), 
							request.getParameter("address").trim(),
							request.getParameter("contact").trim(),
							request.getParameter("ccNumber").trim(),
							request.getParameter("ccExpiration").trim(),
							request.getParameter("ccPassword").trim());
				
		String url = null;	
			try {		
				boolean result = PaymentService.getPaymentService().paymentCreate(payment.getUserId(), payment.getAddress(), payment.getContact(),
						payment.getCcNumber(), payment.getCcExpiration(), payment.getCcPassword());
					request.getSession().setAttribute("payment", payment);
					if(result = true) {
						url = "joinconfirm.jsp";
				        PrintWriter out = response.getWriter();  
						out.print("성공");
					}
					else {
						request.setAttribute("error","주문 실패");
						
					}
				} catch (SQLException e) {		
					request.getSession().setAttribute("error", "입력 실패");
					e.printStackTrace();
				}
				request.getRequestDispatcher(url).forward(request, response);
			}	
	}


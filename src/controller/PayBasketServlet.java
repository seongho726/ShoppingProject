package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Payment;
import model.PaymentService;

/**
 * Servlet implementation class PayBasketServlet
 */
@WebServlet("/PayBasketServlet")
public class PayBasketServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		HttpSession HttpSession = request.getSession();

		int userId = Integer.parseInt(request.getParameter("userId"));

		Payment payment = new Payment(userId, request.getParameter("address").trim(),
				request.getParameter("contact").trim(), request.getParameter("ccNumber").trim(),
				request.getParameter("ccExpiration").trim(), request.getParameter("ccPassword").trim());

		String url = "payfail.jsp";

		try {
			boolean result = PaymentService.getPaymentService().paymentCreate(userId, payment.getAddress(),
					payment.getContact(), payment.getCcNumber(), payment.getCcExpiration(), payment.getCcPassword());
			request.getSession().setAttribute("payment", payment);
			if (result = true) {
				url = "pay.jsp";

			} else {
				request.setAttribute("error", "주문 실패");

			}
		} catch (SQLException e) {
			request.getSession().setAttribute("error", "입력 실패");
			e.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}

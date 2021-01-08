package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Service;
import model.domain.Basket;
import model.domain.Calculate;
import model.domain.User;

@WebServlet("/BuyBasketServlet")
public class BuyBasketServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher view = null;
		Service BasketService = null;

		HttpSession session = request.getSession();
		String userId = ((User) session.getAttribute("user")).getUserId();

		List<Basket> baskets = null;
		baskets = Service.getBasket(userId);

		Calculate calculate = null;
		calculate = Service.calculateBasket(userId);

		request.setAttribute("user", session.getAttribute("user"));
		request.setAttribute("baskets", baskets);
		request.setAttribute("calculate", calculate);
		view = request.getRequestDispatcher("checkout.jsp");
		view.forward(request, response);
	}
}

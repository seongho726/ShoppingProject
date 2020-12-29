package web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Calculate;
import domain.Basket;
import domain.BasketService;
import domain.User;

@WebServlet("/RetrieveBasketServlet")
public class RetrieveBasketServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher view = null;
		BasketService BasketService = null;

		HttpSession session = request.getSession();
		int userId = ((User) session.getAttribute("user")).getUserId();

		ArrayList<Basket> baskets = null;
		BasketService = new BasketService();
		baskets = BasketService.getBasket(userId);

		request.setAttribute("user", session.getAttribute("user"));
		request.setAttribute("baskets", baskets);
		view = request.getRequestDispatcher("basket.jsp");
		view.forward(request, response);
	}
}
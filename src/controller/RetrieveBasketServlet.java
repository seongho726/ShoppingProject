package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Service;
import model.domain.Basket;
import model.domain.User;

@WebServlet("/RetrieveBasketServlet")
public class getBasket extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher view = null;
		Service BasketService = null;

		HttpSession session = request.getSession();
		String userId = ((User) session.getAttribute("user")).getUserId();

		ArrayList<Basket> baskets = null;
		BasketService = new Service();
		try {
			baskets = (ArrayList<Basket>) Service.getBasket(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("user", session.getAttribute("user"));
		request.setAttribute("baskets", baskets);
		view = request.getRequestDispatcher("basket.jsp");
		view.forward(request, response);
	}
}
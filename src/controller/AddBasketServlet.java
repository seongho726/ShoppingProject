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

import model.BasketService;
import model.ProductService;
import model.Service;
import model.domain.Product;
import util.Status;

@WebServlet("/AddBasketServlet")
public class AddBasketServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher view = null;
		Service BasketService = new BasketService();
		Service ProductService = new ProductService();
		Status status = new Status();
		request.setAttribute("status", status);
		HttpSession HttpSession = request.getSession();

		String userId = request.getParameter("userId");
		int productId = Integer.parseInt(request.getParameter("productId"));
		int productCount = Integer.parseInt(request.getParameter("productCount"));

		if ((request.getParameter("productCount") == null)) {
			status.addException(new Exception("Please enter product count."));
		}
		if ((productCount == 0)) {
			status.addException(new Exception("Please enter product count."));
		}

		ArrayList<Product> products = null;
		ProductService = new ProductService();
		products = ProductService.getAllProduct();

		request.setAttribute("products", products);
		request.setAttribute("user", HttpSession.getAttribute("user"));

		try {

			BasketService = new BasketService();
			BasketService.addBasket(userId, productId, productCount);

			if (!status.isSuccessful()) {
				view = request.getRequestDispatcher("login.jsp");
				view.forward(request, response);
				return;
			}

			view = request.getRequestDispatcher("login.jsp");
			view.forward(request, response);

		} catch (Exception e) {
			status.addException(e);
			view = request.getRequestDispatcher("login.jsp");
			view.forward(request, response);
		}

	}

}
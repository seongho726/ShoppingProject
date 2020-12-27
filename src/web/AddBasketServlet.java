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

import domain.BasketService;
import domain.Product;
import domain.ProductService;
import util.Status;

@WebServlet("/AddBasketServlet")
public class AddBasketServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher view = null;
		BasketService BasketService = new BasketService();
		ProductService ProductService = new ProductService();
		Status status = new Status();
		request.setAttribute("status", status);
		HttpSession HttpSession = request.getSession();

		int userid = Integer.parseInt(request.getParameter("userid"));
		int productid = Integer.parseInt(request.getParameter("productid"));
		int numbers = Integer.parseInt(request.getParameter("numbers"));

		if ((request.getParameter("numbers") == null)) {
			status.addException(new Exception("Please enter product numbers"));
		}
		if ((numbers == 0)) {
			status.addException(new Exception("Please enter product numbers"));
		}

		ArrayList<Product> products = null;
		ProductService = new ProductService();
		products = ProductService.getAllProduct();

		request.setAttribute("products", products);
		request.setAttribute("user", HttpSession.getAttribute("user"));

		try {

			BasketService = new BasketService();
			BasketService.addBasket(userid, productid, numbers);

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

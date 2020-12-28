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

import domain.Product;
import domain.ProductService;

@WebServlet("/SearchProductServlet")
public class SearchProductServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 RequestDispatcher view = null;
	        ProductService ProductService = null;
	        String productName = request.getParameter("productName");
	        HttpSession HttpSession = request.getSession();
	       
	        ArrayList<Product> products = null;
	        ProductService = new ProductService();
	        products = ProductService.getProduct(productName);
	        request.setAttribute("products", products);
	        request.setAttribute("user", HttpSession.getAttribute("user"));
	       
	        view = request.getRequestDispatcher("login.jsp");
	        view.forward(request, response);
	    }
	}
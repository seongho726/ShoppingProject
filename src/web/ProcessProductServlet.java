package web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Product;
import domain.ProductService;
import domain.UserService;

@WebServlet("/createprocess")
public class ProcessProductServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String command = request.getParameter("command");
		if (command.equals("insertProduct")) {
			productInsert(request, response);
		}
	}

	public void productInsert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Product product = new Product(request.getParameter("producttype").trim(),
				request.getParameter("productname").trim(), request.getParameter("description").trim(),
				Integer.parseInt(request.getParameter("price")), Integer.parseInt(request.getParameter("inventory")));
		String url = "admin/createfailure.jsp";
		try {
			boolean result = ProductService.getProdService().insertProduct(product.getProductType(),
					product.getProductName(), product.getDescription(), product.getPrice(), product.getInventory());
			request.getSession().setAttribute("product", product);
			if (result = true) {
				url = "admin/login.jsp";
			} else {
				request.setAttribute("error", "생성 실패");

			}
		} catch (SQLException e) {
			request.getSession().setAttribute("error", "입력 실패");
			e.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
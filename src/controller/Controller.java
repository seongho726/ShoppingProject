package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LoginDAO;
import model.Service;
import model.domain.Basket;
import model.domain.Product;
import model.domain.User;
import util.Status;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	public static Service instance = Service.getInstance();

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String command = request.getParameter("command");
		HttpSession session = request.getSession();
		try {
			if (command.equals("getUsers")) {
				getUsers(request, response);
			} else if (command.equals("getUser")) {
				getUser(request, response);
			} else if (command.equals("addUser")) {
				addUser(request, response);
			} else if (command.equals("addProduct")) {
				addProduct(request, response);
			} else if (command.equals("updateProduct")) {
				updateProduct(request, response);
			} else if (command.equals("updateProductReq")) {
				updateProductReq(request, response);
			} else if (command.equals("deleteProduct")) {
				deleteProduct(request, response);
			} else if (command.equals("validate")) {
				validate(request, response);
			} else if (command.equals("getBasket")) {
				getBasket(request, response);
			} else if (command.equals("addBasket")) {
				addBasket(request, response);
			} else {
				System.out.println("showError.jsp");
			}
		} catch (Exception s) {
			request.getSession().setAttribute("errorMsg", s.getMessage());
			request.getRequestDispatcher("showError.jsp").forward(request, response);
			s.printStackTrace();
		}
	}

	public void getUsers(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			request.getSession().setAttribute("getUsers", Service.getUsers());
			request.getSession().setAttribute("successMsg", "모든 회원 검색");
			url = "userList.jsp";
		} catch (Exception e) {
			request.setAttribute("errorMsg", e.getMessage());
			e.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	public void getUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		String userId;
		try {
			userId = (String) request.getSession().getAttribute("userId");

			request.getSession().setAttribute("getUser", Service.getUser(userId));
			url = "userDetail.jsp";
		} catch (Exception e) {
			request.setAttribute("errorMsg", e.getMessage());
			e.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	public void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User(request.getParameter("userId"), request.getParameter("userName"),
				request.getParameter("password"), request.getParameter("email"), request.getParameter("contact"),
				request.getParameter("address"));
		String url = "showError.jsp";
		try {
			Service.getInstance();
			boolean result = Service.addUser(user.getUserId(), user.getUserName(), user.getPassword(), user.getEmail(),
					user.getContact(), user.getAddress());
			request.getSession().setAttribute("user", user);
			if (result = true) {
				url = "joinconfirm.jsp";
			} else {
				request.setAttribute("error", "가입 실패");
			}
		} catch (Exception e) {
			request.getSession().setAttribute("error", "입력 실패");
			e.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

//	public void addProductReq(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		String url = "showError.jsp";
//		try {
//			url = "admin/create.jsp";
//		} catch (Exception s) {
//			request.getSession().setAttribute("errorMsg", s.getMessage());
//			s.printStackTrace();
//		}
//		request.getRequestDispatcher(url).forward(request, response);
//	}

	public void addProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Product product = new Product(request.getParameter("producttype").trim(),
				request.getParameter("productname").trim(), request.getParameter("description").trim(),
				Integer.parseInt(request.getParameter("price")), Integer.parseInt(request.getParameter("inventory")));
		String url = "showError.jsp";
		try {
			Service.getInstance();
			boolean result = Service.addProduct(product.getProductType(), product.getProductName(),
					product.getDescription(), product.getPrice(), product.getInventory());
			request.getSession().setAttribute("product", product);
			if (result = true) {
				url = "admin/login.jsp";
			} else {
				request.setAttribute("error", "생성 실패");
			}
		} catch (Exception e) {
			request.getSession().setAttribute("error", "입력 실패");
			e.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	public void updateProductReq(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			request.getSession().setAttribute("product",
					Service.getProduct(Integer.parseInt(request.getParameter("productId"))));
			url = "admin/update.jsp";
		} catch (Exception s) {
			request.getSession().setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	public void updateProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		int productId = Integer.parseInt(request.getParameter("productId"));
		String description = request.getParameter("description");
		int price = Integer.parseInt(request.getParameter("price"));
		int inventory = Integer.parseInt(request.getParameter("inventory"));
		try {
			Service.updateProduct(productId, description, price, inventory);
			request.getSession().setAttribute("product",
					Service.getProduct(Integer.parseInt(request.getParameter("productId"))));
			request.getSession().setAttribute("successMsg", productId + "제품수정");
			url = "admin/login.jsp";
		} catch (Exception e) {
			request.getSession().setAttribute("errMsg", e.getMessage());
			e.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	public void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "showError.jsp";
		int productId = Integer.parseInt(request.getParameter("productId"));
		try {
			Service.deleteProduct(Integer.parseInt(request.getParameter("productId")));
			request.getSession().setAttribute("productDelete", Service.deleteProduct(productId));
			url = "admin/login.jsp";
		} catch (Exception e) {
			request.getSession().setAttribute("errMSg", e.getMessage());
			e.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	public void validate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		String t = request.getParameter("userType").trim().replaceAll("\\\"", "");
		String i = request.getParameter("userId").trim().replaceAll("\\\"", "");
		String p = request.getParameter("password").trim().replaceAll("\\\"", "");

		HttpSession session = request.getSession(false);
		if (session != null)
			session.setAttribute("userId", i);
		try {
			if (LoginDAO.validate(t, i, p)) {
				if (t.equals("C")) {
					RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
					rd.forward(request, response);
				}
				if (t.equals("A")) {
					RequestDispatcher rd = request.getRequestDispatcher("admin/login.jsp");
					rd.forward(request, response);
				}
			} else {
				out.print("<p style=\"color:red\">Sorry username or password error</p>");
				RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
				rd.include(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		out.close();
	}
	
	public void getBasket(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
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
	
	public void addBasket(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "showError.jsp";
		RequestDispatcher view = null;
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
		List<Product> products = null;
		products = Service.getProducts();
		request.setAttribute("products", products);
		request.setAttribute("user", HttpSession.getAttribute("user"));
		try {
			instance = new Service();
			Service.addBasket(userId, productId, productCount);
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
	public void deleteBasket(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "showError.jsp";
		RequestDispatcher view = null;
        HttpSession HttpSession = request.getSession();

        int basketId = Integer.parseInt(request.getParameter("basketId"));
        String userId = request.getParameter("userId");

        List<Basket> baskets = null;
        try {
			Service.deleteBasket(userId, basketId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
        baskets = Service.getBasket(userId);

        request.setAttribute("baskets", baskets);
        request.setAttribute("user", HttpSession.getAttribute("user"));

        view = request.getRequestDispatcher("basket.jsp");
        view.forward(request, response);
    }
}
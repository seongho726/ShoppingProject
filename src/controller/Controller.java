package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BasketDAO;
import model.LoginDAO;
import model.Service;
import model.domain.Basket;
import model.domain.Calculate;
import model.domain.Payment;
import model.domain.Product;
import model.domain.User;

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
			} else if (command.equals("buyBasket")) {
				buyBasket(request, response);
			} else if (command.equals("payBasket")) {
				payBasket(request, response);
			} else if (command.equals("deleteBasket")) {
				deleteBasket(request, response);
			} else if (command.equals("deleteAjaxBasket")) {
				deleteAjaxBasket(request, response);
			} else if (command.equals("getPayment")) {
				getPayment(request, response);
			} else {
				System.out.println("showError.jsp");
			}
		} catch (Exception s) {
			request.getSession().setAttribute("error", s.getMessage());
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
			request.setAttribute("error", e.getMessage());
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
			request.setAttribute("error", e.getMessage());
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
//			request.getSession().setAttribute("error", s.getMessage());
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
				url = "login.jsp";
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
			url = "update.jsp";
		} catch (Exception s) {
			request.getSession().setAttribute("error", s.getMessage());
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
			url = "login.jsp";
		} catch (Exception e) {
			request.getSession().setAttribute("error", e.getMessage());
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
			url = "login.jsp";
		} catch (Exception e) {
			request.getSession().setAttribute("error", e.getMessage());
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
					RequestDispatcher rd = request.getRequestDispatcher("shop.jsp");
					rd.forward(request, response);
				}
				if (t.equals("A")) {
					RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
					rd.forward(request, response);
				}
			} else {
				out.print("<p style=\"color:red\">Sorry username or password error</p>");
				RequestDispatcher rd = request.getRequestDispatcher("login-register.jsp");
				rd.include(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		out.close();
	}

	public void getBasket(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId");
		ArrayList<Basket> baskets = null;
		try {
			baskets = (ArrayList<Basket>) Service.getBasket(userId);
			HashMap prices =new HashMap();
			for (Basket basket : baskets) {
				prices.put(basket.getProductId(), Service.getProduct(basket.getProductId()).getPrice());
			}
			session.setAttribute("prices", prices);
			session.setAttribute("baskets", baskets);
			url = "cart.jsp";
		} catch (Exception e) {
			request.getSession().setAttribute("error", e.getMessage());
			e.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	public void addBasket(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "showError.jsp";
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId");
		int productId = Integer.parseInt(request.getParameter("productId"));
		int productCount = Integer.parseInt(request.getParameter("productCount"));
		try {
			boolean result = Service.addBasket(userId, productId, productCount);
			if (result) {
				url = "shop.jsp";
			} else {
				request.getSession().setAttribute("error", "추가실패");
			}
		} catch (Exception e) {
			request.getSession().setAttribute("error", e.getMessage());
			e.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	public void deleteBasket(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "showError.jsp";
		HttpSession session = request.getSession();
		int basketId = Integer.parseInt(request.getParameter("basketId"));
		String userId = (String) session.getAttribute("userId");
		
		try {
			boolean result = Service.deleteBasket(userId, basketId);
			if (result) {
				session.setAttribute("baskets", Service.getBasket(userId));
				url = "cart.jsp";
			} else {
				request.getSession().setAttribute("error", "삭제실패");
			}
		} catch (Exception e) {
			request.getSession().setAttribute("error", e.getMessage());
			e.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	public void deleteAjaxBasket(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "showError.jsp";
		HttpSession session = request.getSession();
		int basketId = Integer.parseInt(request.getParameter("basketId"));
		String userId = (String) session.getAttribute("userId");
		
		try {
			boolean result = Service.deleteBasket(userId, basketId);
			if (result) {
				session.setAttribute("baskets", Service.getBasket(userId));
				url = "cart.jsp";
			} else {
				request.getSession().setAttribute("error", "삭제실패");
			}
		} catch (Exception e) {
			request.getSession().setAttribute("error", e.getMessage());
			e.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	public void buyBasket(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "showError.jsp";
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId");
		
		ArrayList<Basket> baskets = null;

		baskets = (ArrayList<Basket>) Service.getBasket(userId);
		session.setAttribute("baskets", baskets);

		Calculate calculate = null;
		calculate = Service.calculateBasket(userId);
		session.setAttribute("calculate", calculate);

		request.getRequestDispatcher("checkout.jsp").forward(request, response);

	}

	public void payBasket(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "payfail.jsp";
		HttpSession session = request.getSession();

		String userId = (String) session.getAttribute("userId");
		
		String address = request.getParameter("address").trim();
		String contact = request.getParameter("contact").trim();
		String ccNumber = request.getParameter("ccNumber").trim();
		String ccExpiration = request.getParameter("ccExpiration").trim();
		String ccPassword = request.getParameter("ccPassword").trim();
		
		try {
			boolean result = Service.addPayment(userId, address, contact, ccNumber, ccExpiration, ccPassword);
			if (result = true) {
				url = "pay.jsp";
				BasketDAO.cleanBasket(userId);
				session.setAttribute("baskets", Service.getBasket(userId));
			} else {
				request.setAttribute("error", "주문 실패");
			}
		} catch (SQLException e) {
			request.getSession().setAttribute("error", "입력 실패");
			e.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	public void getPayment(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "showError.jsp";
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId");
		ArrayList<Payment> payments = null;
		try {
			payments = (ArrayList<Payment>) Service.getPayment(userId);
			session.setAttribute("payments", payments);
			
			url = "orderHistory.jsp";
		} catch (Exception e) {
			request.getSession().setAttribute("error", e.getMessage());
			e.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}

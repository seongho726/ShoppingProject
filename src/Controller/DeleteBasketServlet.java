package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Basket;
import model.BasketService;

@WebServlet("/DeleteBasketServlet")
public class DeleteBasketServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = null;
        BasketService BasketService = new BasketService();
        HttpSession HttpSession = request.getSession();

        int basketId = Integer.parseInt(request.getParameter("basketId"));
        int userId = Integer.parseInt(request.getParameter("userId"));

        ArrayList<Basket> baskets = null;
        try {
			BasketService.deleteBasket(userId, basketId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
        baskets = BasketService.getBasket(userId);

        request.setAttribute("baskets", baskets);
        request.setAttribute("user", HttpSession.getAttribute("user"));

        view = request.getRequestDispatcher("basket.jsp");
        view.forward(request, response);
    }
}
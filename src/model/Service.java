package model;

import java.util.List;

import model.domain.Basket;
import model.domain.Calculate;
import model.domain.Payment;
import model.domain.Product;
import model.domain.User;

public class Service {
	private static Service instance = new Service();

	public static Service getInstance() {
		return instance;
	}

	// 1. User - CRUD
	// 검색
	public static List<User> getUsers() throws Exception {
		return UserDAO.getUsers();
	}

	// 특정 검색
	public static User getUser(int userId) throws Exception {
		return UserDAO.getUser(userId);
	}

	// 추가
	public static boolean addUser(String userName, String password, String email, String contact, String address)
			throws Exception {
		return UserDAO.addUser(userName, password, email, contact, address);
	}

	// 수정
	public static boolean updateUser(int userId, String address, String contact, String email) throws Exception {
		return UserDAO.updateUser(userId, address, contact, email);
	}

	// 삭제
	public static boolean deleteUser(int userId) throws Exception {
		return UserDAO.deleteUser(userId);
	}

	// 2. Product - CRUD
	// 검색
	public static List<Product> getProducts() throws Exception {
		return ProductDAO.getProducts();
	}

	// 특정 검색
	public static Product getProduct(int ProductId) throws Exception {
		return ProductDAO.getProduct(ProductId);
	}

	// 추가
	public static boolean addProduct(String productType, String productName, String description, int price,
			String inventory) throws Exception {
		return ProductDAO.addProduct(productType, productName, description, price, inventory);
	}

	// 수정
	public static boolean updateProduct(int productId, String description, int price, String inventory)
			throws Exception {
		return ProductDAO.updateProduct(productId, description, price, inventory);
	}

	// 삭제
	public static boolean deleteProduct(int productId) throws Exception {
		return ProductDAO.deleteProduct(productId);
	}

	// 3. Basket - CRUD
	// 검색
	public static List<Basket> getBasket(int userId) throws Exception {
		return BasketDAO.getBasket(userId);
	}
	
	// 가격 계산
	public static Calculate calculateBasket(int userId) throws Exception{
		return BasketDAO.calculateBasket(userId);
	}
	
	// 추가
	public static boolean addBasket(int userId, int productId, int productCount) throws Exception{
		return BasketDAO.addbasket(userId, productId, productCount);
	}
	
	public static boolean deleteBasket(int userId, int basketId) throws Exception {
		return BasketDAO.deleteBasket(userId, basketId);
	}
	
	public static boolean cleanBasket(int userId) throws Exception {
		return BasketDAO.cleanBasket(userId);
	}
	
	// 4. Payment
	// 검색
	public static List<Payment> getPayment(int userId) throws Exception {
		return PaymentDAO.getPayement(userId);
	}
	
	public static boolean addPayment(int userId, String address, String contact, String ccNumber, String ccExpiration,
			String ccPassword) throws Exception {
		return PaymentDAO.addPayment(userId, address, contact, ccNumber, ccExpiration, ccPassword);
	}
}

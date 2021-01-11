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
	public static User getUser(String userId) throws Exception {
		return UserDAO.getUser(userId);
	}
	
	// validate
	public static User validate(String userType, String userId, String password) throws Exception {
		return UserDAO.validate(userType, userId, password);
	}
	
	// 추가
	public static boolean addUser(String userId, String userName, String password, String email, String contact, String address)
			throws Exception {
		return UserDAO.addUser(userId, userName, password, email, contact, address);
	}

	// 수정
	public static boolean updateUser(String userId, String address, String contact, String email) throws Exception {
		return UserDAO.updateUser(userId, address, contact, email);
	}

	// 삭제
	public static boolean deleteUser(String userId) throws Exception {
		return UserDAO.deleteUser(userId);
	}

	// 2. Product - CRUD
	// 검색
	public static List<Product> getProducts() throws Exception {
		return ProductDAO.getProducts();
	}

	// 특정 검색
	public static Product getProduct(int productId) throws Exception {
		return ProductDAO.getProduct(productId);
	}

	// 추가
	public static boolean addProduct(String productType, String productName, String description, int price,
			int inventory) throws Exception {
		return ProductDAO.addProduct(productType, productName, description, price, inventory);
	}

	// 수정
	public static boolean updateProduct(int productId, String description, int price, int inventory)
			throws Exception {
		return ProductDAO.updateProduct(productId, description, price, inventory);
	}

	// 삭제
	public static boolean deleteProduct(int productId) throws Exception {
		return ProductDAO.deleteProduct(productId);
	}

	// 3. Basket - CRUD
	// 검색
	public static List<Basket> getBasket(String userId) throws Exception {
		return BasketDAO.getBasket(userId);
	}
	
	// 가격 계산
	public static Calculate calculateBasket(String userId) throws Exception{
		return BasketDAO.calculateBasket(userId);
	}
	
	// 추가
	public static boolean addBasket(String userId, int productId, int productCount) throws Exception{
		return BasketDAO.addbasket(userId, productId, productCount);
	}
	
	public static boolean deleteBasket(String userId, int basketId) throws Exception {
		return BasketDAO.deleteBasket(userId, basketId);
	}
	
	public static boolean cleanBasket(String userId) throws Exception {
		return BasketDAO.cleanBasket(userId);
	}
	
	// 4. Payment
	// 검색
	public static List<Payment> getPayment(String userId) throws Exception {
		return PaymentDAO.getPayment(userId);
	}
	
	public static boolean addPayment(String userId, String address, String contact, String ccNumber, String ccExpiration,
			String ccPassword) throws Exception {
		return PaymentDAO.addPayment(userId, address, contact, ccNumber, ccExpiration, ccPassword);
	}
}

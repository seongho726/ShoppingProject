package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.domain.Basket;
import model.domain.Calculate;
import util.DBUtil;
import util.PublicCommon;

public class BasketDAO {
	// "SELECT * FROM shoppingbasket where basketuser_id = ? and validity = 1"
	public static Basket getBasket(int userId) throws Exception {
		EntityManager em = PublicCommon.getEntityManager();
		try {
			return (Basket) em
					.createNativeQuery("SELECT * FROM shoppingbasket where basketuser_id = ? and validity = 1",
							Basket.class)
					.setParameter(1, userId).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			em.close();
		}
	}

	public static Calculate calculateBasket(int userId) throws SQLException {
		Calculate calculate = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(
					"SELECT SUM( shoppingbasket.product_count* shoppingproduct.price), SUM(shoppingbasket.product_count)\r\n"
							+ "FROM shoppingbasket\r\n"
							+ "LEFT JOIN shoppingproduct on shoppingbasket.product_id = shoppingproduct.product_id\r\n"
							+ "WHERE basketuser_id = ? AND validity = 1\r\n" + "GROUP BY basketuser_id");
			pstmt.setInt(1, userId);

			rset = pstmt.executeQuery();
			while (rset.next()) {
				int totalBasketPrice = rset.getInt(1);
				int totalProductCount = rset.getInt(2);
				calculate = new Calculate(totalBasketPrice, totalProductCount);
			}

		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return calculate;

	}

	// 장바구니 추가
	public static boolean addbasket(int userId, int productId, int productCount) throws Exception {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			em.createNativeQuery("INSERT INTO shoppingbasket VALUES(shoppingproduct_id_seq.nextval,?,?,?,?,1)")
					.setParameter(1, userId).setParameter(2, productId).setParameter(3, productCount).executeUpdate();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			em.close();
		}
		return true;
	}

	// 장바구니 삭제
	public static boolean deleteBasket(int userId, int basketId) throws Exception {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			em.createNativeQuery("UPDATE shoppingbasket SET validity = 2 WHERE basketuser_id = ? AND basket_id = ?")
					.setParameter(1, userId).setParameter(2, basketId).executeUpdate();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			em.close();
		}
		return true;
	}

	public static boolean cleanBasket(int userId) throws Exception {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			em.createNativeQuery("UPDATE shoppingbasket SET validity = 2 WHERE basketuser_id = ?")
					.setParameter(1, userId).executeUpdate();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			em.close();
		}
		return true;
	}
}
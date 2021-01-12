package model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.domain.Product;
import util.PublicCommon;

public class ProductDAO {
	// 물품추가
	public static boolean addProduct(String productType, String productName, String description, int price,
			int inventory) throws Exception {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			em.createNativeQuery("INSERT INTO shoppingproduct VALUES (shoppingproduct_id_seq.nextval,?,?,?,?,?)")
					.setParameter(1, productType).setParameter(2, productName).setParameter(3, description)
					.setParameter(4, price).setParameter(5, inventory).executeUpdate();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			throw e;
		} finally {
			em.close();
		}
		return true;
	}

	// 물품 업데이트
	public static boolean updateProduct(int productId, String description, int price, int inventory)
			throws Exception {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			em.createNativeQuery("update shoppingproduct set description=?, price=?, inventory=? where product_id=?")
					.setParameter(1, description).setParameter(2, price).setParameter(3, inventory)
					.setParameter(4, productId).executeUpdate();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			throw e;
		} finally {
			em.close();
		}
		return true;
	}

	// id로 물품 삭제
	public static boolean deleteProduct(int productId) throws Exception {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			em.createNativeQuery("delete from shoppingproduct where product_id=?").setParameter(1, productId).executeUpdate();
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			throw e;
		} finally {
			em.close();
		}
	}

	// 전체 물품 검색
	public static List<Product> getProducts() throws Exception {
		EntityManager em = PublicCommon.getEntityManager();
		try {
			return em.createNativeQuery("select * from shoppingproduct order by product_id asc" , Product.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			em.close();
		}
	}

	// id로 물품검색
	public static Product getProduct(int productId) throws Exception {
		EntityManager em = PublicCommon.getEntityManager();
		try {
			return em.find(Product.class, productId);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			em.close();
		}
	}

}
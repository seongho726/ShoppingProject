/* CREATE TABLE activist (
       activist_id          VARCHAR2(20)  PRIMARY KEY,
       name                 VARCHAR2(20) NULL,
       password             VARCHAR2(20) NULL,
       major                VARCHAR2(50) NULL
);  */
package model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.domain.User;
import util.PublicCommon;

public class UserDAO {
	// 유저 추가
	public static boolean addUser(String userName, String password, String email, String contact, String address)
			throws Exception {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			em.createNativeQuery("INSERT INTO shoppinguser VALUES (shoppinguser_id_seq.nextval,'C',?,?,?,?,?)")
					.setParameter(1, userName).setParameter(2, password).setParameter(3, email).setParameter(4, contact)
					.setParameter(5, address).executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			em.close();
		}
		return true;
	}

	// 유저 업데이트
	public static boolean updateUser(int userId, String address, String contact, String email) throws Exception {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			em.createNativeQuery("update shoppinguser set address=?, contact=?, email=? where shoppinguser_id=?")
					.setParameter(1, address).setParameter(2, contact).setParameter(3, email).setParameter(4, userId)
					.executeUpdate();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			em.close();
		}
		return true;
	}

	// id로 유저 삭제
	public static boolean deleteUser(int userId) throws Exception {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			User u = em.find(User.class, userId);
			em.remove(u);
			tx.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			em.close();
		}
	}

	// 전체 유저 검색
	public static List<User> getUsers() throws Exception {
		EntityManager em = PublicCommon.getEntityManager();
		try {
			return em.createNativeQuery("select * from shoppinguser", User.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			em.close();
		}
	}

	// id로 유저검색
	public static User getUser(int userId) throws Exception {
		EntityManager em = PublicCommon.getEntityManager();
		try {
			return em.find(User.class, userId);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			em.close();
		}
	}
}

package model;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import util.PublicCommon;

public class LoginDAO {
	public static boolean validate(String userType, String userId, String password) throws Exception {
			EntityManager em = PublicCommon.getEntityManager();
			  boolean status = false;
			try {
				em.createNativeQuery(
						"SELECT * FROM shoppinguser where usertype = ? and shoppinguser_id = ? and password = ?")
						.setParameter(1, userType).setParameter(2, userId).setParameter(3, password).getSingleResult();
				status = true;
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			} finally {
				em.close();
			}
			return status;
		}
	
	
	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
}

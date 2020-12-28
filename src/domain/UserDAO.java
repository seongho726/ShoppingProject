/* CREATE TABLE activist (
       activist_id          VARCHAR2(20)  PRIMARY KEY,
       name                 VARCHAR2(20) NULL,
       password             VARCHAR2(20) NULL,
       major                VARCHAR2(50) NULL
);  */
package domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import util.DBUtil;
import util.PublicCommon;

public class UserDAO {

	public static boolean addUser(User user) throws Exception {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			em.persist(user);
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

	// id로 해당 기부자의 모든 정보 반환
	public static User getUser(String userid) throws Exception {
		EntityManager em = PublicCommon.getEntityManager();
		try {
			return em.find(User.class, userid);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			em.close();
		}
	}

//	// 모든 기부자 검색해서 반환
//	public static List<User> getAllActivists() throws Exception {
//		EntityManager em = PublicCommon.getEntityManager();
//		try {
//			return em.createNativeQuery("select * from shoppinguser", User.class).getResultList();
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw e;
//		} finally {
//			em.close();
//		}
//	}
	
    private static final String RETRIEVE_STMT
            = "SELECT * FROM shoppinguser WHERE usertype=? AND username=? AND Password =?";
    private static final String GETID_STMT = "SELECT COUNT(userID) FROM shoppinguser";
    private static final String CREATE_STMT = "INSERT INTO shoppinguser VALUES(?,?,?,?,?,?,?)";

    User userRetrieve(String usertype, String username, String password) throws SQLException {
        User user = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        int rows = 0;
        try {
            conn = DBUtil.getConnection();
            stmt = conn.prepareStatement(RETRIEVE_STMT);
            stmt.setString(1, usertype);
            stmt.setString(2, username);
            stmt.setString(3, password);
            rset = stmt.executeQuery();
            while (rset.next()) {
                int UserID = rset.getInt("UserID");
                String UserType = rset.getString("UserType");
                String UserName = rset.getString("UserName");
                String Password = rset.getString("Password");
                String Email = rset.getString("Email");
                String Contact = rset.getString("Contact");
                String Address = rset.getString("Address");
                rows++;
                if (rows > 1) {
                    throw new SQLException("Too many rows were returned.");
                }
                user = new User(UserID, UserType, UserName, Password, Email, Contact, Address);
            }
            return user;
        } catch (SQLException se) {
            throw new RuntimeException(
                    "A database error occurred. " + se.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Exception: " + e.getMessage());
        } finally {
            if (rset != null) {
                try {
                    rset.close();
                } catch (SQLException se) {
                    se.printStackTrace(System.err);
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException se) {
                    se.printStackTrace(System.err);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace(System.err);
                }
            }
        }
    }

    void userCreate(String usertype, String username, String password, String email, String contact, String address) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        try {
            conn = DBUtil.getConnection();
            stmt = conn.prepareStatement(GETID_STMT);
            rset = stmt.executeQuery();
            int ID = -1;
            rset.next();
            ID = rset.getInt("COUNT(UserID)");
            ID++;
            stmt = conn.prepareStatement(CREATE_STMT);
            stmt.setInt(1, ID);
            stmt.setString(2, usertype);
            stmt.setString(3, username);
            stmt.setString(4, password);
            stmt.setString(5, email);
            stmt.setString(6, contact);
            stmt.setString(7, address);
            stmt.executeQuery();
        } catch (SQLException se) {
            throw new RuntimeException(
                    "A database error occurred. " + se.getMessage());
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException se) {
                    se.printStackTrace(System.err);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace(System.err);
                }
            }
        }
    }
}

package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.persistence.EntityManager;

import model.domain.Payment;
import util.DBUtil;
import util.PublicCommon;

public class PaymentDAO {
// id로 payment 검색
//	"SELECT * FROM shoppingpayment WHERE paymentuser_id=?"
	public static List<Payment> getPayment(String userId) throws Exception {
		EntityManager em = PublicCommon.getEntityManager();
		try {
			return em.createNativeQuery(
					"SELECT * FROM shoppingpayment WHERE paymentuser_id = ? order by payment_id", Payment.class).setParameter(1, userId)
					.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			em.close();
		}
	}

	public static boolean addPayment(String userId, String address, String contact, String ccNumber, String ccExpiration,
			String ccPassword) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		boolean result = false;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(
					"SELECT SUM( shoppingbasket.product_count* shoppingproduct.price), SUM(shoppingbasket.product_count)\r\n"
							+ "FROM shoppingbasket\r\n"
							+ "LEFT JOIN shoppingproduct on shoppingbasket.product_id = shoppingproduct.product_id\r\n"
							+ "WHERE basketuser_id = ? AND validity = 1\r\n" + "GROUP BY basketuser_id");
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();

			int totalBasketPrice = -1;
			int totalProductCount = -1;
			while (rset.next()) {
				totalBasketPrice = rset.getInt(1);
				totalProductCount = rset.getInt(2);
			}

			pstmt = con.prepareStatement("INSERT INTO shoppingpayment VALUES(payment_id_seq.nextval,?,?,?,?,?,?,?,?)");

			pstmt.setString(1, userId);
			pstmt.setInt(2, totalProductCount);
			pstmt.setInt(3, totalBasketPrice);
			pstmt.setString(4, address);
			pstmt.setString(5, contact);
			pstmt.setString(6, ccNumber);
			pstmt.setString(7, ccExpiration);
			pstmt.setString(8, ccPassword);
			pstmt.executeUpdate();
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(con, pstmt);
		}
		return result;

	}
}

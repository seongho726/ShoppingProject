package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.domain.Payment;
import util.DBUtil;

public class PaymentDAO {

	ArrayList<Payment> paymentRetrieve(int userId) throws SQLException {
		ArrayList<Payment> payments = new ArrayList<Payment>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("SELECT * FROM shoppingpayment WHERE paymentuser_id=?");
			pstmt.setObject(1, userId);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				payments.add(new Payment());

			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return payments;
	}

	public static boolean paymentAdd(int userId, String address, String contact, String ccNumber, String ccExpiration,
			String ccPassword) throws SQLException {
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
			pstmt.setInt(1, userId);
			rset = pstmt.executeQuery();

			int totalBasketPrice = -1;
			int totalProductCount = -1;
			while (rset.next()) {
				totalBasketPrice = rset.getInt(1);
				totalProductCount = rset.getInt(2);
			}

			pstmt = con.prepareStatement("INSERT INTO shoppingpayment VALUES(payment_id_seq.nextval,?,?,?,?,?,?,?,?)");

			pstmt.setInt(1, userId);
			pstmt.setInt(2, totalBasketPrice);
			pstmt.setInt(3, totalProductCount);
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

package domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DBUtil;

public class PaymentDAO {

	ArrayList<Payment> paymentRetrieve(User userId) throws SQLException {
		ArrayList<Payment> payments = new ArrayList<Payment>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("SELECT * FROM shoppingpayment WHERE paymentuser_id=?");
			pstmt.setObject(1, userId.getUserId());
			rset = pstmt.executeQuery();
			while (rset.next()) {
				payments.add(new Payment(rset.getInt(1), (User) rset.getObject(2), (Product) rset.getObject(3),
						rset.getString(4), rset.getString(5), rset.getString(6), rset.getString(7), rset.getString(8)));

			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return payments;
	}

}

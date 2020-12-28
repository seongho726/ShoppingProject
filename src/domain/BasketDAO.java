package domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DBUtil;

public class BasketDAO {

	ArrayList<Basket> basketRetrieve(int userId) throws SQLException {
		ArrayList<Basket> baskets = new ArrayList<Basket>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("SELECT * FROM shoppingbasket where userId = ? and validity = 1");
			pstmt.setInt(1, userId);

			rset = pstmt.executeQuery();
			while (rset.next()) {
				baskets.add(new Basket(rset.getInt(1), rset.getInt(2), (Product) rset.getObject(3),
						rset.getInt(4), rset.getInt(5)));
			}

		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return baskets;

	}

	void basketAdd(int userId, int productId, int productCount) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("SELECT COUNT(basketId) FROM shoppingbasket");
			rset = pstmt.executeQuery();

			int basketId = -1;
			rset.next();
			basketId = rset.getInt("COUNT(basketId)");
			basketId++;

			pstmt = con.prepareStatement("INSERT INTO shoppingbasket VALUES(?,?,?,?,1)");
			pstmt.setInt(1, basketId);
			pstmt.setInt(2, userId);
			pstmt.setInt(3, productId);
			pstmt.setInt(4, productCount);
			pstmt.executeQuery();
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
	}

	void basketDelete(int userId, int basketId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("UPDATE shoppingbasket SET validity = 2 WHERE userId = ? AND basketId = ?");
			pstmt.setInt(1, userId);
			pstmt.setInt(2, basketId);
			pstmt.executeQuery();
		} finally {
			DBUtil.close(con, pstmt);
		}
	}

	void basketClean(int userId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("UPDATE shoppingbasket SET Validity = 2 WHERE UserID = ?");
			pstmt.setInt(1, userId);
			pstmt.executeQuery();
		} finally {
			DBUtil.close(con, pstmt);
		}
	}
}
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
			pstmt = con.prepareStatement("SELECT * FROM shoppingbasket where basketuser_id = ? and validity = 1");
			pstmt.setInt(1, userId);

			rset = pstmt.executeQuery();
			while (rset.next()) {
				baskets.add(new Basket(rset.getInt(1), rset.getInt(2), rset.getInt(3), rset.getInt(4), rset.getInt(5)));
			}

		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return baskets;

	}
	
	
	public Calculate calculateBasket(int userId) throws SQLException {
		Calculate calculate = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("SELECT SUM( shoppingbasket.product_count* shoppingproduct.price), SUM(shoppingbasket.product_count)\r\n" + 
					"FROM shoppingbasket\r\n" + 
					"LEFT JOIN shoppingproduct on shoppingbasket.product_id = shoppingproduct.product_id\r\n" + 
					"WHERE basketuser_id = ? AND validity = 1\r\n" + 
					"GROUP BY basketuser_id");
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
	
	
	
	
	void basketAdd(int userId, int productId, int productCount) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("SELECT COUNT(basket_id) FROM shoppingbasket");
			rset = pstmt.executeQuery();

			int basketId = -1;
			rset.next();
			basketId = rset.getInt("COUNT(basket_id)");
			basketId++;

			pstmt = con.prepareStatement("INSERT INTO shoppingbasket VALUES(?,?,?,?,1)");
			pstmt.setInt(1, basketId);
			pstmt.setInt(2, userId);
			pstmt.setInt(3, productId);
			pstmt.setInt(4, productCount);
			pstmt.executeUpdate();
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
	}

	void basketDelete(int userId, int basketId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("UPDATE shoppingbasket SET validity = 2 WHERE basketuser_id = ? AND basket_id = ?");
			pstmt.setInt(1, userId);
			pstmt.setInt(2, basketId);
			pstmt.executeUpdate();
		} finally {
			DBUtil.close(con, pstmt);
		}
	}

	void basketClean(int userId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("UPDATE shoppingbasket SET validity = 2 WHERE basketuser_id = ?");
			pstmt.setInt(1, userId);
			pstmt.executeUpdate();
		} finally {
			DBUtil.close(con, pstmt);
		}
	}
}
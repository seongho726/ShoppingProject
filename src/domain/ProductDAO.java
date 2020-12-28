package domain;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DBUtil;
public class ProductDAO {
    
    ArrayList<Product> allproductRetrieve(int productId) throws SQLException {
        ArrayList<Product> products = new ArrayList<Product>();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        try {
        	con = DBUtil.getConnection();
            pstmt = con.prepareStatement("SELECT * FROM shoppingproduct");
            pstmt.setInt(1, productId);
            rset = pstmt.executeQuery();
            while (rset.next()) {
            	products.add(new Product(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4),
                						rset.getInt(5), rset.getInt(6)));
            }
        } finally {
			DBUtil.close(con, pstmt, rset);
		}
		return products;

	}
    ArrayList<Product> productRetrieve(String productName) throws SQLException {
        ArrayList<Product> products = new ArrayList<Product>();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        try {
        	con = DBUtil.getConnection();
            pstmt = con.prepareStatement("SELECT * FROM shoppingproduct WHERE productName like '%" + productName + "%'");
            rset = pstmt.executeQuery();
            while (rset.next()) {
            	products.add(new Product(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4),
						rset.getInt(5), rset.getInt(6)));
            }
        } finally {
        	DBUtil.close(con, pstmt, rset);
        }
        return products;
    }
     
    void productInsert(int productId, String productType, String productName, String description, int price, int inventory) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        try {
        	con = DBUtil.getConnection();
            pstmt = con.prepareStatement("SELECT COUNT(productId) FROM shoppingproduct");
            rset = pstmt.executeQuery();
            
            int productId = -1;
            rset.next();
            productId = rset.getInt("COUNT(productId)");
            productId++;
            
            pstmt = con.prepareStatement("INSERT INTO shoppingproduct VALUES(?,?,?,?,?,?)");
            pstmt.setInt(1, productId);
            pstmt.setString(2, productType);
            pstmt.setString(3, productName);
            pstmt.setString(4, description);
            pstmt.setInt(5, price);
            pstmt.setInt(6, inventory);
            pstmt.executeQuery();
        } finally {
        	DBUtil.close(con, pstmt, rset);
        }
    }
    void productUpdate(int productId) {
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try {
        	con = DBUtil.getConnection();
            pstmt = con.prepareStatement("UPDATE shoppingproduct SET productType = ? productName = ? description = ? price = ? inventory = ? WHERE productId = ?");
            pstmt.setInt(1, productId);
            pstmt.executeQuery();
        } catch (SQLException se) {
            throw new RuntimeException(
                    "A database error occurred. " + se.getMessage());
        } finally {
        	DBUtil.close(con, pstmt);
        }
    }
}
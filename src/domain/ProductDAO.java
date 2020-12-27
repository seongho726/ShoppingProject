package domain;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DBUtil;
public class ProductDAO {
    private DBUtil connPool;
    private static final String ALLRETRIEVE_STMT
            = "SELECT * FROM shoppingproduct";
    private static final String INSERT_STMT = "INSERT INTO shoppingproduct VALUES(?,?,?,?,?,?)";
    private static final String UPDATE_STMT = "UPDATE shoppingproduct SET ProductType = ? ProductName = ? Explanation = ? Price = ? Inventory = ? WHERE ProductID = ?";
    private static final String GETID_STMT = "SELECT COUNT(ProductID) FROM shoppingproduct";
    ArrayList<Product> allproductRetrieve() throws SQLException {
        ArrayList<Product> products = new ArrayList<Product>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        try {
            conn = connPool.getConnection();
            stmt = conn.prepareStatement(ALLRETRIEVE_STMT);
            rset = stmt.executeQuery();
            while (rset.next()) {
                int ProductID = rset.getInt(1);
                String ProductType = rset.getString(2);
                String ProductName = rset.getString(3);
                String Explanation = rset.getString(4);
                int Price = rset.getInt(5);
                int Inventory = rset.getInt(6);
                products.add(new Product(ProductID, ProductType, ProductName, Explanation, Price, Inventory));
            }
            return products;
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
    ArrayList<Product> productRetrieve(String productname) throws SQLException {
        ArrayList<Product> products = new ArrayList<Product>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        try {
            conn = connPool.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM shoppingproduct WHERE ProductName like '%" + productname + "%'");
            rset = stmt.executeQuery();
            while (rset.next()) {
                int ProductID = rset.getInt(1);
                String ProductType = rset.getString(2);
                String ProductName = rset.getString(3);
                String Explanation = rset.getString(4);
                int Price = rset.getInt(5);
                int Inventory = rset.getInt(6);
                products.add(new Product(ProductID, ProductType, ProductName, Explanation, Price, Inventory));
            }
            return products;
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
    void productInsert(String producttype, String productname, String explanation, int price, int inventory) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        try {
            conn = connPool.getConnection();
            stmt = conn.prepareStatement(GETID_STMT);
            rset = stmt.executeQuery();
            int ID = -1;
            rset.next();
            ID = rset.getInt("COUNT(ProductID)");
            ID++;
            stmt = conn.prepareStatement(INSERT_STMT);
            stmt.setInt(1, ID);
            stmt.setString(2, producttype);
            stmt.setString(3, productname);
            stmt.setString(4, explanation);
            stmt.setInt(5, price);
            stmt.setInt(6, inventory);
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
    void productUpdate(int productid, String producttype, String productname, String explanation, int price, int inventory) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        try {
            conn = connPool.getConnection();
            stmt = conn.prepareStatement(UPDATE_STMT);
            stmt.setString(1, producttype);
            stmt.setString(2, productname);
            stmt.setString(3, explanation);
            stmt.setInt(4, price);
            stmt.setInt(5, inventory);
            stmt.setInt(6, productid);
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
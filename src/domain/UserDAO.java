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

import util.DBUtil;

public class UserDAO {
	

    User userRetrieve(String userType, String userName, String password) throws SQLException {
        User user = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        int rows = 0;
        try {
            con = DBUtil.getConnection();
            pstmt = con.prepareStatement("SELECT * FROM shoppinguser WHERE usertype=? AND username=? AND password =?");
            pstmt.setString(1, userType);
            pstmt.setString(2, userName);
            pstmt.setString(3, password);
            rset = pstmt.executeQuery();
            while (rset.next()) {
                int UserID = rset.getInt("shoppinguser_id");
                String UserType = rset.getString("usertype");
                String UserName = rset.getString("username");
                String Password = rset.getString("password");
                String Email = rset.getString("email");
                String Contact = rset.getString("contact");
                String Address = rset.getString("address");
//                rows++;
//                if (rows > 1) {
//                    throw new SQLException("Too many rows were returned.");
//                }
                user = new User(UserID, UserType, UserName, Password, Email, Contact, Address);
            }
        }   finally {
        	DBUtil.close(con, pstmt, rset);
        }
		return user;
    }

    @SuppressWarnings("resource")
	public static boolean userAdd(String userName, String password, String email, String contact, String address) throws SQLException{
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        boolean result = false;
        try {
            con = DBUtil.getConnection();
            pstmt = con.prepareStatement("INSERT INTO shoppinguser VALUES(shoppinguser_id_seq.nextval,'C',?,?,?,?,?)");
                  
            pstmt.setString(1, userName);
            pstmt.setString(2, password);
            pstmt.setString(3, email);
            pstmt.setString(4, contact);
            pstmt.setString(5, address);
            pstmt.executeUpdate();
            result = true;
        } catch(Exception e) {
        	e.printStackTrace();
        } finally {
        	DBUtil.close(con, pstmt);
        } return result;
        
//    void userAdd(String userType, String userName, String password, String email, String contact, String address) throws SQLException{
//        Connection con = null;
//        PreparedStatement pstmt = null;
//        ResultSet rset = null;
//        try {
//            con = DBUtil.getConnection();
//            pstmt = con.prepareStatement("SELECT COUNT(shoppinguser_id) FROM shoppinguser");
//            rset = pstmt.executeQuery();
//            int ID = -1;
//            rset.next();
//            ID = rset.getInt("COUNT(shoppinguser_id)");
//            ID++;
//            pstmt = con.prepareStatement("INSERT INTO shoppinguser VALUES(?,?,?,?,?,?,?)");
//            pstmt.setInt(1, ID);
//            pstmt.setString(2, userType);
//            pstmt.setString(3, userName);
//            pstmt.setString(4, password);
//            pstmt.setString(5, email);
//            pstmt.setString(6, contact);
//            pstmt.setString(7, address);
//            pstmt.executeQuery();
//        } finally {
//        	DBUtil.close(con, pstmt);
//        }
//        
//    }
    }
}

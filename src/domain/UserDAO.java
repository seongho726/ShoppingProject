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
	

    User userRetrieve(String usertype, String username, String password) throws SQLException {
        User user = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        int rows = 0;
        try {
            con = DBUtil.getConnection();
            pstmt = con.prepareStatement("SELECT * FROM shoppinguser WHERE usertype=? AND username=? AND Password =?");
            pstmt.setString(1, usertype);
            pstmt.setString(2, username);
            pstmt.setString(3, password);
            rset = pstmt.executeQuery();
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
        }   finally {
        	DBUtil.close(con, pstmt, rset);
        }
		return user;
    }

    void userAdd(String usertype, String username, String password, String email, String contact, String address) throws SQLException{
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        try {
            con = DBUtil.getConnection();
            pstmt = con.prepareStatement("SELECT COUNT(userID) FROM shoppinguser");
            rset = pstmt.executeQuery();
            int ID = -1;
            rset.next();
            ID = rset.getInt("COUNT(UserID)");
            ID++;
            pstmt = con.prepareStatement("INSERT INTO shoppinguser VALUES(?,?,?,?,?,?,?)");
            pstmt.setInt(1, ID);
            pstmt.setString(2, usertype);
            pstmt.setString(3, username);
            pstmt.setString(4, password);
            pstmt.setString(5, email);
            pstmt.setString(6, contact);
            pstmt.setString(7, address);
            pstmt.executeQuery();
        } finally {
        	DBUtil.close(con, pstmt);
        }
        
    }
}

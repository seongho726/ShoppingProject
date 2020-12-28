package domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DBUtil;

public class LoginDAO {
	public static boolean validate(String userType, String userName, String password) throws ClassNotFoundException, SQLException {
		  Connection con = null;
	      PreparedStatement pstmt = null;
	      ResultSet rset = null;  
		  boolean status = false;
	      try {
	        		con = DBUtil.getConnection();
	                pstmt = con.prepareStatement("SELECT * FROM shoppinguser where userType = ? and userName = ? and password = ?");
	                pstmt.setString(1, userType);
	                pstmt.setString(2, userName);
	        		pstmt.setString(3, password);
	                rset = pstmt.executeQuery();
	                status = rset.next();
	} finally {
    	DBUtil.close(con, pstmt, rset);
    } return status;
}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
}

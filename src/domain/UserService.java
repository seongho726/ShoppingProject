package domain;

import java.sql.SQLException;

public class UserService {

    private UserDAO userDataAccess;

    public UserService() {
        userDataAccess = new UserDAO();
    }

    public User getUser(String userType, String userName, String password) {
        User user = null;
        try {
            user = userDataAccess.userRetrieve(userType, userName, password);
        } catch (Exception e) {
            user = null;
        }
        return user;
    }

    public void userCreate(String userType, String userName, String password, String email, String contact, String address) throws SQLException {
        userDataAccess.userAdd(userType, userName, password, email, contact, address);
    }
}
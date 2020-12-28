package domain;

public class UserService {

    private UserDAO userDataAccess;

    public UserService() {
        userDataAccess = new UserDAO();
    }

    public User getUser(String usertype, String username, String password) {
        User user = null;
        try {
            user = userDataAccess.userRetrieve(usertype, username, password);
        } catch (Exception e) {
            user = null;
        }
        return user;
    }

    public void userCreate(String usertype, String username, String password, String email, String contact, String address) {
        userDataAccess.userCreate(usertype, username, password, email, contact, address);
    }
}
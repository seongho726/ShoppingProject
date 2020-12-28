package domain;

import java.sql.SQLException;
import java.util.ArrayList;

public class BasketService {

    private BasketDAO basketDataAccess;

    public BasketService() {
        basketDataAccess = new BasketDAO();
    }

    public ArrayList<Basket> getBasket(int userId) {
        ArrayList<Basket> baskets = null;
        try {
            baskets = basketDataAccess.basketRetrieve(userId);
        } catch (Exception e) {
            baskets = null;
        }
        return baskets;
    }

    public void addBasket(int userId, int productId, int productCount) throws SQLException {
        basketDataAccess.basketAdd(userId, productId, productCount);
    }

    public void deleteBasket(int userId, int productId) throws SQLException {
        basketDataAccess.basketDelete(userId, productId);
    }

    public void cleanBasket(int userId) throws SQLException {
        basketDataAccess.basketClean(userId);
    }
}
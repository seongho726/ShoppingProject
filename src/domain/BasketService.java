package domain;

import java.util.ArrayList;

public class BasketService {

    private BasketDAO basketDataAccess;

    public BasketService() {
        basketDataAccess = new BasketDAO();
    }

    public ArrayList<Basket> getBasket(int userid) {
        ArrayList<Basket> baskets = null;
        try {
            baskets = basketDataAccess.basketRetrieve(userid);
        } catch (Exception e) {
            baskets = null;
        }
        return baskets;
    }

    public void addBasket(int userid, int productid, int numbers) {
        basketDataAccess.basketAdd(userid, productid, numbers);
    }

    public void deleteBasket(int userid, int productid) {
        basketDataAccess.basketDelete(userid, productid);
    }

    public void cleanBasket(int userid) {
        basketDataAccess.basketClean(userid);
    }
}
package domain;
import java.sql.SQLException;
import java.util.ArrayList;
public class ProductService {
   
    private ProductDAO productDataAccess;
   
    public ProductService() {
        productDataAccess = new ProductDAO();
    }
   
    public ArrayList<Product> getAllProduct(int productId) {
        ArrayList<Product> products = null;
        try {
            products = productDataAccess.allproductRetrieve(productId);
        } catch (Exception e) {
            products = null;
        }
        return products;
    }
   
    public ArrayList<Product> getProduct(String productName) {
        ArrayList<Product> products = null;
        try {
            products = productDataAccess.productRetrieve(productName);
        } catch (Exception e) {
            products = null;
        }
        return products;
    }
   
    public void insertProduct(int productId, String productType, String productName, String description, int price, int inventory) throws SQLException {
        productDataAccess.productInsert(productId, productType, productName, description, price, inventory);
    }
   
    public void updateProduct(int productId) throws SQLException{
        productDataAccess.productUpdate(productId);
    }
}
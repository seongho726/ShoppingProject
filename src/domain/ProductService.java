package domain;
import java.util.ArrayList;
public class ProductService {
   
    private ProductDAO productDataAccess;
   
    public ProductService() {
        productDataAccess = new ProductDAO();
    }
   
    public ArrayList<Product> getAllProduct() {
        ArrayList<Product> products = null;
        try {
            products = productDataAccess.allproductRetrieve();
        } catch (Exception e) {
            products = null;
        }
        return products;
    }
   
    public ArrayList<Product> getProduct(String productname) {
        ArrayList<Product> products = null;
        try {
            products = productDataAccess.productRetrieve(productname);
        } catch (Exception e) {
            products = null;
        }
        return products;
    }
   
    public void insertProduct(String productType, String productName, String description, int price, int inventory) {
        productDataAccess.productInsert(productType, productName, description, price, inventory);
    }
   
    public void updateProduct(int productId, String productType, String productName, String description, int price, int inventory) {
        productDataAccess.productUpdate(productId, productType, productName, description, price, inventory);
    }
}
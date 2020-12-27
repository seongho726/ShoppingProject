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
   
    public void insertProduct(String producttype, String productname, String explanation, int price, int inventory) {
        productDataAccess.productInsert(producttype, productname, explanation, price, inventory);
    }
   
    public void updateProduct(int productid, String producttype, String productname, String explanation, int price, int inventory) {
        productDataAccess.productUpdate(productid, producttype, productname, explanation, price, inventory);
    }
}
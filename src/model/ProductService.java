package model;
import java.sql.SQLException;
import java.util.ArrayList;

import model.domain.Product;
public class ProductService {
   
    private ProductDAO productDataAccess;
   
    public ProductService() {
        productDataAccess = new ProductDAO();
    }
    public static ProductService getProdService() {
    	return new ProductService();
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
   
    public ArrayList<Product> getProduct(String productName) {
        ArrayList<Product> products = null;
        try {
            products = productDataAccess.productRetrieve(productName);
        } catch (Exception e) {
            products = null;
        }
        return products;
    }
    
    public ArrayList<Product> getProductById(int productId) {
        ArrayList<Product> products = null;
        try {
            products = productDataAccess.productRetrieveById(productId);
        } catch (Exception e) {
            products = null;
        }
        return products;
    }
   
    public boolean insertProduct(String productType, String productName, String description, int price, int inventory) throws SQLException {
       return productDataAccess.productAdd(productType, productName, description, price, inventory); 
    }
   
    public void updateProduct(int productId) throws SQLException{
        productDataAccess.productUpdate(productId, null, null, null, productId, productId);
    }
}
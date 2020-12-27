package domain;
public class Product {
   
    int productid;
    String producttype;
    String productname;
    String explanation;
    int price;
    public int getProductid() {
        return productid;
    }
    public Product(int productid, String producttype, String productname, String explanation, int price, int inventory) {
        this.productid = productid;
        this.producttype = producttype;
        this.productname = productname;
        this.explanation = explanation;
        this.price = price;
        this.inventory = inventory;
    }
    public void setProductid(int productid) {
        this.productid = productid;
    }
    public String getProducttype() {
        return producttype;
    }
    public void setProducttype(String producttype) {
        this.producttype = producttype;
    }
    public String getProductname() {
        return productname;
    }
    public void setProductname(String productname) {
        this.productname = productname;
    }
    public String getExplanation() {
        return explanation;
    }
    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getInventory() {
        return inventory;
    }
    public void setInventory(int inventory) {
        this.inventory = inventory;
    }
    int inventory;
   
}
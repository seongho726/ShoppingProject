package domain;
public class Basket {
    int basketid;
    int userid;
    int productid;
    int numbers;
    int validity;
    public Basket(int basketid, int userid, int productid, int numbers, int validity) {
        this.basketid = basketid;
        this.userid = userid;
        this.productid = productid;
        this.numbers = numbers;
        this.validity = validity;
    }
    public int getBasketid() {
        return basketid;
    }
    public void setBasketid(int basketid) {
        this.basketid = basketid;
    }
    public int getUserid() {
        return userid;
    }
    public void setUserid(int userid) {
        this.userid = userid;
    }
    public int getProductid() {
        return productid;
    }
    public void setProductid(int productid) {
        this.productid = productid;
    }
    public int getNumbers() {
        return numbers;
    }
    public void setNumbers(int numbers) {
        this.numbers = numbers;
    }
    public int getValidity() {
        return validity;
    }
    public void setValidity(int validity) {
        this.validity = validity;
    }
}
# 쇼핑몰 구축 프로젝트 

Customer와 Admin 두 타입의 사용자를 고객으로 두고 있는 쇼핑몰 구축

## Status 

로그인, 상품 검색, 상품 장바구니에 추가, 상품 구매 후 구매 내역 DB에 보관하는 과정까지 구축 

## Data Modelling  

#### shoppinguser: 
사용자 테이블로서 유저 타입을 C (Customer) 와 A (Admin) 으로 구분한다. 
 
#### shoppingbasket:
장바구니 테이블은 장바구니에 추가된 상품을 각각 유저의 고유 아이디로 관리한다. 
Validity의 데이터는 1과 2로 구성되어있고 Validity의 값이 1인 제품들은 유저가 장바구니를 조회할 때 조회할 수 있으나 Validity 값이 2인 제품들은 조회할 수 없다. 장바구니의 제품을 유저가 삭제하게 되면 제품이 사라지는 것이 아니라 Validity가 2로 변경된다. 

데이터를 삭제하지 않고 DB에 남겨두어 고객의 제품 선택 정보들을 추후에 활용할 수 있다.  

#### shoppingproduct: 
상품 데이터 테이블 

#### shoppingpayment:
장바구니에 담긴 제품들이 Checkout에서 구매가 이루어지면 결제정보와 구매한 제품의 총합과 갯수를 저장한다.  

테스트에 사용한 DDL & DML 
```sql
USER 
-- 
DROP TABLE shoppinguser cascade constraint;

BASKET
-- 
DROP TABLE shoppingbasket cascade constraint;

PRODUCT 
-- 
DROP TABLE shoppingproduct cascade constraint;

PAYMENT  
-- 
DROP TABLE shoppingpayment cascade constraint;

DROP SEQUENCE shoppinguser_id_seq;

CREATE SEQUENCE shoppinguser_id_seq;

DROP TABLE shoppinguser cascade constraint;
CREATE TABLE shoppinguser(
 shoppinguser_id       NUMBER(5) PRIMARY KEY,
 usertype varchar2(20),
 username varchar2(20) UNIQUE,
 password varchar2(20) NOT NULL,
 email varchar2(30),
 contact varchar2(20),
 address varchar2(50));

CREATE TABLE shoppingproduct(
  product_id NUMBER PRIMARY KEY,
  product_type VARCHAR2(20),
  product_name VARCHAR2(20),
  description VARCHAR2(50),
  price NUMBER,
  inventory NUMBER);

CREATE TABLE shoppingbasket(
 basket_id NUMBER PRIMARY KEY,
 basketuser_id NUMBER,
 product_id NUMBER,
 product_count NUMBER,
 validity NUMBER);

DROP SEQUENCE payment_id_seq;

CREATE SEQUENCE payment_id_seq;

CREATE TABLE shoppingpayment(
  payment_id NUMBER PRIMARY KEY,
  paymentuser_id NUMBER,
  total_count NUMBER, 
  total_price NUMBER,
  address VARCHAR2(50),
  contact VARCHAR2(20),
  cc_number VARCHAR2(20),
  cc_expiration VARCHAR2(20),
  cc_password VARCHAR2(10));


ALTER TABLE shoppingbasket ADD FOREIGN KEY (basketuser_id) REFERENCES shoppinguser  (shoppinguser_id);
ALTER TABLE shoppingpayment ADD FOREIGN KEY (paymentuser_id)  REFERENCES shoppinguser  (shoppinguser_id);
ALTER TABLE shoppingbasket ADD FOREIGN KEY (product_id) REFERENCES shoppingproduct  (product_id);

insert into shoppinguser values(shoppinguser_id_seq.nextval, 'A', 'Admin', 'aaaaa','admin@example.com', '010-000-0000', 'Korea');
insert into shoppinguser values(shoppinguser_id_seq.nextval, 'C', 'Customer1', 'bbbbb','customer1@example.com', '010-000-0001', 'Korea');
insert into shoppinguser values(shoppinguser_id_seq.nextval, 'C', 'Customer2', 'ccccc','customer2@example.com', '010-000-0002', 'Korea');

insert into shoppingproduct values(1, 'Phone', 'iPhone12', 'The most advanced phone in the universe.', 2000, 100);
insert into shoppingproduct values(2, 'Phone', 'Galaxy20', 'The most beautiful phone in the universe.', 1000, 50);
insert into shoppingproduct values(3, 'Earphone', 'Galaxybuds', 'The most advanced earphone in the universe.', 100, 20);
```

## Project Structure  

### Domain
* Basket
* BasketDAO 
* Basket Service 
* Calculate 
* LoginDAO
* Payment 
* PaymentDAO 
* PaymentService
* Product
* ProductDAO
* ProductService
* User
* UserDAO
* UserService

### Util 
* DBUtil 
* PublicCommon
* Status 
  
### Web (Servlet files) 
* AddBasketServlet
* BuyBasketServlet
* CreateProductServlet
* DeleteBasketServlet
* JoinServlet
* Login
* PayBasketServlet
* ProcessProductServlet
* RetrieveBasketServlet

### WebContent 
* basket.jsp
* checkout.jsp
* index.html
* join.jsp
* joinconfirm.jsp
* joinfailure.jsp
* login.jsp
* main.jsp
* pay.jsp
* payfail.jsp
  



## Technologies Used 

JDBC, Servlet, JSP, Tomcat 8.5, Lombok  


## Team Member 
https://github.com/ajdeve
https://github.com/seongho726
https://github.com/EunbeeGo
			
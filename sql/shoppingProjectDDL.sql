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

DROP TABLE shoppinguser cascade constraint;
CREATE TABLE shoppinguser(
 shoppinguser_id varchar2(50) PRIMARY KEY,
 usertype varchar2(20),
 username varchar2(20) ,
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
 basketuser_id VARCHAR2(50),
 product_id NUMBER,
 product_count NUMBER,
 validity NUMBER);

DROP SEQUENCE payment_id_seq;

CREATE SEQUENCE payment_id_seq;

CREATE TABLE shoppingpayment(
  payment_id NUMBER PRIMARY KEY,
  paymentuser_id VARCHAR2(50),
  total_count NUMBER, 
  total_price NUMBER,
  address VARCHAR2(50),
  contact VARCHAR2(20),
  cc_number VARCHAR2(20),
  cc_expiration VARCHAR2(20),
  cc_password VARCHAR2(10));

ALTER SEQUENCE shoppingproduct_id_seq INCREMENT BY 1;
ALTER TABLE shoppingbasket ADD FOREIGN KEY (basketuser_id) REFERENCES shoppinguser  (shoppinguser_id);
ALTER TABLE shoppingpayment ADD FOREIGN KEY (paymentuser_id)  REFERENCES shoppinguser  (shoppinguser_id);
ALTER TABLE shoppingbasket ADD FOREIGN KEY (product_id) REFERENCES shoppingproduct  (product_id);

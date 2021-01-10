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



CREATE TABLE shoppinguser(
 shoppinguser_id varchar2(255) PRIMARY KEY,
 usertype varchar2(255),
 username varchar2(255) ,
 password varchar2(255) NOT NULL,
 email varchar2(255),
 contact varchar2(255),
 address varchar2(255));

CREATE TABLE shoppingproduct(
  product_id NUMBER PRIMARY KEY,
  product_type VARCHAR2(255),
  product_name VARCHAR2(255),
  description VARCHAR2(255),
  price NUMBER,
  inventory NUMBER);

CREATE TABLE shoppingbasket(
 basket_id NUMBER PRIMARY KEY,
 basketuser_id VARCHAR2(255),
 product_id NUMBER,
 product_count NUMBER,
 validity NUMBER);
 

CREATE TABLE shoppingpayment(
  payment_id NUMBER PRIMARY KEY,
  paymentuser_id VARCHAR2(255),
  total_count NUMBER, 
  total_price NUMBER,
  address VARCHAR2(255),
  contact VARCHAR2(255),
  cc_number VARCHAR2(255),
  cc_expiration VARCHAR2(255),
  cc_password VARCHAR2(255));

DROP SEQUENCE basket_id_seq;
DROP SEQUENCE payment_id_seq;
DROP SEQUENCE shoppingproduct_id_seq;

CREATE SEQUENCE basket_id_seq INCREMENT BY 1;
CREATE SEQUENCE payment_id_seq INCREMENT BY 1;
CREATE SEQUENCE shoppingproduct_id_seq INCREMENT BY 1;


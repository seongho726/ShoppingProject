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
--
DROP SEQUENCE shoppinguser_id_seq;

CREATE SEQUENCE shoppinguser_id_seq;
CREATE TABLE shoppinguser(
 shoppinguser_id        NUMBER(5) PRIMARY KEY,
 usertype varchar2(20),
 username varchar2(20),
 password varchar2(20),
 email varchar2(30),
 contact varchar2(20),
 address varchar2(50));
CREATE TABLE shoppingproduct(
  product_id number primary key,
  product_type varchar2(20),
  product_name varchar2(20),
  description varchar2(50),
  price number,
  inventory number);
CREATE TABLE shoppingbasket(
 basket_id number primary key,
 basketuser_id number,
 product_id number,
 product_count number,
 validity number);
CREATE TABLE shoppingpayment(
  payment_id number primary key,
  paymentuser_id number,
  product_id number,
  address varchar2(50),
  contact varchar2(20),
  cc_number varchar2(20),
  cc_expiration varchar2(20),
  cc_password varchar2(10));
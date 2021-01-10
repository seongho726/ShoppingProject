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
장바구니에 담긴 제품들이 Checkout에서 구매가 이루어지면 결제정보와 구매한 제품의 총합과 총계를 저장한다.  

## Technologies Used 

JDBC, Servlet, JSP, Tomcat 8.5, Lombok  


## Team Member 
[ajdeve](https://github.com/ajdeve)

[seongho726](https://github.com/seongho726)

[EunbeeGo](https://github.com/EunbeeGo)

## Credits
The design template used was not made from scratch.
We used a T-Mart theme free version found [here](https://themehunt.com/item/1527068-tmart-free-minimal-ecommerce-html5-template). 

# :iphone: 쇼핑몰 구축 프로젝트 
 # Welcome to TECHNOLOGI
 Technologi 는 최신 핸드폰과 블루투스 이어폰등을 판매하는 전자제품 쇼핑몰입니다. 
 
 ![Logo](https://github.com/seongho726/ShoppingProject/blob/main/WebContent/images/logo/logo.png)

# Project Scope
Customer와 Admin 두 타입의 사용자를 고객으로 두고 있는 쇼핑몰 구축

## Status 

### Part 1:
로그인, 상품 검색, 상품 장바구니에 추가, 상품 구매 후 구매 내역 DB에 보관하는 과정까지 구축 

### Part 2: 
- 구현된 기능을 Front End 로 구현
- Native Query를 활용해 코어 메소드를 JPA로 변환
- Service 와 Controller을 사용해 Code Refactoring 시도 및 Servlet을 Controller를 통해 관리하는 구조로 변경
- Controller에서의 예외처리와 Sl4j를 활용한 Log 기록
- Axios를 활용한 Ajax cart 구현 
- 고객의 상품 구매 후 구매 내역 출력
- Admin 쪽의 제품 수정및 삭제 기능을 추가 
- 제품에 이미지 출력
- bootstrap modal 적용

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

- DB: Oracle SQL, JDBC, JPA
- Web: Servlet, JSP, 
- Server: Tomcat 8.5   
- Ajax: Axios 
- Log: Sl4j
- etc: Lombok 

## Team Member 
### Part 1:

[ajdeve](https://github.com/ajdeve)

[seongho726](https://github.com/seongho726)

[EunbeeGo](https://github.com/EunbeeGo)

### Part 2:

[ajdeve](https://github.com/ajdeve)

[seongho726](https://github.com/seongho726)

## Credits
The design template used was not made from scratch.
We used a T-Mart theme free version found [here](https://themehunt.com/item/1527068-tmart-free-minimal-ecommerce-html5-template) for learning purpuse only. 

[1] 실습 목적
	1. Servlet & JSP를 활용한 Web Program 개발하기
	2. 개발 및 실행 환경 구축하기
		maven + library 등등등
		
	3. 정상 실행 되게 완성
	4. JDBC -> JPA 변경
	5. Maven 
		JPA 필수 + log4j or slf4j + lombok ..
	6. Connection Pool 필수 
	7. 구조 변경가능, 코드 개선은 필수 
	...
		
		
[2] 실습  
	1. 기존 JDBC 프로젝트 소스 확장하기
		
	2. 추가 구현 로직
		2-1. Connection Pool 구조로 변환하기
			- context.xml 파일 제공되었음 
		
		2-2. 미리 제공된 로직[실행 가능]
		  - 진행중인 재능 기부 프로젝트 모든 정보 검색하기
				
		2-3. 미션 수행 로직
			2-3-1. 재능 기부자 모두 검색하기
			2-3-2. 재능 기부자 정보 수정하기
			2-3-3. 재능 기부자 탈퇴하기
			
		2-4. 차후에 혼자 해 보기
			수혜자 CRUD	
		
		2-5. ...		
		
	3. blank source
		3-1. ProbonoFrontController.java
			3-1-1. activistAll() : 모든 재능 기부자 검색하기
			3-1-2. activistUpdate() : 재능 기부자 정보 수정하기
			3-1-3. activistDelete() : 재능 기부자 탈퇴하기
		
		3-2. activistList.jsp		
			3-2-1. 모든 재능 기부자 보기 완성하기
			
		3-3. probonoProjectList.jsp
			3-3-1. 모든 재능 기부 프로젝트 보기  완성하기
			
		3-4. activistDetail.jsp
			3-4-1. EL tag로 출력로직 완성하기	
			
			
			
# LibrarySystem
학교 무인 대출반납기 
Team Project :
팀장: 오수빈
팀원: 양승모, 최두식, 최진호, 진희, 박천혁

## Introduce
학생들에게 대여/반납/연장 기능을 제공하는 도서관 프로그램

1. 학생들은 로그인 후 책을 대여/조회/반납/연장 할 수 있다.
2. 관리자는 책정보를 조회/삭제/추가/수정 할 수 있다.

## evelopment Environment
- jdk 11.0.11
- Oracle Database 18c

## Requirement
- 자바 라이브러리
 + ojdbc8
 + HikariCP 3.4.5
 + oraclepki
 + osdt_cert
 + osdt_core
 + slf4j 1.7.25
## 개발 현황
|day|content|
|:--:|:--:|
|1일차|프로젝트 주제 선정|
|2일차|ER 다이어그램 작성|
|3일차|프로젝트 주제 재선정, 유스케이스 다이어그램 작성|
|4일차|DB 생성|
|5일차|DB 수정 및 DB 원격 설정|
|6일차|DB 클라우드 연결, JDBC 연결, DAO/DTO 작성|
|7일차|DAO/DTO 작성, 프로토타입 디자인|
|8일차|DAO/DTO 작성, 프로토타입 디자인, 로그인/메인/관리자 페이지 생성|
|9일차|DB 수정, 관리자 dialog창, 관리자 페이지 표 생성, 광고페이지 화면, <br> 메인페이지 완성, 로그인 페이지 권한 확인|
|10일차|DB 수정, 광고페이지, 관리자 테이블 리팩토링|
|11일차|광고 상세보기 DB 연결, DAO 수정, DB 수정, 매니저 테이블 수정, 매니저 다이어로그 DB 연동, 반납 화면 완성|
|12일차|반납 페이지 db연결, student DAO/DTO 수정, 반납 페이지 테이블 하이라이트 처리, <br> 반납 페이지 테이블 선택 시 이벤트값 반환하는 작업, 대여페이지 화면, 관리자 페이지 테이블 DB 연결<br>검색 설정 후 DB 값 받아 table에 출력, 테이블 페이징 기능, 삭제 버튼 기능|
|12일차|반납 페이지 테이블 하이라이트 처리,반납 페이지 테이블 선택 시 이벤트값 반환하는 작업, <br> 대여페이지 값 전달, 관리자 페이지 추가/수정 submit시 테이블 업데이트, <br> 삭제 버튼 기능|

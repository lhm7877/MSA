# Coffee

## 컨벤션
- gitmoji

## 선행지식
Webclient, Mono, Flux react   
https://www.youtube.com/watch?v=VeSHa_Xsd2U

## 목표
1주차: 키지 구조를 만들어본다

### 프로젝트구성
api service util gateway

### 서비스
주문 상품 결제 회원 리뷰

### 요구사항
- 주문을 받는다. 회원 번호를 header에 받는다 "X-User-Id"
- 메뉴를 보여준다. 카테고리별, 전체
- 내 주문 조회 "X-User-Id"
- 상품 리뷰, 내가 리뷰한 상품 조회
- 상품 등록
- 회원 가입 가입하면 X-User-Id를 받는다.
- 회원이 상품 결제를 하면 상품 재고와 회원 포인트 차감
- 회원이 포인트를 충전한다.
- 회원 조회
- 환불 기능
- 주문시 옵션 설정

### DB
각자 설계
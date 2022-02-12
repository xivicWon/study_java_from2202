# 자바 스터디

# 22.02.12
- 오류 발생
  - 런타임 오류
  - 빌드 오류
- Http Status Code
  - 정상 ( 4xx )
    - 200
    - 204 No content 
  - 사용자 문제 ( 4xx )
    - 400 
    - 404
  - 클라이언트 문제 ( 5xx )
    - 500
- Http Method : Method, Url, Scheme
  - GET : 조회 ( R )
  - POST : 저장 ( C ), 복잡한 조건의 조회 ( R )
  - PUT : 전체수정 ( U )
  - PATCH : 부분수정 ( U )
  - DELETE : 삭제 ( D )
- ETC
  - RestController 로 만들어진 객체에서 생성자 Injection 은 자동으로 생성됨.
    - Component 에너테이션으로 인해서 자동으로 Bean 객체를 할당해준다.
  
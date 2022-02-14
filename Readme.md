# 자바 스터디 

## 22.02.14
- - -

- ETC 
  - DB ? 


## 22.02.12
- - -

- 오류 발생
  - 런타임 오류
  - 빌드 오류
- Http Status Code
  - 정상 ( 2xx )
    - 200
    - 204 No content 
  - 클라이언트 문제 ( 4xx )
    - 400 
    - 404
  - 서버 문제 ( 5xx )
    - 500
- Http Method : Method, Url, Scheme
  - GET : 조회 ( R )
  - POST : 저장 ( C ), 복잡한 조건의 조회 ( R ), 기타 ( * )
  - PUT : 전체수정 ( U )
  - PATCH : 부분수정 ( U )
  - DELETE : 삭제 ( D )
- ETC
  - @RestController 로 만들어진 객체에서 생성자 Injection 은 자동으로 생성됨.
    - 어떻게 생성이되는가?
      - @Component 에너테이션으로 인해서 
      - 런타임중에 스프링이 @Component 로 지정된 객체에 대해서는 1개씩 자동으로 Spring Bean에 생성됨.
      - 
  
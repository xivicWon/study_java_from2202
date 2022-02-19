# 자바 스터디 

## 22.02.19
- - -
- Stack, Heap, Static 메모리 영역에 대한 설명
- Test 클래스에 대해 SpringBootTest 제거 및 그 이유
  - 테스트 속도가 느리다.
- 스프링 빈 주입
  - 생성자 주입 - Bean 생성 시점에 주입, 변경 불가능
  - 세터 주입 - 공개(public)으로만 생성해야함. 변경 가능
  - 필드 주입 - 스프링에서만 주입가능 ( 테스트에서 주입 불가능 )
- SOLID 원칙
  - SRP : 한 클래스는 하나의 책임만 가져야 한다. 
  - OCP : 소프트웨어 요소는 확장에는 열려 있으나 변경에는 닫혀 있어야 한다.
  - LSP : 프로그램의 객체는 프로그램의 정확성을 깨뜨리지 않으면서 하위 타입의 인스턴스로 바꿀 수 있어야 한다.
  - ISP : 특정 클라이언트를 위한 인터페이스 여러 개가 범용 인터페이스 하나보다 낫다.
  - DIP : 추상화에 의존해야지, 구체화에 의존하면 안된다
- 숙제!!
  - throw new 에 대한 작업 테스트. 

## 22.02.16
- - -
- @Service 란 ?
  - 비지니스 로직이 포함한 개념
  - 함수명이나 명칭은 가능한 비지니스에서 사용하는 단어를 사용하여 만들어야 함.
- 숙제!!
  - getAllMembers
  - getMember

## 22.02.15
- - -
- 숙제!!
  - findByName() 
    _- NullPointerException 을 어떻게 사용해야 할지 몰르겠음.
    - 기존 ID 방식과 동일하게 했으나 전체를 돌릴때 오류가 발생됨. 
    - repository 의 데이터가 누적됨을 확인하여 초기화 해주는 AfterEach 를 추가하여 처리함.
  - findAll() 
    - 쉽게 처리가 됬음.
  - ETC
    - Test의 함수명을 영어로 하고싶고, Debug에는 한글로 보고싶을땐 @DisplayName 을 사용하면 가능함.
    - Gradle 의 build and run 방식 intelij 로 변경해야 하고, File Encoding 에서 보이는 문자셋을 UTF-8로 해야함.

## 22.02.14
- - -

- Lombok
  - 드디어 써봤다. 롬복
  - @Getter 와 @Setter 를 선언하면 자동으로 해당 함수를 compliling 과정에서 생성해준다.
- domain
  - domain : 도메인 ( business domain ) : 업무 영역 ( web의 도메인이 x )
- repository
  - 기본 repository는 interface 로 만드는데, 이는 실제 연동할 대상 서비스의 종류에 따라 달라질 수 있기 때문에 interface 로 생성한다.
  - 클래스는 Memory + [ repository class name ] 이라고 보통 naming 을 한다.
- Optional 
  - 특정값을 검사할때 활용하는 프레임워크(?) 여러가지 예외처리에 대한 기능들이 있는데 아직은 Basic ~!
- List, HashMap 등등을 사용만 해봄.
- ETC 
  - 숙제!
    - findByName() , findById() 만들기.
  


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
  
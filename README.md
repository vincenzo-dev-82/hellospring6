## 섹션1 스프링 개발 시작하기

## 섹션2 오브젝트와 의존관계

## 섹션3 테스트
### 도메인 모델 아키텍처 패턴
### 도메인 로직, 비즈니스 로직을 어디에 둘지를 결정하는 패턴
1. 트랜젝션 스크립트 - 서비스 메서드
2. 도메인 모델 - 도메인 모델 오브젝트

## 섹션4 템플릿
### 스프링과 JDK업그레이드
* JDK21, Spring6.1.3, SpringBoot3.2.2
### 변하는 코드 분리하기 - 메서드 추출
* Option + Command + M
### 변하지 않는 코드 분리하기 - 메서드 추출
* 템플릿(Template)
  * 템플릿은 어떤 목적을 위해 미리 만들어둔 모양이 있는 틀
  * 고정된 틀 안 에 바꿀 수 있는 부분을 넣어서 사용하도록 만들어진 오브젝트
  * 템플릿 메서드 패턴도 템플릿을 사용
* 템플릿 메서드 패턴?
 * 템플릿 메서드 패턴은 고정된 틀의 로직의 가진 템플릿 메서드를 슈퍼클래스에 두고, 바뀌는 부분을 서브클래스의 메서드에 두는 구조로 이루어진다
### ApiExecutor분리 - 인터페이스 도입과 클래스 분리
### ApiExecutor분리 - 콜백과 메서드 주입
* 콜백(Callback)
  * 콜백은 실행되는 것을 목적으로 다른 오브젝트의 메서드에 전달되는 오브젝트 파라메터로 전달되지만 값을 참조하기 위한 것이 아니라 특정 로직을 담은 메서드를 실행시키는 것이 목적
  * 하나의 메서드를 가진 인터페이스 타입(SAM)의 오브젝트 또는 람다 오브젝트
### ExRateExecutor 콜백
### ApiTemplate 분리
### 디폴트콜백과 템플릿빈
### 스프링이 제공하는 템플릿
* RestTemplate
* JdbcTemplate
* JmsTemplate
* TransactionTemplate
* JpaTemplate
* HibernateTemplate

## 섹션5 예외
### 예외를 다루는 방법
* 예외
  * 예외는 정상적인 프로그램 흐름을 방해하는 사건
  * 예외적인 상황에서만 사용
  * 많은 경우 예외는 프로그램 오류 및 버그 때문에 발생
### JPA를 이용한 Order저장
### Order 리파지터리와 예외
* Introduce Variable (공통변수생성)
  * Ctrl + Command + V
* 예외의 확장성을 고려하여 예외를를 일정하게 처리할 수 있어야만 한다
### DataAccessException과 예외추상화
* DataAccessException
  * DB의 에러코드와 데이터 엑세스 기술에 독립적인 예외 구조
  * 적절한 예외 번역(exception translation) 도구를 제공

## 섹션6 서비스 추상화
### 서비스란 무엇인가?
* 서비스의 종류
  * 애플리케이션 서비스(application service)
    * @Service
* 도메인 서비스(domain service)
* 인프라 서비스(infrastructure service)
  * 도메인/애플리케이션 로직에 참여하지 않는, 기술을 제공하는 서비스 
  * 메일, 캐시, 트랜잭션, 메시징 ... 
  * 서비스 추상화 대상
### 애플리케이이션 서비스 도입
### 

## 인프런 강의 참고
### https://www.inflearn.com/course/%ED%86%A0%EB%B9%84%EC%9D%98-%EC%8A%A4%ED%94%84%EB%A7%816-%EC%9D%B4%ED%95%B4%EC%99%80-%EC%9B%90%EB%A6%AC/dashboard
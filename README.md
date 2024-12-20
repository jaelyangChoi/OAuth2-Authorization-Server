앞서 네이버와 구글이 제공하는 OAuth2 규격에 맞춰 클라이언트가 되어 보았다. <br>
[OAuth2 client - session/SSR 구현](https://github.com/jaelyangChoi/spring-security-oauth2, "github_link")

[OAuth2 client - JWT/CSR,SPA 구현](https://github.com/jaelyangChoi/spring-security-oauth2-jwt, "github_link")

이번엔 우리가 **직접 OAuth2 서비스를 제공하는 <스프링 OAuth2 인가 서버> 와 <스프링 OAuth2 리소스 서버>를 구축**해보자. 

<br>


**구현 예정 프로젝트**

1. OAuth2 인가 서버 (네이버/구글의 OAuth2 로그인 제공 서버와 동일 개념)

2. OAuth2 리소스 서버 (인가 서버에서 JWT를 발급 받은 후 유저의 데이터를 받는 부분)

3. OAuth2 클라이언트 (우리가 구현한 OAuth2 인가/리소스 서버의 인증 서비스를 사용할 제 3자 플랫폼 역할)


---
<br>

본 프로젝트는 위 과정 중 1단계 인가 서버를 구현한다.

## OAuth2 인가 서버 구현
1. 세션 기반 스프링 시큐리티 로그인 기능 (like 네이버 자체의 로그인/회원가입 기능)

2. 제 3자가 OAuth2 서비스를 이용할 수 있도록 등록 (like 네아로, GCP 신청)

3. 로그인 및 코드 발급 프로세스

4. 코드 확인 후 Access 토큰 발급


<br>

### 버전 및 의존성
+ Spring boot 3.5.5
+ Spring Security 6.3.4
+ **OAuth2 Authorization Server 1.3.3**
+ Spring Data JPA
+ JDBC API

# securityJWT_WithJPA

## 사용기술

 - JAVA 17
 - Spring boot 2.7.18
 - JPA
 - h2
 - mysql
 - JWT 0.12.3
 - Eclipse STS(4.20.1)

## 간단히 만든 회원가입과 로그인
backend 만 구현하였으므로 restapi tester 를 통해 확인해볼 수 있다.

 - /api/v1/member        POST 회원가입
```json
{
    "email" : "",
    "name" : "",
    "mobile" : "",
    "password" :"",
    "confirmPassword" : "",
    "agree": true
}
```

 - /api/v1/member/token  POST 로그인(토큰발급확인)
```json
{
    "email" : "",
    "password" :"",
}
```

### 참고 : https://github.com/yonggyo1125

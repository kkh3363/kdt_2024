### EL이란
- Expression Language의 약자
- JSP 2.0에서 새롭게 추가된 스크립트 언어
- 기존의 Script tag의 표현식(<%= 정보 %>) tag에서 업그레이드된 버전 ( ${ 정보 } )

### 주요 특징 
1) JSP 속성영역 (request,  response, session, application) 저장된 속성 객체의 property를 출력한다 
2) 리터럴 데이터, 다양한 연산결과 출력이 가능하다 
3) JSTL과 연동이 가능하다

- 기종 방식 (scriptlet 스클립틀릿 )
 ```
<!--  mvo instance의 name 변수 출력 -->
<% MemberVO vo = (MemberVO) request.getAttribute("mvo"); %>
<%= vo.getName()%>
```
- EL 방식
```
<!--  mvo instance의 name 변수 출력 -->
${requestScope.mvo.name} 

<!-- requestScope는 생략 가능 -->
${mvo.name}
```
### JSP 내장객체 종류
- pageContext : 다른 내장 객체를 생성하는 역할
- pageScope : JSP가 Servlet으로 변환되었을 때, Serlvet 객체 자신을 의미 (=this)
- requestScope :  request 객체에 접근하기 위한 역할
- sessionScope :  session객체에 접근하기 위한 역할
- applicationScope : application 객체 (ServletContext 객체)에 접근하기 위한 역할

### 유효범위
#### request < session < application(ServletContext)
- request의 유효범위 : response 할 때까지
- session의 유효범위 :
   1) 로그아웃(서버에서 session.invalidate() ) 시 소멸
   2) 클라이언트(브라우저) 종료 시 소멸
   3) 지정한 session timeout까지 재접속이 없을 경우 소면
- application(ServletConext) : 웹 어플리케이션 서비스가 종료될 때까지 유효

### EL 에서의 파라미터 제어 객체
- param = request.getParameter();
- paramValues = request.getParameterValues();
-------------------------------------------------

  

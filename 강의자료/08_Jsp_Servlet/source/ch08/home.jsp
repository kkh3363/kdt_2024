<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = (String)session.getAttribute("idKey");
	if ( id == null)
		response.sendRedirect("loginServletForm.html");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%=id%>님 반갑습니다.<p/>
<a href='logout.jsp'>로그아웃</a>
</body>
</html>
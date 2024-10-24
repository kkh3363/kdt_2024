<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String cPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
this is the page
<p><a href="<%=cPath%>/home?action=login" > goto login page</a>
<p><a href="<%=cPath%>/home?action=help" > goto help page</a>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<form action="<%=cPath %>/doLogin" method=get>
	<p>Custom Id : <input type=text name= "customerId" >
	<p><input type="submit" value="로그인" >
</form>
</body>
</html>
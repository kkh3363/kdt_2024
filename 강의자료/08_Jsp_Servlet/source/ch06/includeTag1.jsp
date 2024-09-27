<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Include Tag</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
	String name = "Korea Football";
%>
<jsp:include page="includeTagTop1.jsp" />
include ActionTag의 Body입니다.<br>
body name <% %>
</body>
</html>
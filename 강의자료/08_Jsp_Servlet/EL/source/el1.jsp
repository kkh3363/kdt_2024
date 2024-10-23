<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	 request.setAttribute("siteName", "JSPStudy.co.kr");

	String siteNamestr = (String)request.getAttribute("siteName");
%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3> EL의 기본 문법1</h3>
사이트 명 : ${siteName}

<h3> 스크립트릿</h3>
사이트 명 : <%=siteNamestr %>
</body>
</html>


<%@ page language="java" %> 
<%@ page contentType="text/html; charset=UTF-8" %> 
<%@ page pageEncoding="UTF-8" %>
<%@ page info="copyright 2024 Kongju Univercity" %>
<%@ page import="java.util.*" session="true"
    buffer="16kb"
    autoFlush= "true"
    isThreadSafe="true"
    %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ page errorPage="Error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%= this.getServletInfo() %><br>
<% 
	Date date = new Date();
	int result;
	int one =1, zero=0;
	result = one /zero;		
%>
현재의 날짜와 시간은?<p/>
<%=date.toLocaleString()%>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String siteName = request.getParameter("siteName");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="includeTagTop2.jsp">
<jsp:param name="siteName" value="JSPStudy.co.kr" />
<jsp:param name="siteUrl" value="daum.net" />
</jsp:include>
include ActionTag의 Body입니다.<p/>
<b><%=siteName%></b>
</body>
</html>
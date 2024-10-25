<%@page contentType="text/html;charset=EUC-KR"%>
<%@ page isELIgnored="true"%>
<%
	 request.setAttribute("siteName", "JSPStudy.co.kr");
%>
<html>
<head>
<title>Expression Language</title>
</head>
<body>
<h2>EL의 기본문법2</h2>
사이트명 : <b>${siteName}</b>
</body>
</html>
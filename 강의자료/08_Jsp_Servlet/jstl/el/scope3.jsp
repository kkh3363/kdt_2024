<%@page contentType="text/html;charset=EUC-KR"%>
<%
	  session.setAttribute("id", "rorod");
	  application.setAttribute("siteName", "JSPStudy.co.kr");
%>
<html>
<head>
<title>Expression Language</title>
</head>
<body>
<h2>EL�� Scope2</h2>
<jsp:forward page="scope4.jsp"/>
</body>
</html>
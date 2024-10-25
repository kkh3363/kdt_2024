<%@page contentType="text/html;charset=EUC-KR"%>
<html>
<head>
<title>Expression Language</title>
</head>
<body>
<h2>EL의 Empty</h2>
name의 요청 여부 : <b>${empty param.name}</b>(요청이 없다면 true)<br/>
<a href="empty.jsp?name=rorod">name값이 있는 요청</a> || 
<a href="empty.jsp">name값이 없는 요청</a>
</body>
</html>
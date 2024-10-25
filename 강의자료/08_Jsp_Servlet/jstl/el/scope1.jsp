<%@page contentType="text/html;charset=EUC-KR"%>
<html>
<head>
<title>Expression Language</title>
</head>
<body>
<h2>ELÀÇ Scope1</h2>
<%
	int sum = 0;
	for(int i = 1 ; i <= 10 ; i++){ 
		sum += i;
	}
	request.setAttribute("sum", new Integer(sum));
%>
<jsp:forward page="scope2.jsp"/>
</body>
</html>
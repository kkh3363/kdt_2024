<%@page contentType="text/html;charset=EUC-KR"%>
<%
	 pageContext.setAttribute("msg", "���� �̷�� ����.");
%>
<html>
<head>
<title>Expression Language</title>
</head>
<body>
<h2>EL�� Scope1</h2>
msg(pageScope�� ������) :  <b>${pageScope.msg}</b><p/>
1���� 10���� ��(request�� ������) : <b><%=request.getAttribute("sum") %></b><p/>
1���� 10���� ��(requestScope�� ������) : <b>${requestScope.sum}</b><p/>
</body>
</html>
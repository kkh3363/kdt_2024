<%@page contentType="text/html;charset=EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	  String str1[] = {"simba","rorod","tina","poli"};
	  String str2 = "JAVA, JSP; Spring, Android";
 %>
<html>
<head>
<title>JSTL</title>
</head>
<body >
<h2>Core Tags3</h2>
<c:set var="arr" value="<%=str1%>"/>
<c:forEach var="i" items="${arr}" begin="0" step="1" end="3">
	${i}<br/>
</c:forEach>
<hr align="left" width="220"/>
<c:set var="s" value="<%=str2%>"/>
<c:forTokens var="st" items="${s}" delims=", ;">
	<b>${st}&nbsp;</b>
</c:forTokens>
</body>
</html>
<%@page contentType="text/html;charset=EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>JSTL</title>
</head>
<body >
<h2>Core Tags4</h2>
<hr width="150" align="left"/>
<c:import url="http://localhost/myapp/ch20/jstl/coreTags2.jsp">
	<c:param name="id" value="JSPStudy"/>
	<c:param name="color" value="orange"/>
</c:import>
<hr width="360" align="left"/>
<c:url var="url1" value="https://www.google.co.kr/">
	<c:param name="q" value="JSPStudy"/>
	<c:param name="safe" value="off"/>
</c:url>
<a href="${url1}">구글에서 JSPStudy 검색</a>
</body>
</html>
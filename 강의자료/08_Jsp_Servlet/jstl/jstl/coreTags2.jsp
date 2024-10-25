<%@page contentType="text/html;charset=EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>JSTL</title>
</head>
<body >
<h2>Core Tags2</h2>
<c:if test="${param.id != null}">
	<b>${param.id}</b>
</c:if>
<c:if test="${param.id == null}">
	<b>Guest</b>
</c:if>
<c:choose>
	<c:when test="${param.color=='yellow'}">
		<c:set var="c" value="�����"/>
	</c:when>
	<c:when test="${param.color=='blue'}">
		<c:set var="c" value="�Ķ���"/>
	</c:when>
	<c:when test="${param.color=='orange'}">
		<c:set var="c" value="��������"/>
	</c:when>
	<c:when test="${param.color=='pink'}">
		<c:set var="c" value="��ũ��"/>
	</c:when>
	<c:otherwise>
		<c:set var="c" value="��"/>
	</c:otherwise>
</c:choose>
���� �����ϴ� ������ <font color="${param.color}">${c}</font> �Դϴ�.
</body>
</html>
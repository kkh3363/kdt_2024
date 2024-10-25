<%@page contentType="text/html;charset=EUC-KR"%>
<%@page import="java.util.Date" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<title>JSTL</title>
</head>
<body >
<h2>Formatting Tags3</h2>

<c:set var="dayTime" value="<%=new Date()%>"/>
<fmt:formatDate value="${dayTime}" type="date" dateStyle="full"/><br/>
<fmt:formatDate value="${dayTime}" type="time"/><p/>

<fmt:timeZone value="Europe/London">
Europe/London : <fmt:formatDate value="${dayTime}" type="both" dateStyle="full" timeStyle="full"/><br/>
</fmt:timeZone>

<fmt:setTimeZone value="America/New_York"/>
America/New_York : <fmt:formatDate value="${dayTime}" type="both" dateStyle="full" timeStyle="full"/><br/>
</body>
</html>
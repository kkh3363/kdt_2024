<%@page contentType="text/html;charset=EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<html>
<head>
<title>JSTL</title>
</head>
<body>
<h2>SQL Tags2</h2>
<sql:update dataSource="${db}"> 
	update tblMember set name=? where id=?
	<sql:param value="${'마시마로'}"/>
	<sql:param value="${'aaa'}"/>
</sql:update>
업데이트를 하였습니다.<br/>
<a href="sqlTags1.jsp">SELECT</a>
</body>
</html>
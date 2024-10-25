<%@page contentType="text/html;charset=EUC-KR"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<title>JSTL</title>
</head>
<body >
<h2>Formatting Tags1</h2>
<fmt:setLocale value="ko_kr"/>
<fmt:requestEncoding value="EUC-KR"/>
name : <%=request.getParameter("name")%><br/>
<form  method="post">
	name : <input name="name">
	<input type="submit">
</form>
</body>
</html>
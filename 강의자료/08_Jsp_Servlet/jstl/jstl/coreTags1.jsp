<%@page contentType="text/html;charset=EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	 String str1= "JAVA의 JSTL";	
	 String str2= null;	
%>
<html>
<head>
<title>JSTL</title>
</head>
<body>
<h2>Core Tags1</h2>
<c:set var="str3" value="JSPStudy" scope="page"/>
<c:set var="str4" value="JSTL" scope="session"/>
- <c:out value="<%=str1%>" default="기본출력값"/><br/>
- <c:out value="<%=str2%>" default="기본출력값"/><br/>
- <c:out value="${str3}" default="기본출력값"/><br/>
<c:remove var="str4"/>
- ${str3}의 ${str4} ...<p/>
<%String s = (String)pageContext.getAttribute("str3");%>
-<font color="red"><b><%=s%></b></font>
</body>
</html>
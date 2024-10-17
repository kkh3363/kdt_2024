<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
      String strTitle = "My Portal";
	  String cPath = request.getContextPath();

%>    

<html>
<head>
<meta charset="UTF-8">
<title><%=strTitle %></title>
<link href="<%=cPath%>/css/portalStyle.css" rel="stylesheet" type="text/css">
<link href="<%=cPath%>/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<jsp:include page="head_inc.jsp"/>


<jsp:include page="main.jsp"/>

<jsp:include page="footer_inc.jsp"/>
		
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>  
<% 
	String dir = "/filestorage";
	String dirName = request.getServletContext().getRealPath(dir);
	File files = new File(dirName);
	String[] fileNames = null;
	if ( files.exists()){
		fileNames = files.list();
	}
	
%>

<ul>
<% 
	for ( int i=0; i < fileNames.length; i++) {
		String strUrl;
		strUrl = request.getContextPath()+"/"+dir+"/"+ fileNames[i];
%>
	<li><a href='<%=strUrl%>'><%=fileNames[i] %></a></li>
<% } %>
</ul>
</body>
</html>

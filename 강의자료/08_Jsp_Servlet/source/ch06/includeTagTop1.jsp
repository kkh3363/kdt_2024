<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = request.getParameter("name");
%>
<hr>
include ActionTag의 Top입니다.
<p/>
<b><%=name%> Fighting!!!</b>
<br><br>
<hr>
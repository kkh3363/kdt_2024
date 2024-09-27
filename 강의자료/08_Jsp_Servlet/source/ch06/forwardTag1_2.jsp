<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
%>
<h1>Forward Tag Example1</h1>
당신의 아이디는<b><%=id%></b>이고<p/>
패스워드는 <b><%=pwd%></b> 입니다.
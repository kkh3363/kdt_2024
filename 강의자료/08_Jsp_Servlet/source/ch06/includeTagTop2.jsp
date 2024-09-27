<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	   String siteName = request.getParameter("siteName");
	String siteUrl = request.getParameter("siteUrl");
%>
<hr/>
include ActionTag의 Top입니다.<p/>
<%=siteName%> <br/>
<%=siteUrl%>
<hr/>
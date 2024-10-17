<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="mMgr" class="myPortal.db.MemberMgr"/> 
  
<%
	  request.setCharacterEncoding("UTF-8");
	  String id = request.getParameter("id");
	  String pwd = request.getParameter("pwd");
	  String url = "../index.jsp";
	  String msg = "로그인에 실패 하였습니다.";
	  
	  boolean result = mMgr.loginMember(id,pwd);
	  if(result){
	    session.setAttribute("idKey",id);
	    msg = "로그인에 성공 하였습니다.";
	  }
%>
<script>
<%  if (result == false) { %>
	alert("<%=msg%>");
<% } %>	
	location.href="<%=url%>";
</script>
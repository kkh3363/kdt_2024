<%@ page contentType="text/html; charset=EUC-KR" %>
<jsp:useBean id="mMgr" class="ch14.MemberMgr"/>
<%
	  request.setCharacterEncoding("EUC-KR");
	  String id = request.getParameter("id");
	  String pwd = request.getParameter("pwd");
	  String url = "login.jsp";
	  String msg = "로그인에 실패 하였습니다.";
	  
	  boolean result = mMgr.loginMember(id,pwd);
	  if(result){
	    session.setAttribute("idKey",id);
	    msg = "로그인에 성공 하였습니다.";
	  }
%>
<script>
	alert("<%=msg%>");	
	location.href="<%=url%>";
</script>
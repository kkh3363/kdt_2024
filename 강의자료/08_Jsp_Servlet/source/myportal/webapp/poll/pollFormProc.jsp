<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="pMgr" class="myPortal.poll.PollManager" />
<%
	request.setCharacterEncoding("UTF-8");
	int num = Integer.parseInt(request.getParameter("num"));
	if ( request.getParameter("num") == null || num < 0) {
%>   
<script type="text/javascript">
	alert("잘못된 접근입니다.");
	location.href="pollList.jsp";
</script> 
<% 	} %>
<% 
	String[] itemnum = request.getParameterValues("itemnum");

	boolean flag = pMgr.updatePoll(num, itemnum);
	String msg="투표가 등록되지 않습니다.";
	if ( flag ) {
		msg = "투표가 정상적으로 등록되었습니다.";
	} 
%>
<script type="text/javascript">
	alert("<%=msg%>");
	location.href="pollList.jsp";
</script> 



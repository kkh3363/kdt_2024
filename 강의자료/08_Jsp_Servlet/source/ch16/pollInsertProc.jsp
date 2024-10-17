<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>
<jsp:useBean id="pMgr" class="myPortal.poll.PollManager"/>
<jsp:useBean id="plBean" class="myPortal.poll.PollListBean"/>
<jsp:setProperty property="*" name="plBean"/>
<jsp:useBean id="piBean" class="myPortal.poll.PollItemBean"/>
<jsp:setProperty property="*" name="piBean"/>

<%
	boolean flag = pMgr.insertPoll(plBean,piBean);
	String msg = "설문 추가에 실패 하였습니다.";
	String url = "pollInsert.jsp";
	if(flag){
		msg = "설문이 추가 되었습니다.";
		url = "pollList.jsp";
	}
	
%>
<script>
   alert("<%=msg%>");
   location.href="<%=url%>";
</script>

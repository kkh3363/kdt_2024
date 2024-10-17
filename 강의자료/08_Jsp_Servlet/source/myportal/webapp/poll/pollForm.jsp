<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="myPortal.poll.*,java.util.Vector"%>
<jsp:useBean id="pMgr" class="myPortal.poll.PollManager"/>
<%
	  int num = 0;

	  if(!(request.getParameter("num")==null || request.getParameter("num").equals(""))){
		 num = Integer.parseInt(request.getParameter("num"));
	  }
	
	  PollListBean plBean = pMgr.getList(num);
	  Vector<String> vlist = pMgr.getItem(num);

	  String question = plBean.getQuestion();
	  int type = plBean.getType();
	  int active = plBean.getActive();
%>
<link href="<%=request.getContextPath()%>/css/pollstyle.css" rel="stylesheet" type="text/css">
<form method="post" action="pollFormProc.jsp">
<table class="table_form">
	<tr>
		<td colspan="2" class="table_form_question" >Q : <%=question%></td>
	</tr>
	<tr>
		<td colspan="2">
			<%
				for(int i=0; i<vlist.size(); i++){
					String itemList = vlist.get(i);
					if(type==1){
						out.println("<input type=checkbox name='itemnum' value='"+i+"'>");
					}else{
						out.println("<input type=radio name='itemnum' value='"+i+"'>");
					}
					out.println(itemList+"<br>");
				}//for end
			%>
		</td>
	</tr>
	<tr>
		<td colspan =2 class=td_center>
			<%
				if(active==1){
						out.println("<input type='submit' value='투표'>");
					}else{
						out.println("투표");
					}
			%>
		
		<input type="button" value="결과" 
		onclick="javascript:window.open('pollView.jsp?num=<%=num%>',
		               'PollView','width=500, height=350')">
		</td>
	</tr>
</table>
<input type="hidden" name="num" value="<%=num%>">
</form>

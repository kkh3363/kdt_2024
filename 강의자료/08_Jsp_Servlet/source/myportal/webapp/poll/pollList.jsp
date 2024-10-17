<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="myPortal.poll.*,java.util.Vector"%>    
<jsp:useBean id="pMgr" class="myPortal.poll.PollManager" />
 <%
 	String cPath = request.getContextPath();
	  Vector<PollListBean> vlist = pMgr.getAllList();
	  int count = vlist.size();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>설문 리스트</title>
<link href="<%=cPath%>/css/portalStyle.css" rel="stylesheet" type="text/css">
<link href="<%=cPath%>/css/pollstyle.css" rel="stylesheet" type="text/css">
</head>
<body>

<jsp:include page="../head_inc.jsp"/>


<div class="poll_container">
	<table class=table_title >
		<tr>
			<td ><h2>투표 프로그램</h2></td>
		</tr>
	</table>
	
	<!--  -->
	<% if (pMgr.getMaxNum() > 0 ) {%>
	<jsp:include page="pollForm.jsp" />
	<% } %>
<!--  설문 목록 보기 -->
	<table class="table_list">
		<thead>
			<tr>
				<th width=100 class="td_center">번호</th>
				<th class="td_center">제목</th>
				<th width=250 class="td_center">시작일~종료일</th>
			</tr>
		</thead>
		<tbody>
		<% 
			int nCount=1;
			for( PollListBean listItem: vlist) { %>
			<tr>
				<td class=td_center> <%=nCount++ %></td>
				<td> <a href='pollList.jsp?num=<%=listItem.getNum()%>'><%= listItem.getQuestion() %></a></td>
				<td class=td_center> <%=listItem.getSdate() %> ~ <%=listItem.getEdate() %></td>
			</tr>
		<% } %>
			<tr>
				
			</tr>
		</tbody>
	</table>
	
<!--  설문 추가 -->	
	<table class=table_bottom>
	<tr>
		<td class="td_right"><a href="pollInsert.jsp">설문 작성하기</a></td>
	</tr>
	</table>
</div>

<jsp:include page="../footer_inc.jsp"/>

</body>
</html>
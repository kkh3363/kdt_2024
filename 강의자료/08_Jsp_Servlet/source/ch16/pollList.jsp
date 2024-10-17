<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="myPortal.poll.*,java.util.Vector"%>    
<jsp:useBean id="pMgr" class="myPortal.poll.PollManager" />
 <%
	  Vector<PollListBean> vlist = pMgr.getAllList();
	  int count = vlist.size();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>설문 리스트</title>
<link href="<%=request.getContextPath()%>/css/pollstyle.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="container">

	<h2>투표프로그램</h2>
	<!--  -->
	<jsp:include page="pollForm.jsp" />
<!--  설문 목록 보기 -->
	<table class="table_list">
		<thead>
			<tr>
				<th width=100 >번호</th>
				<th>제목</th>
				<th width=200>시작일~종료일</th>
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
</body>
</html>
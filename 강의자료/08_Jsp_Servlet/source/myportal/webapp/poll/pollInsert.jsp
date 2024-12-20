<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String strTitle = "My Portal";
	String cPath = request.getContextPath();
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>설문 추가</title>
<link href="<%=cPath%>/css/portalStyle.css" rel="stylesheet" type="text/css">
<link href="<%=cPath%>/css/pollstyle.css" rel="stylesheet" type="text/css">
</head>
<body>
<jsp:include page="../head_inc.jsp"/>

<div class="poll_container">
	<table class=table_title >
		<tr>
			<td class=td_title>질문 작성</td>
		</tr>
	</table>
	<form method="post" action="pollInsertProc.jsp">
	<table class=table_content>
		<tr>
			<td colspan=4> <hr></td>
		</tr>
		<tr>
			<th >질문</th>
			<td colspan=3><input name="question" size="50"></td>
		</tr>
		<tr>
			<th class="td_center" colspan=4 >항목</th>
		</tr>
		<% for (int i=1; i <=4 ; i++) {%>
		<tr>
			<th><%=i*2-1 %>:</th>
			<td><input type=text name="item"></td>
			<th><%=i*2  %> :</th>
			<td><input type=text name="item"></td>
		</tr>
		<% } // for %>
		<tr>
			<th width=100> 시작일</th>
			<td  >
				<input type="date" id='sdate' name='sdate' value="2024-10-17" min=2024-01-01" max='2026-12-31' />
			</td> 
			<th width=100> 종료일</th>
			<td >
				<input type="date" id='eate' name='edate' value="2024-10-17" min=2024-01-01" max='2026-12-31' />
			</td> 
		</tr>
		<tr>
			<th> 복수 투표</th>
			<td colspan=3>
				<input type="radio" name="type" value="1" checked>yes 
				<input type="radio" name="type" value="0">no
			</td> 
		</tr>
		<tr>
			<td colspan=4> <hr></td>
		</tr>
		<tr>
			<td class=td_center colspan=4>
				<input type="submit" value="작성하기"> 
				<input type="reset" value="다시쓰기"> 
				<input type="button" value="리스트" onClick="javascript:location.href='pollList.jsp'">
			</td>
		</tr>
	</table>
	</form>
</div>

<jsp:include page="../footer_inc.jsp"/>
</body>
</html>
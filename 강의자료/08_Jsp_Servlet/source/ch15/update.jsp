<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="myPortal.bbs.BoardBean" %>
   
<%
	if (request.getParameter("num") == null || request.getParameter("num") == "" ) {
%>    
<script type="text/javascript">
	alert("존재하지 않는 게시물 입니다.");
	location.href = "list.jsp";
</script>
<% } %> 
<%
	System.out.println(request.getParameter("num") );
	//int num = Integer.parseInt(request.getParameter("num"));
	int num= 8;
	String nowPage = request.getParameter("nowPage");
	BoardBean bean = (BoardBean)session.getAttribute("bean");
	String subject = bean.getSubject();
	String name = bean.getName(); 
	String content = bean.getContent();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
<link href="<%=request.getContextPath()%>/css/bbsStyle.css" rel="stylesheet" type="text/css">
<script>
	function check() {
	   if (document.updateFrm.pass.value == "") {
		 alert("수정을 위해 패스워드를 입력하세요.");
		 document.updateFrm.pass.focus();
		 return false;
		 }
	   document.updateFrm.submit();
	}
</script>
</head>
<body>
<div class=container>
	<table >
		<tr>
			<td class=td_title>글 수정</td>
		</tr>
	</table>
	<form name="updateFrm" method="post" action="boardUpdate">
	<table  >
	<tr>
		<th width=100>성 명</th>
			<td ><input name="name" size="10" maxlength="8" value="<%=name%>"></td>
		</tr>
		<tr>
			<th>제 목</th>
			<td><input name="subject" size="50" maxlength="30" value="<%=subject%>"> </td>
		</tr>
		<tr>
			<th>내 용</th>
			<td><textarea name="content" rows="10" cols="50"><%=content%></textarea></td>
		</tr>
		<tr>
			<th>비밀 번호</th>
			<td><input type="password" name="pass" size="15" maxlength="15">
			수정 시에는 비밀번호가 필요합니다.
			</td>
		</tr>
		
		</table>
		<hr/>
		<div class=div_submit>
			 <input type="submit" value="수정 완료" onClick="check()">
			 <input type="reset" value="다시수정">
			 <input type="button" value="뒤로" onClick="history.go(-1)">
		</div>
		<input type="hidden" name="nowPage" value="<%=nowPage %>">
 		<input type='hidden' name="num" value="<%=num%>">
	</form>
</div>


</body>
</html>

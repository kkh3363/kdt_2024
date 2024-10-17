<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="myPortal.bbs.BoardBean" %>
   
<%
	String cPath = request.getContextPath();
	if (request.getParameter("num") == null || request.getParameter("num") == "" ) {
%>    
<script type="text/javascript">
	alert("존재하지 않는 게시물 입니다.");
	location.href = "list.jsp";
</script>
<% } %> 
<%
	System.out.println(request.getParameter("num") );
	int num = Integer.parseInt(request.getParameter("num"));
	//int num= 8;
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
<link href="<%=cPath%>/css/portalStyle.css" rel="stylesheet" type="text/css">
<link href="<%=cPath%>/css/bbsstyle.css" rel="stylesheet" type="text/css">
<script>
function check() {
	frm = document.updateFrm;
	if ( frm.name.value == "" ){
		alert("이름을 입력해 주세요.");
		frm.name.value.focus();
		return;
	}
	if ( frm.subject.value == "" ){
		alert("제목을 입력해 주세요.");
		frm.subject.focus();
		return;
	}
	if (frm.pass.value == "") {
 		alert("수정을 위해 패스워드를 입력하세요.");
 		frm.pass.focus();
 		return false;
	}
	document.updateFrm.submit();
}
</script>
</head>
<body>
<jsp:include page="../head_inc.jsp"/>

<div class="bbs_container">
	<table class=table_title>
		<tr>
			<td ><h2>글수정</h2></td>
		</tr>
	</table>
	<form name="updateFrm" method="post" action="boardUpdate">
	<table class=bbs_write_table  >
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
			 <input type="button" value="수정 완료" onClick="check()">
			 <input type="reset" value="다시수정">
			 <input type="button" value="뒤로" onClick="history.go(-1)">
		</div>
		<input type="hidden" name="nowPage" value="<%=nowPage %>">
 		<input type='hidden' name="num" value="<%=num%>">
	</form>
</div>
<jsp:include page="../footer_inc.jsp"/>

</body>
</html>
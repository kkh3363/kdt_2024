<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="myPortal.bbs.BoardBean"%>    
<jsp:useBean id="bMgr" class="myPortal.bbs.BoardManager" /> 
<%
	String cPath = request.getContextPath();
%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 삭제</title>
<link href="<%=cPath%>/css/portalStyle.css" rel="stylesheet" type="text/css">
<link href="<%=cPath%>/css/bbsstyle.css" rel="stylesheet" type="text/css">
<%
	request.setCharacterEncoding("UTF-8");
	String nowPage = request.getParameter("nowPage");
	int num = Integer.parseInt(request.getParameter("num"));
	if (request.getParameter("pass") != null) {
		String inPass = request.getParameter("pass");
		BoardBean bean = (BoardBean) session.getAttribute("bean");
		String dbPass = bean.getPass();
		if (inPass.equals(dbPass)) {
			bMgr.deleteBoard(num);
			String url = "list.jsp?nowPage=" + nowPage;
			response.sendRedirect(url);
		} else {
%>
<script type="text/javascript">
	alert("입력하신 비밀번호가 아닙니다.");
	history.back();
</script>
<% 		} %>
<% 	} else { %>
<script type="text/javascript">
	function check() {
		if (document.delFrm.pass.value == "") {
			alert("패스워드를 입력하세요.");
			document.delFrm.pass.focus();
			return false;
		}
		document.delFrm.submit();
	}
</script>
</head>
<body>
<jsp:include page="../head_inc.jsp"/>

<div class="bbs_container">
	<table class=table_title>
		<tr>
			<td ><h2>글삭제</h2></td>
		</tr>
	</table>
	<form name="delFrm" method="post" action="delete.jsp">
	<table class=bbs_read_table>
	<tr>
		<td  class="td_center">
			<input type="password" name="pass" size="17" maxlength="15">
		</td>
	</tr>
	</table>

	<div class=div_submit>
			<input type="button" value="삭제완료" onClick="check()"> 
			<input type="reset" value="다시쓰기">
			<input type="button" value="뒤로" onClick="history.go(-1)">
	</div>

	
	<input type="hidden" name="nowPage" value="<%=nowPage%>"> 
	<input type="hidden" name="num" value="<%=num%>">
	</form>
</div>
<% } // if  %>
<jsp:include page="../footer_inc.jsp"/>
</body>
</html>






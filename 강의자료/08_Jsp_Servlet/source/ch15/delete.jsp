<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="myPortal.bbs.BoardBean"%>    
<jsp:useBean id="bMgr" class="myPortal.bbs.BoardManager" />    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 삭제</title>
<link href="<%=request.getContextPath()%>/css/bbsStyle.css" rel="stylesheet" type="text/css">
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
<div class="container">
	<table >
		<tr>
			<td class=td_title>글 삭제</td>
		</tr>
	</table>
	<form name="delFrm" method="post" action="delete.jsp">
	<table width=600 border=1>
		<tr>
			<td  class="td_center">
				<input type="password" name="pass" size="17" maxlength="15">
			</td>
		</tr>
		
		<tr>
			<td  class="td_center">
				<input type="button" value="삭제완료" onClick="check()"> 
				<input type="reset" value="다시쓰기">
				<input type="button" value="뒤로" onClick="history.go(-1)">
			</td>
		</tr>
	</table>
	<input type="hidden" name="nowPage" value="<%=nowPage%>"> 
	<input type="hidden" name="num" value="<%=num%>">
	</form>
</div>
<% } // if  %>
</body>
</html>






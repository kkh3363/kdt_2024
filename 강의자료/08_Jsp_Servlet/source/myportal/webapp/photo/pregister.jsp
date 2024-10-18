<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
		String msg = (String)session.getAttribute("msg");
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
	<%@include file="js_css.html" %>
	<script type="text/javascript">
 		function register() {
			frm = document.frm;
			if ( frm.id.value == ""){
				alert("아이디를 입려가시오");
				frm.id.focus();
				return;
			}
			if ( frm.pwd.value == ""){
				alert("아이디를 입려가시오");
				frm.pwd.focus();
				return;
			}
			document.frm.submit();
		}
 	</script>
</head>
<body>
<div data-role="page">
	<div data-role="header">
		<table>
			<tr>
				<td align="left" width="200">
					<h1 style="font-family: fantasy;" align="left">&nbsp;&nbsp;PhotoBlog</h1>
				</td>
			</tr>
		</table>
	</div> <!-- header -->
	
	<div data-role="content">
		<h1>PMember Register</h1>
		<form method="post" name="frm" action="pmemberPost" enctype="multipart/form-data" class="post_form">
		<p><label for="user_id">아이디: <input name="id"></label></p>
		<p><label for="user_password">비밀번호:<input type="password" name="pwd"></label></p>
		<p><label for="user_name">이름: <input name="name"></label></p>
		<p><label for="user_profile">프로필 사진:<input type="file" name="profile"></label></p>
		<input type="button"  value="회원가입" onclick="register()">
		<%if(msg!=null){%>
			<div align="center"><font color="red"><%=msg%></font></div>
		<%}%>
		</form>
	</div> <!-- content -->
	
	<%@include file="footer.jsp" %>
</div> <!-- page -->
</body>
</html>

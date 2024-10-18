
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="bean" class="myPortal.photo.PMemberBean" scope="session"/>
<%
	request.setCharacterEncoding("UTF-8");
	String cPath = request.getContextPath();

	String id = (String)session.getAttribute("idKey");
	String msg = (String)session.getAttribute("msg");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PhotoBlog</title>
	<%@include file="js_css.html" %>
	<script type="text/javascript">
 		function login() {
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
					<h1 style="font-family: fantasy;" align="left">&nbsp;&nbsp;PhotoBlog</h1></td>
			</tr>
		</table>
	</div> <!-- header -->
	
	<div data-role="content">
<% if ( id == null) { %>
		<h1>LOGIN</h1>
		<form method="post" name="frm" action="pmemberLogin">
			<p><label for="user_id">아이디: <input name="id"> </label> </p>
            <p> <label for="user_password">비밀번호:<input type="password" name="pwd"></label></p>
             <input type="button"  value="로그인" onclick="login()">
             <input type="button"  value="회원가입" onclick="location.href='pregister.jsp'">
         </form>
         <%if(msg!=null){%>
			<div align="center"><font color="red"><%=msg%></font></div>
		<%}%>
		</div> <!-- content -->
<% } else { %>  <!--  로그인 상태... -->
		<div class="post_form">
		<table>
			<tr>
				<td width="200" align="center"><%=bean.getName()%>님 반갑습니다.<p></td>
				<td >
					<div class="box" style="background: #BDBDBD;">
			<img  align="bottom" class="profile" src="<%=cPath %>/photo_files/<%=bean.getProfile()%>" width="200" height="200">
				</div></td>
			</tr>
			<tr>
				<td colspan="2">
				    <a href="#" onclick="location.href='pupdate.jsp'">회원수정</a>&nbsp;&nbsp;
					<a href="#" onclick="location.href='logout.jsp'">로그아웃</a>&nbsp;&nbsp;
				   <a href="#" onclick="alert('준비중입니다');">포토블로그</a>
				 </td>
			</tr>
		</table>
		</div>
<% } %>

	<%@include file="footer.jsp" %>
	
</div> <!-- page -->
</body>
</html>

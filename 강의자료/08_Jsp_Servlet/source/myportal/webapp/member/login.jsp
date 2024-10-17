<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	  request.setCharacterEncoding("UTF-8");
	  String id = (String)session.getAttribute("idKey");
	  String cPath = request.getContextPath();
%>    


<script type="text/javascript">
	function loginCheck() {
		if (document.loginFrm.id.value == "") {
			alert("아이디를 입력해 주세요.");
			document.loginFrm.id.focus();
			return;
		}
		if (document.loginFrm.pwd.value == "") {
			alert("비밀번호를 입력해 주세요.");
			document.loginFrm.pwd.focus();
			return;
		}
		document.loginFrm.submit();
	}
</script>

<div class="login_wrap">
<br><br>
<%if (id != null) {%>
	<table width=100%>
	<tr>
		<td><b><%=id%></b>님 환영 합니다.</td>
	</tr>
	<tr>
		<td>제한된 기능을 사용 할 수가 있습니다.</td>
	</tr>
	<tr>
		<td class="td_center"><a href="<%=cPath %>/member/logout.jsp">로그아웃</a></td>
	</tr>
	</table>
	

	<!--  span ><a href="<%=cPath %>/member/memberUpdate.jsp">회원 정보수정</a></span -->
	<%} else {%>
	<form name="loginFrm" method="post" action="<%=cPath %>/member/loginProc.jsp">
	<table class="table_login">
		<tr>
			<th colspan="2"><h4>로그인</h4></th>
		</tr>
		<tr>
			<td width=70>아 이 디</td>
			<td class="td_left"><input name="id" size=10></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td class="td_left"><input type="password" name="pwd" size=10></td>
		</tr>
		<tr>
			<td colspan="2"> <hr>	</td>
		</tr>
		<tr>
			<td colspan="2">
				<div align="center">
					<input type="button" value="로그인" onclick="loginCheck()" size=20>&nbsp;
					<!-- input type="button" value="회원가입" onClick="javascript:location.href='<%=cPath %>/member/member.jsp'" -->
				</div>
			</td>
		</tr>
	</table>
	</form>
	<%}%>
	<br>
	<br>
	<br>
</div>


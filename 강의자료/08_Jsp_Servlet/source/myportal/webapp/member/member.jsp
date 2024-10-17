<!--  회원 가입 폼 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 	String cPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link href="<%=cPath%>/css/portalStyle.css" rel="stylesheet" type="text/css">
<link href="<%=cPath%>/css/style.css" rel="stylesheet"  type="text/css" >
<script  src="<%=cPath%>/js/script.js" ></script>
<script  type="text/javascript" >
	function idCheck(id) {
		frm = document.regFrm;
		if (id == "") {
			alert("아이디를 입력해 주세요.");
			frm.id.focus();
			return;
		}
		url = "<%=cPath%>/member/idCheck.jsp?id=" + id;
		
		window.open(url, "IDCheck", "width=300,height=150");
	}
	function zipSearch() {
		url = "zipSearch.jsp?search=n";
		window.open(url, "ZipCodeSearch","width=500,height=300,scrollbars=yes");
	}
</script>

</head>
<body >
<jsp:include page="../head_inc.jsp"/>


<div class="member_container">
	<table class=table_title >
		<tr>
			<td ><h2>회원 가입</h2></td>
		</tr>
	</table>
	<form name="regFrm" method="post" action="<%=cPath%>/member/memberProc.jsp">
	<table class="member_ins_form">
	<tr>
		<th width="20%">아이디</th>
		<td width="50%">
			<input name="id" size="15"> 
			<input type="button" value="ID중복확인" onclick="idCheck(this.form.id.value)">
		</td>
		<td width="30%">아이디를 적어 주세요.</td>
	</tr>
	<tr>
		<th>패스워드</th>
		<td><input type="password" name="pwd" size="15"></td>
		<td>패스워드를 적어주세요.</td>
	</tr>
	<tr>
		<th>패스워드 확인</th>
		<td><input type="password" name="repwd" size="15"></td>
		<td>패스워드를 확인합니다.</td>
	</tr>
	<tr>
		<th>이름</th>
		<td><input name="name" size="15">
		</td>
		<td>이름을 적어주세요.</td>
	</tr>
	<tr>
		<th>성별</th>
		<td>
			남<input type="radio" name="gender" value="1" checked> 
			여<input type="radio" name="gender" value="2">
		</td>
		<td>성별을 선택 하세요.</td>
	</tr>
	<tr>
		<th>생년월일</th>
		<td><input name="birthday" size="6">
			ex)830815</td>
		<td>생년월일를 적어 주세요.</td>
	</tr>
	<tr>
		<th>Email</th>
		<td><input name="email" size="30">
		</td>
		<td>이메일를 적어 주세요.</td>
	</tr>
	<tr>
		<th>우편번호</th>
		<td><input name="zipcode" size="5" readonly>
			<input type="button" value="우편번호찾기" onClick="zipSearch()">
		</td>
		<td>우편번호를 검색하세요.</td>
	</tr>
	<tr>
		<th>주소</th>
		<td><input name="address" size="45"></td>
		<td>주소를 적어 주세요.</td>
	</tr>
	<tr>
		<th>취미</th>
		<td>인터넷<input type="checkbox" name="hobby" value="인터넷">
			여행<input type="checkbox" name="hobby" value="여행"> 게임<input
			type="checkbox" name="hobby" value="게임"> 영화<input
			type="checkbox" name="hobby" value="영화"> 운동<input
			type="checkbox" name="hobby" value="운동">
		</td>
		<td>취미를 선택 하세요.</td>
	</tr>
	<tr>
		<th>직업</th>
		<td><select name=job>
				<option value="0" selected>선택하세요.
				<option value="회사원">회사원
				<option value="연구전문직">연구전문직
				<option value="교수학생">교수학생
				<option value="일반자영업">일반자영업
				<option value="공무원">공무원
				<option value="의료인">의료인
				<option value="법조인">법조인
				<option value="종교,언론,에술인">종교.언론/예술인
				<option value="농,축,수산,광업인">농/축/수산/광업인
				<option value="주부">주부
				<option value="무직">무직
				<option value="기타">기타
		</select></td>
		<td>직업을 선택 하세요.</td>
	</tr>
	</table>
	<br>
	<table width=100%>
	
	<tr>
		<td class="td_center">
		   <input type="button" value="회원가입" onclick="inputCheck()">
		    &nbsp; &nbsp; 
		    <input type="reset" value="다시쓰기">
		   
		 </td>
	</tr>
	</table>
	</form>
</div> <!-- member_container  -->
	
<jsp:include page="../footer_inc.jsp"/>
</body>
</html>
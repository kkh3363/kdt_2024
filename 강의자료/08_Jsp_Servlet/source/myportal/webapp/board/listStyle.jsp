<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>보드 목록</title>
<link href="<%=request.getContextPath()%>/css/boardStyle.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="container">
<%@ include file="common_head.jsp" %>
<h1>Jsp Board</h1>
	<table >
	<tbody>
	<tr>
			<td> Total:  100 Articles( 1/ 10) pages</td>
		</tr>
	</tbody>
		
	</table>
	<table   >
	<tbody>
		<tr>
			<td align=center colspan=2>
<!--  리스트 제목 -->
			<table width=100% cellpadding=2 cellspacing = 0>
				<tr >
					<th>번호 </th>
					<th>제목 </th>
					<th>작성자 </th>
					<th>작성일 </th>
					<th>조회수 </th>
				</tr>
<!--  리스트 내용 -->				
				<tr>
					<td>1001 </td>
					<td>jsp 보드 테스트 </td>
					<td>홍길동 </td>
					<td>2024-10-11 </td>
					<td>20 </td>
				</tr>
			</table>
			</td>
		</tr>
		<tr>
			<td colspan=2> <br><br></td>
		</tr>
		<!--  페이지 -->
		<tr>
			<td>
			[<a href="#">1</a>][2][3][4][5]
			</td>
			<td>
				<a href="#">[글쓰기]</a> 
				<a href="#">[리스트]</a>
			</td>
		</tr>
	</tbody>	
	</table>
<!--  찾기 폼 -->	
	<form name=searchForm >
	<table  >
	<tr>
		<td> 
			<select name="keyField" size="1" >
  				<option value="name"> 이 름</option>
  				<option value="subject"> 제 목</option>
  				<option value="content"> 내 용</option>
			</select>
			<input type=tex size="16" name="keyWord">
			<input type="button"  value="찾기" >
		</td>
	</tr>
	</table>	
	</form>
</div>
</body>
</html>
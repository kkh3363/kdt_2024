<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>설문 리스트</title>
<link href="<%=request.getContextPath()%>/css/pollstyle.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="container">

	<h2>투표프로그램</h2>
<!--  설문 목록 보기 -->
	<table class="table_list">
		<thead>
			<tr>
				<th width=100 >번호</th>
				<th>제목</th>
				<th width=200>시작일~종료일</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td class=td_center> 1</td>
				<td> 좋아하는 과일은?</td>
				<td class=td_center> 6.20 ~ 7.20</td>
			</tr>
		</tbody>
	</table>
	
<!--  설문 추가 -->	
	<table class=table_list>
	<tr>
		<td class="td_right"><a href="pollInsert.jsp">설문 작성하기</a></td>
	</tr>
	</table>
</div>
</body>
</html>

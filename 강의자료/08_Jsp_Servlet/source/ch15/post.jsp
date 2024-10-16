<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
<link href="<%=request.getContextPath()%>/css/bbsStyle.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
</script>
</head>
<body>
<div class=container>
	<table >
		<tr>
			<td class=td_title>글쓰기</td>
		</tr>
	</table>
	<form name="postFrm" method="post" action="boardPost" enctype="multipart/form-data">
	<table  >
	<tr>
		<th width=100>성 명</th>
			<td ><input name="name" size="10" maxlength="8"></td>
		</tr>
		<tr>
			<th>제 목</th>
			<td><input name="subject" size="50" maxlength="30"></td>
		</tr>
		<tr>
			<th>내 용</th>
			<td><textarea name="content" rows="10" cols="50"></textarea></td>
		</tr>
		<tr>
			<th>비밀 번호</th>
			<td><input type="password" name="pass" size="15" maxlength="15"></td>
		</tr>
		<tr>
		 <tr>
    			<th>파일찾기</th> 
    			<td><input type="file" name="filename" size="50" maxlength="50"></td>
   		</tr>
		<tr>
			<th>내용타입</th>
			<td> 
			<input id=contentTypeHtml type=radio name="contentType" value="HTTP" >
			<label for=contentTypeHtml >HTML</label>&nbsp;&nbsp;&nbsp;
			 	<input id=contentTypeText type=radio name="contentType" value="TEXT" checked>
			 	<label for=contentTypeText >TEXT</label>
			 	</td>
		</tr>
		</table>
		<hr/>
		<div class=div_submit>
			 <input type="submit" value="등록">
			 <input type="reset" value="다시쓰기">
			 <input type="button" value="리스트" onClick="javascript:location.href='list.jsp'">
		</div>
		<input type=hidden name="ip" value='<%=request.getRemoteAddr() %>'>
	</form>
</div>


</body>
</html>

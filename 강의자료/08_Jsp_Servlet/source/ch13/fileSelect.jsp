<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드..</title>
</head>
<body>
<form name="frmName" method="post" enctype="multipart/form-data" action="viewPage.jsp">
<table border=0 width=500>
	<tr>
		<td width=100 >user :</td><td><input name="user"></td> 
	</tr>
	<tr>
		<td>title :</td><td><input name="title"></td> 
	</tr>
	<tr>
		<td>file :</td><td><input type="file" name="uploadFile"></td> 
	</tr>
	<tr>
		<td colsapn=2><input type="submit" value="Upload"></td> 
	</tr>
</table>

</form>
</body>
</html>

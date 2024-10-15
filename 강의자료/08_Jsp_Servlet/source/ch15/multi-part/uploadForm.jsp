<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div style="text-align:center">
<h2>파일 업로드</h2>
    <form action="fileupload2" method="post" enctype="multipart/form-data">
		<input type="file" name="upload_file" />
		<input type="submit" value="저장" />
	</form>
</div>	
</body>
</html>

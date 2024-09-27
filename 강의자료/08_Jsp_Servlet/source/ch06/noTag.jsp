<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h1>Script Example</h1>
 <%!
 	public int max(int i, int j ){
		return (i>j)? i: j;
 	}
 %>
 <% 
 	int i=10, j=20;
  %>
  i = <%=i %> 와 j=<%=j %> 중에서 큰수는 <%=max(i,j) %> 입니다.
</body>
</html>
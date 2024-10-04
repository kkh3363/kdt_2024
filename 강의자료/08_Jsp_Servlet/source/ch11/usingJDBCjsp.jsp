<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%> 
   
<%
	String url = "jdbc:mysql://localhost/jspdb?serverTimezone=Asia/Seoul";
	String dbUser = "jspuser";
	String dbPasswd = "12345678";
	String msg="";
	Statement stmt = null;
	ResultSet rs = null;
	Connection conn =null;
	String strQuery;
	String id = "",pwd = "",name = "",num1 = "",num2 = "",email = "", phone = "",zipcode = ""; 
	String address = "", job = "";
	int counter = 0;
	
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(url, dbUser, dbPasswd);
		msg = "Success";
	}
	catch(SQLException ex){ msg = "SQLException" + ex;}
	catch(Exception ex){ msg = "Exception :" + ex;}
	
	strQuery = "select * from tblRegister";
	stmt = conn.createStatement();
	rs = stmt.executeQuery(strQuery);
%>    
<!DOCTYPE html>
<html><head><meta charset="UTF-8"><title>Insert title here</title></head>
<body>
<h2>JSP 스크립틀릿에서 데이터베이스 연동 예제</h2><br/>
<h3>회원정보</h3>
<table bordercolor="#0000ff" border="1">
	<tr>
		<td><strong>ID</strong></td>
		<td><strong>PWD</strong></td>
		<td><strong>NAME</strong></td>
		<td><strong>NUM1</strong></td>
		<td><strong>NUM2</strong></td>
		<td><strong>EMAIL</strong></td>
		<td><strong>PHONE</strong></td>
		<td><strong>ZIPCODE/ADDRESS</strong></td>
		<td><strong>JOB</strong></td>
	</tr>
	<% if (rs != null) { %>
	<% 		while( rs.next()){ 
				id = rs.getString("id");
				pwd = rs.getString("pwd");
				name = rs.getString("name");
				num1 = rs.getString("num1");
				num2 = rs.getString("num2");
				email = rs.getString("email");
				phone = rs.getString("phone");
				zipcode = rs.getString("zipcode");
				address = rs.getString("address");
				job = rs.getString("job");
	%>
	<tr>
		<td><%=id%></td>
		<td><%=pwd%></td>
		<td><%=name%></td>
		<td><%=num1%></td>
		<td><%=num2%></td>
		<td><%=email%></td>
		<td><%=phone%></td>
		<td><%=zipcode%>/<%=address%></td>
		<td><%=job%></td>
	</tr>
	<% 		counter++;
		} // end of while %>
	<% } // end of if %>
</table>
<br/>
total records :<%=counter%>
<%
	if (rs != null )
		rs.close();
	if ( stmt !=null)
		stmt.close();
	if (conn != null )
		conn.close();
	%>
</body>
</html>

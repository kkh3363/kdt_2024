<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, ch11.*"%> 
<jsp:useBean id="regMgr" class="ch11.RegisterManager"/>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>등록 멤버 리스트</title>
</head>
<body>

<h2>Bean를 사용한 데이터베이스 연동 예제</h2><br/>
<h3>회원정보</h3>
<table bordercolor="#0000ff" border="1">
<tr>
   <td><strong>ID</strong></td>
   <td><strong>PASSWD</strong></td>
   <td><strong>NAME</strong></td>
   <td><strong>NUM1</strong></td>
   <td><strong>NUM2</strong></td>
   <td><strong>EMAIL</strong></td>
   <td><strong>PHONE</strong></td>
   <td><strong>ZIPCODE/ADDRESS</strong></td>
   <td><strong>JOB</strong></td>	
</tr>
<!-- 빈을 불러 와서 출력하는 부분.... -->
<%
	Vector<RegisterBean> vlist = regMgr.getRegisterList();
	int counter = vlist.size();
	for(int i=0; i<vlist.size(); i++){
   		RegisterBean regBean = vlist.get(i);
%>
<tr>
	<td><%=regBean.getId()%></td>
	<td><%=regBean.getPwd()%></td>
	<td><%=regBean.getName()%></td>
	<td><%=regBean.getNum1()%></td>
	<td><%=regBean.getNum2()%></td>
	<td><%=regBean.getEmail()%></td>
	<td><%=regBean.getPhone()%></td>
	<td><%=regBean.getZipcode()%>/<%=regBean.getAddress()%></td>
	<td><%=regBean.getJob()%></td>
</tr>
<% 	} // end of for %>
</table>
<br/><br/>
total records : <%= counter %> 

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String strNum1= request.getParameter("number1");
	String strNum2= request.getParameter("number1");
	String opcode= request.getParameter("opcode");
	String strResult = "";
	
	int result =0;
	if ( strNum1 == null)
		strNum1="";
	if ( strNum2 == null)
		strNum2="";
	if ( strNum1.isBlank() == false && strNum2.isBlank() == false ){
		int n1 = Integer.parseInt(strNum1);
		int n2 = Integer.parseInt(strNum2);
		if ( opcode.equals("add")){
			result = n1 + n2;
			strResult = result + "";
		}
		else if ( opcode.equals("sub")){
			result = n1 - n2;
			strResult = result + "";
		}
			
		
	}
	
%>
<form action=calculator.jsp>
<table>
	<tr>
		<td><input id="number" name="number1" value="<%=strNum1 %>"></td>
		<td>
			<select name="opcode">
		        <option value="add" selected>+</option>
		        <option value="sub">-</option>
		    </select>
		</td>
		<td><input id="number" name="number2" value="<%=strNum1 %>"></td>
		
	</tr>
	
	<tr>
		<td colspan=3><input type="submit" value="보내기"> 
		</td>
	</tr>
	<tr>
		<td colspan=3>
		<%
			if (strResult.isBlank() == false){
		%>
			결과는 <%=strResult %>
		<%		
			}
		%>
		</td>
	</tr>
</table>
</form>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="bean" class="myPortal.bbs.BoardBean" scope="session"/> 
<%
	  String nowPage = request.getParameter("nowPage");
	  String subject = bean.getSubject();
	  String content = bean.getContent(); 
%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>답변글 작성</title>
<link href="<%=request.getContextPath()%>/css/bbsStyle.css" rel="stylesheet" type="text/css">

</head>
<body>
<div class=container>
	<table >
		<tr>
			<td class=td_title>답글 작성</td>
		</tr>
	</table>
	
	<form name="postFrm" method="post" action="boardReply">
	<table  >
	<tr>
		<th width="100">성 명</th>
		<td  ><input name="name" size="10" maxlength="8"></td>
	</tr>
	<tr>
		<th>제 목</th>
		<td><input name="subject" size="50" maxlength="30" value="답변 : <%=subject%>"></td>
	</tr>
	<tr>
		<th>내 용</th>
		<td style="text-align:left" ><textarea name="content" rows="10" cols="50"  >
		<%=content %>
      	========답변 글을 쓰세요.=======
		</textarea></td>
	</tr>
	<tr>
		<th>비밀 번호</th>
		<td><input type="password" name="pass" size="15" maxlength="15"></td>
	</tr>
	<tr>
		<td  colspan=2 class="td_center">
			 <input type="submit" value="답변등록">
			 <input type="reset" value="다시쓰기">
			 <input type="button" value="뒤로" onClick="javascript:location.href='list.jsp'">
		</td>
	</tr>
	</table>
	<input type="hidden" name="ip" value="<%=request.getRemoteAddr()%>" >
 <input type="hidden" name="nowPage" value="<%=nowPage%>">
 <input type="hidden" name="ref" value="<%=bean.getRef()%>">
 <input type="hidden" name="pos" value="<%=bean.getPos()%>">
 <input type="hidden" name="depth" value="<%=bean.getDepth()%>">
	</form>
</div>


</body>
</html>
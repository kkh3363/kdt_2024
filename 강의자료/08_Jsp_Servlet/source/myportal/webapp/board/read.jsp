<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="myPortal.bbs.BoardBean" %>
<jsp:useBean id="bMgr" class="myPortal.bbs.BoardManager" />
<%
	request.setCharacterEncoding("UTF-8");
	String cPath = request.getContextPath();
	int num = Integer.parseInt(request.getParameter("num"));
	String nowPage = request.getParameter("nowPage");
	String keyField = request.getParameter("keyField");
	String keyWord = request.getParameter("keyWord");
	
	if ( bMgr.upCount(num) < 0  ){ //조회수 증가
%>
<script>
	alert("잘못된 접근 입니다." +<%=bMgr.upCount(num)%>);
	location.href="list.jsp";
</script>
<%		
	}
	BoardBean bean = bMgr.getBoard(num);//게시물 가져오기
	
	String name = bean.getName();
	String subject = bean.getSubject();
	String regdate = bean.getRegdate();
	String content = bean.getContent();
	String filename = bean.getFilename();
	int filesize = bean.getFilesize();
	String ip = bean.getIp();
	int count = bean.getCount();
	
	session.setAttribute("bean", bean);//게시물을 세션에 저장
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp 게시판</title>
<link href="<%=cPath%>/css/portalStyle.css" rel="stylesheet" type="text/css">
<link href="<%=cPath%>/css/bbsstyle.css" rel="stylesheet" type="text/css"> 

<script type="text/javascript">
	function list(){
    	document.listFrm.submit();
 	} 
</script>
</head>
<body>
<jsp:include page="../head_inc.jsp"/>

<div class="bbs_container">
	<table class=table_title>
		<tr>
			<td ><h2>글읽기</h2></td>
		</tr>
	</table>
	
	<table class=bbs_read_table>
	<tr>
		<th width=100> 이름 </th>
		<td   ><%=name %></td>
		<th  width=100> 등록날짜 </th>
		<td  width=120><%=regdate%></td>
	</tr>
	<tr>
		<th   > 제목 </th>
		<td  colspan=3><%=subject%></td>
	</tr>
	<tr>
		<th  > 첨부파일 </th>
		<td bgcolor="#FFFFE8" colspan=3>
		<% if( filename !=null && !filename.equals("")) {%>
	  		<a href="javascript:down('<%=filename%>')"><%=filename%></a>
  		 &nbsp;&nbsp;<font color="blue">(<%=filesize%>KBytes)</font>  
  		 <%} else{%> 등록된 파일이 없습니다.<%}%>
		</td>
	</tr>
	<tr>
		<td colspan=4><br><br><%=content%><br><br></td>
	</tr>
	<tr>
		<td colspan=4 align=right> <%=ip%>로 부터 글을 남기셨습니다./  조회수  <%=count%>&nbsp;&nbsp;</td>
	</tr>
	</table>
		
	<!--  하단 메뉴 -->
	
	<div class=div_submit>	
		[ <a href="javascript:list()" >리스트</a> | 
		<a href="update.jsp?nowPage=<%=nowPage%>&num=<%=num%>" >수 정</a> |
		<a href="reply.jsp?nowPage=<%=nowPage%>" >답 변</a> |
		<a href="delete.jsp?nowPage=<%=nowPage%>&num=<%=num%>">삭 제</a> ]
	</div>
</div>
	<form name="listFrm" method="post" action="list.jsp">
		<input type="hidden" name="nowPage" value="<%=nowPage%>">
		<%if(!(keyWord==null || keyWord.equals(""))){ %>
		<input type="hidden" name="keyField" value="<%=keyField%>">
		<input type="hidden" name="keyWord" value="<%=keyWord%>">
		<%}%>
	</form>

<jsp:include page="../footer_inc.jsp"/>
</body>
</html>






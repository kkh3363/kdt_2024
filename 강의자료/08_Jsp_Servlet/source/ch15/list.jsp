<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="myPortal.bbs.BoardBean" %>
<%@ page import="java.util.Vector" %>
<jsp:useBean id="bMgr" class="myPortal.bbs.BoardManager" />
<%
	request.setCharacterEncoding("UTF-8");


	Vector<BoardBean> vlist = null;
	String keyWord=""; // 키워드 
	String keyField="";  // 키필드 ( 이름, 제목..)
	int nowPage = 1; // 현재 페이지
	int nowBlock=1;  //현재블럭
	int totalBlock =0;
	int numPerPage = 10 ; // 페이지당 레코드 수
	int pagePerBlock=15; //블럭당 페이지수
	int totalRecord = 0; // 전체 레코드 수.
	int start = 0;
	int end= 10;
	int totalPage;
	
	if (request.getParameter("keyWord") != null) {
		keyWord = request.getParameter("keyWord");
		keyField = request.getParameter("keyField");
	} 
	if (request.getParameter("reload") != null){
		if(request.getParameter("reload").equals("true")) {
			keyWord = "";
			keyField = "";
		}
	}
	if (request.getParameter("nowPage") != null) {
		nowPage = Integer.parseInt(request.getParameter("nowPage"));
	}
	start = (nowPage * numPerPage) - numPerPage;
	end = numPerPage;
	
	totalRecord = bMgr.getTotalCount(keyField, keyWord);
	// 전체 페이지....
	totalPage = (int)Math.ceil( (double)totalRecord / numPerPage) ;
	//현재블럭 계산
	nowBlock = (int)Math.ceil((double)nowPage/pagePerBlock); 
	//전체블럭계산
	totalBlock = (int)Math.ceil((double)totalPage / pagePerBlock);  
	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>보드 목록</title>
<link href="<%=request.getContextPath()%>/css/bbsStyle.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
	function read(num){
		document.readFrm.num.value=num;
		document.readFrm.action="read.jsp";
		document.readFrm.submit();
	}
	function block(value){
		 document.readFrm.nowPage.value=<%=pagePerBlock%>*(value-1)+1;
		 document.readFrm.submit();
	} 
	function pageing(page) {
		document.readFrm.nowPage.value = page;
		document.readFrm.submit();
	}
	function list() {
		document.listFrm.action = "list.jsp";
		document.listFrm.submit();
	}
	function check(){
		//alert(document.searchFrm.keyWord.value);
		if (document.searchFrm.keyWord.value == "") {
			alert("검색어를 입력하세요.")
			documet.searchFrm.keyWord.focus();
			return;
		}
		document.searchFrm.submit();
	}
</script>
</head>

<body>
	<div class="container">
	<h1 class=page-title>Jsp Board</h1>
	<br />
	<table width=100% align="center">
		<tr>
			<td> Total:  <%= totalRecord%> Articles( <%= nowPage%>/ <%=totalPage%>) pages</td>
		</tr>
	</table>
<%
	int listSize= 0 ;

	vlist = bMgr.getBoardList(keyField, keyWord, start, end);
	listSize = vlist.size();
%>	
	<table width=100% >
		<tr>
			<td align=center colspan=2>
<!--  리스트 제목 -->
			<table width=100% cellpadding=2 cellspacing = 0>
				<tr align=center bgcolor=#d0d0d0 height=120%>
					<th width=100>번호 </th>
					<th  >제목 </th>
					<th width=100>작성자 </th>
					<th width=100>작성일 </th>
					<th width=100>조회수 </th>
				</tr>
<!--  리스트 내용 -->
<%		if ( vlist.isEmpty()) {  %>
				<tr><td colspan=5 class="td_center"> 등록된 게시물이 없습니다....</td></tr>
	<%	} else {  
			for ( int i=0; i < numPerPage; i++ ){
				if (i == listSize) 
					break;
				BoardBean bean = vlist.get(i);
				int num = bean.getNum();
				String name = bean.getName();
				String subject = bean.getSubject();
				String regdate = bean.getRegdate();
				int depth = bean.getDepth();
				int count = bean.getCount();
	%>				
				<tr>
					<td class="td_center">
						<%=totalRecord-((nowPage-1)*numPerPage)-i%>
					</td>
					<td>
						<%
						  if(depth>0){
							for(int j=0;j<depth;j++){
								out.println("&nbsp;&nbsp;");
								}
							}
						%>
						<a href="javascript:read('<%=num%>')"><%=subject%></a>
					</td>
					<td class="td_center"><%=name%></td>
					<td class="td_center"><%=regdate%></td>
					<td class="td_center""><%=count%></td>
				</tr>
	
	<%		} // for
			%>				
				
		<% }  // end of if%>		
			</table>
			</td>
		</tr>
		<tr>
			<td colspan=2> <br><br></td>
		</tr>
		<!--  페이지 -->
		<tr>
			<td class="td_center" width=70%>
<%
				int pageStart = (nowBlock -1)*pagePerBlock + 1 ; //하단 페이지 시작번호
				int pageEnd = ((pageStart + pagePerBlock ) <= totalPage) ?  (pageStart + pagePerBlock): totalPage+1; 
				if(totalPage !=0){
					if (nowBlock > 1) {%>
						<a href="javascript:block('<%=nowBlock-1%>')">prev...</a>
					<%} // if (nowBlock) %> &nbsp;
					
					<% for ( ; pageStart < pageEnd; pageStart++){%>
						<a href="javascript:pageing('<%=pageStart %>')"> 
     					<%if(pageStart==nowPage) {%><font color="blue"> <%}%>
     					[<%=pageStart %>] 
     					<%if(pageStart==nowPage) {%></font> <%}%></a> 
   					<%}//for%>&nbsp; 
   					<%if (totalBlock > nowBlock ) {%>
   					<a href="javascript:block('<%=nowBlock+1%>')">.....next</a>
   					<%}%>&nbsp;  
			<% } // if (totalPage) %>			
			</td>
			<td class="td_right">
				<a href="post.jsp">[글쓰기]</a> 
				<a href="javascript:list()">[처음으로]</a>
			</td>
		</tr>
	</table>
<!--  찾기 폼 -->	
	<form name=searchFrm method="get" action="list.jsp" >
	<table  width="100%" cellpadding="4" cellspacing="0">
	<tr>
		<td class="td_center"> 
			<select name="keyField" size="1" >
  				<option value="name"> 이 름</option>
  				<option value="subject"> 제 목</option>
  				<option value="content"> 내 용</option>
			</select>
			<input type=tex size="16" name="keyWord">
			<input type="button"  value="찾기" onClick="javascript:check()">
			<input type="hidden" name="nowPage" value=1>
		</td>
	</tr>
	</table>	
	</form>
	<form name="listFrm" method="post">
		<input type=hidden name="reload" value="true">
		<input type=hidden name="nowPage" value="1">
	</form>
	<form name="readFrm" method="get">
		<input type="hidden" name="num"> 
		<input type="hidden" name="nowPage" value="<%=nowPage%>"> 
		<input type="hidden" name="keyField" value="<%=keyField%>"> 
		<input type="hidden" name="keyWord" value="<%=keyWord%>">
	</form>
</div>
</body>
</html>




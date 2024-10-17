<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String strTitle = "My Portal";
	String cPath = request.getContextPath();
	String id = (String) session.getAttribute("idKey");
	String memberUrl = cPath+"/member/memberUpdate.jsp";
	String memberUrlLabel = "회원수정";
	if(id==null){
		memberUrl = cPath+"/member/member.jsp";
        memberUrlLabel = "회원가입";
      }
%>    
<div id="container">
	<!--  헤더  -->
	<header>
		<div >
			<table>
			<tr>
				<td width=450>
					<div class="logo_title">
						<h1 >My Portal</h1>
					</div>
				</td>
				<td style="vertical-align: bottom">
					<ul id="ul_nav" >
						<li><a href="<%=memberUrl%>"><%=memberUrlLabel%></a> </li>
						<li> <a href="<%=cPath%>/board/list.jsp">게시판</a></li>
						<li><a href="<%=cPath%>/poll/pollList.jsp">설문조사</a> </li>
					</ul>
				</td>
			</tr>
			</table>
		</div><!--  header  -->
	</header>
	<!--  body  -->
	<div id=content>
		<div id="main_left">
		<jsp:include page="member/login.jsp"/>
		</div>
		<div id="main_content">
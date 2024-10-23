<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@page import="java.util.Vector,myPortal.pblog.*"%>
<jsp:useBean id="pmgr" class="myPortal.pblog.PBlogManager"/>
<jsp:useBean id="rmgr" class="myPortal.pblog.PReplyManager"/>
<%
		String id = (String)session.getAttribute("idKey");
		if(id==null) 
			response.sendRedirect("login.jsp");
		PMemberBean mbean = pmgr.getPMember(id);
		Vector<PMemberBean> mvlist = pmgr.listPMember(id);
		Vector<PBlogBean> pvlist = pmgr.listPBlog(id);
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1"/>
	<title>Insert title here</title>
</head>
<body>
<div data-role="page" align="center">
	<div data-role="header">
	<table>
			<tr>
				<td align="left" width="200">
					<h1 style="font-family: fantasy;" align="left">PhotoBlog</h1></td>
				<td>
					<a style="font-size: 40px;" href="javascript:goURL('home.jsp','')">H</a>
					<a style="font-size: 40px;" href="javascript:goURL('post.jsp','')">P</a>
				</td>
				<td>	
					<div class="box" style="background: #BDBDBD;">
						<img  align="bottom" class="profile" src="photo/<%=mbean.getProfile()%>" width="30" height="30" onclick="location='logout.jsp'">
					</div>
				</td>
			</tr>
		</table>
	</div>  <!-- header -->
	
	<div data-role="content">
		<table>
		<tr>
		<%
				for(int i=0;i<mvlist.size();i++){
					PMemberBean mvbean = mvlist.get(i);
		%>
			<td width="80">
				<div class="box1" style="background: #BDBDBD;">
					<a href="javascript:goURL('guest.jsp','<%=mvbean.getId()%>')">
						<img class="profile1" src="photo/<%=mvbean.getProfile()%>" width="30" height="30">
					</a>
				</div>
				<div>
					<h4><%=mvbean.getName()%></h4>
				</div>
			</td>
		<%}%>	
		</tr>
	</table>
	<table>
		<%
				for(int i=0;i<pvlist.size();i++){
					PBlogBean pbean = pvlist.get(i);
					PMemberBean tmbean = pmgr.getPMember(pbean.getId());
		%>
		<tr>
			<td width="30">
				<div class="box" style="background: #BDBDBD;">
					<img class="profile" src="photo/<%=tmbean.getProfile()%>" width="30" height="30">
				</div>
			</td>
			<td width="250"><b><%=tmbean.getId()%></b></td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td colspan="3">
				<img src="photo/<%=pbean.getPhoto()%>" width="350" height="150">
			</td>
		</tr>
		<tr>
			<td colspan="3"><b><%=pbean.getMessage()%></b></td>
		</tr>
		<tr>
			<td colspan="2">
			<a href="javascript:heart('<%=pbean.getNum()%>')">
			<img src="img/heart.jpg" align="top"></a> ÁÁ¾Æ¿ä <%=pbean.getHcnt() %>°³</td>
			<td align="center"><a href="javascript:del('<%=pbean.getNum()%>')">DEL</a></td>
		</tr>
		<tr>
			<td colspan="3" width="200"> 
				<%
						Vector<PReplyBean> rvlist = rmgr.listPReply(pbean.getNum());
						for(int j=0;j<rvlist.size();j++){
							PReplyBean rbean = rvlist.get(j);
				%>
				<b><%=rbean.getId()%></b> <%=rbean.getComment()%>&nbsp;
				<%if(id.equals(rbean.getId())){%>
					<a href="javascript:rDel('<%=rbean.getRnum()%>')">x</a><%}%><br>			
				<%}%>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input id="comment<%=pbean.getNum()%>" placeholder="´ñ±Û´Þ±â..." size="50">
			</td>
			<td align="center">
				<a href="javascript:cmtPost('<%=pbean.getNum()%>')">°Ô½Ã</a>
			</td>
		</tr>
		<tr>
			<td colspan="3"><br></td>
		</tr>
		<%}%>
	</table>
	</div> <!-- content -->
	<form method="post" name="frm">
		<input type="hidden" name="num">
		<input type="hidden" name="comment">
		<input type="hidden" name="rnum">
		<input type="hidden" name="id">
	</form>
	<form method="post" name="frm1" action="home.jsp">
		<input type="hidden" name="gid">
	</form>
	<%@include file="footer.jsp" %>
</div> <!-- page -->
</body>
</html>

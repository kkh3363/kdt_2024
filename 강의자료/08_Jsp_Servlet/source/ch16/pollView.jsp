<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="myPortal.poll.*,java.util.*"%>   
<jsp:useBean id="pMgr" class="myPortal.poll.PollManager" />

<%
	request.setCharacterEncoding("UTF-8");
	int num = 0;
	if (request.getParameter("num") != null) {
		num = Integer.parseInt(request.getParameter("num"));
	}
	Vector<PollItemBean> vlist = pMgr.getView(num);
	PollListBean plBean = pMgr.getList(num);
	String question = plBean.getQuestion();
	Random r = new Random();
	int sum = pMgr.sumCount(num);
%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>투표 결과</title>
<link href="<%=request.getContextPath()%>/css/pollstyle.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="container">
	<table class=table_title >
		<tr>
			<td class=td_title>투표 결과</td>
		</tr>
		<tr>
			<td class="td_right"><b>총 투표자 : <%=sum%>명</b></td>
		</tr>
		<tr>
			<td class="td_question">Q :<%=question%></td>
		</tr>
	</table>
	<table >
<%	for (int i=0; i < vlist.size(); i++)  {
		PollItemBean piBean = vlist.get(i);
		String[] item = piBean.getItem();
		int rgb = r.nextInt(255 * 255 * 255);
		String rgbt = Integer.toHexString(rgb);
		String hRGB = "#" + rgbt;
		int count = piBean.getCount();//투표수
		int ratio = (new Double(Math.ceil((double) count / sum * 100))).intValue();
%>
	<tr>
		<td width="20" align="center"><%=i+1%></td>
		<td width="120"><%=item[0]%></td>
		<td>
			<table width=100% height="15">
				<tr>
					<td width="<%=ratio%>%" bgcolor="<%=hRGB%>" ></td>
					<td> </td>
				</tr>
			</table>
		</td>
		<td width="40"><%=count%></td>
	</tr>
<% } %>		
	
	</table>
	<br>
	<br>
	<hr>
	<a href="javascript:window.close()">닫기</a>

</div>
</body>
</html>




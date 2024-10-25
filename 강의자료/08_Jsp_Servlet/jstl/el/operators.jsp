<%@page contentType="text/html;charset=EUC-KR"%>
<%
		pageContext.setAttribute("J",31);
		pageContext.setAttribute("S",8);
		pageContext.setAttribute("P",22);
%>
<html>
<head>
<title>Expression Language</title>
</head>
<body>
<h2>EL의 Operators</h2>
<b>J = ${J}, S = ${S}, P = ${P}</b><p/> 
<b>산술 연산자</b><hr width="250" align="left"/>
&#36;{J + S} : ${J + S}<br/> 
&#36;{J - S} : ${J - S}<br/> 
&#36;{J * S} : ${J * S}<br/> 
&#36;{J / S} : ${J / S}<br/> 
&#36;{J % S} : ${J % S}<p/> 

<b>비교 연산자</b><hr width="250" align="left"/>
&#36;{J < S} : ${J lt S}<br/> 
&#36;{J > S} : ${J gt S}<br/>
&#36;{S <= P} : ${S le P}<br/>
&#36;{S >= P} : ${S ge P}<br/>
&#36;{(10*10) == 100} : ${(10*10) eq 100}<br/> 
<%-- &#36;{(10*10) != 100} : ${(10*10) ne 100}<p/> --%>

<b>논리 및 조건 연산자</b><hr width="250" align="left"/>
&#36;{J > P && P < S} : ${J>P and P<S}<br/>
&#36;{J > P || P < S} : ${J>P or P<S}<br/>
&#36;{!(J == P)} : ${not (J==P)}<br/>
&#36;{(J == S)? "같다" : "다르다" } : ${(J==S) ? "같다" : "다르다"}<p/> 
</body>
</html>

<%@page contentType="text/html;charset=EUC-KR"%>
<jsp:useBean id="bean" class="ch20.ELBean"/>
<jsp:setProperty name="bean" property="siteName"/>
<html>
<head>
<title>Expression Language</title>
</head>
<body>
<h2>EL의 Beans</h2>
빈즈액션 태그<br/> 
사이트명 : <jsp:getProperty name="bean"  property="siteName"/><p/>
EL Beans <br/>
사이트명 : ${bean.siteName}
</body>
</html>
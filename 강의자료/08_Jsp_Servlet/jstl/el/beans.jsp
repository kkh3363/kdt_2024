<%@page contentType="text/html;charset=EUC-KR"%>
<jsp:useBean id="bean" class="ch20.ELBean"/>
<jsp:setProperty name="bean" property="siteName"/>
<html>
<head>
<title>Expression Language</title>
</head>
<body>
<h2>EL�� Beans</h2>
����׼� �±�<br/> 
����Ʈ�� : <jsp:getProperty name="bean"  property="siteName"/><p/>
EL Beans <br/>
����Ʈ�� : ${bean.siteName}
</body>
</html>
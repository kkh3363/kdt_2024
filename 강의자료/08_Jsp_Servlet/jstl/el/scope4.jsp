<%@page contentType="text/html;charset=EUC-KR"%>
<html>
<head>
<title>Expression Language</title>
</head>
<body>
<h2>EL의 Scope2</h2>
id(sessionScope로 받은값) :  <b>${sessionScope.id}</b><p/>
siteName(applicationScope로 받은값) : <b>${applicationScope.siteName}</b><p/>
</body>
</html>
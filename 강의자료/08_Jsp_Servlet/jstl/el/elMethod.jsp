<%@page contentType="text/html;charset=EUC-KR"%>
<%@ taglib prefix="m" uri="/WEB-INF/tlds/Functions.tld"%>
<html>
<head>
<title>Expression Language</title>
</head>
<body>
<h2>EL의 정적 메소드</h2>
123456789를 1000단위 구분 기호(,)로 표시하시오.<p/>
<b>result : ${m:comma(123456789)}</b> 
</body>
</html>
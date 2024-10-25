<%@page contentType="text/html;charset=EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<title>JSTL</title>
</head>
<body >
<h2>Formatting Tags2</h2>
<c:set var="num" value="123456789"/>
숫자 : <fmt:formatNumber value="${num}" type="number"/><br/>
퍼센트 : <fmt:formatNumber value="${num}" type="percent" groupingUsed="true"/><br/>
달러 : <fmt:formatNumber value="${num}" type="currency" currencySymbol="$"/><br/>
패턴 : <fmt:formatNumber value="${num}" pattern="0.0000" groupingUsed="false"/><p/>

<fmt:parseNumber var="i" integerOnly="true" value="123.456"/>
실수를 제외한 정수 : <c:out value="${i}"/>
</body>
</html>
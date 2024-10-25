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
���� : <fmt:formatNumber value="${num}" type="number"/><br/>
�ۼ�Ʈ : <fmt:formatNumber value="${num}" type="percent" groupingUsed="true"/><br/>
�޷� : <fmt:formatNumber value="${num}" type="currency" currencySymbol="$"/><br/>
���� : <fmt:formatNumber value="${num}" pattern="0.0000" groupingUsed="false"/><p/>

<fmt:parseNumber var="i" integerOnly="true" value="123.456"/>
�Ǽ��� ������ ���� : <c:out value="${i}"/>
</body>
</html>
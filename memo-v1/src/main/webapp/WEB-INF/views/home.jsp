<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Memo</title>
</head>
<body>
<header>
<h1>나의 메모장</h1>
</header>
<section>
	<c:choose>
		<c:when test="${BODY eq 'MEMO_LIST'}">
			<%@ include file="/WEB-INF/views/list.jsp" %>
		</c:when>
		<c:when test="${BODY eq 'MEMO_INPUT'}">
			<%@ include file="/WEB-INF/views/input.jsp" %>
		</c:when>
		<c:when test="${BODY eq 'MEMO_DETAIL'}">
			<%@ include file="/WEB-INF/views/detail.jsp" %>
		</c:when>
		<c:otherwise>
			<%@ include file="/WEB-INF/views/main.jsp" %>
		</c:otherwise>
	</c:choose>
</section>



</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Memo</title>
	
	<style>
		* {
			box-sizing: border-box;
			margin: 0;
			padding: 0;
		}	
		h1{
			margin:30px;
			text-align: center;
		}
		.btn_box{
			 width:90%;
			margin:5px auto;
			text-align:right;
			
		}
		button{
			padding:10px 20px;
			outline:0;
			border:0;
			border-radius:5px;
		}
		button:hover{
			box-shadow: 1px 1px 1px black;
			cursor:pointer;
		}
	</style>
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

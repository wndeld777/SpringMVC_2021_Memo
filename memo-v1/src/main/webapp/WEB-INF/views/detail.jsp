<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath }" />
<style>
table.memo_detail tr{
	margin:0 auto;
}
table.memo_detail th, table.memo_detail td{
	border-top:#333;
	border-bottom:#222;
	border-right:#333;
	border-left:#aaa;
	
	border:1px solid;
	border-spacing : 1px;
}
table.memo_detail th{
	width:15%;
}
table.memo_detail td{
	width:30%;
}
table{
	border:0;
	width:90%;
	border-collapse: collapse;
	border-spacing: 0;
	margin:10px auto;
}

tr:nth-of-type(odd){
	background-color:#ccc;
	
}
tr:nth-of-type(even){
	background-color:#eee;
}

td, th{
	padding:8px 12px;
	text-align: center;
}

</style>
<table class="memo_detail">
	<tr>
		<th>No.</th><td>${MEMO.m_seq}</td>
		<th>작성자</th><td>${MEMO.m_author }</td>
	</tr>
	<tr>
		<th>날짜</th><td>${MEMO.m_date }</td>
		<th>시간</th><td>${MEMO.m_time }</td>
	</tr>				
	<tr>
		<th>내용</th><td>${MEMO.m_memo }</td>
		<th>사진</th><td>${MEMO.m_image }</td>
	</tr>		
</table>
<div class="btn_box">
	<button class="memo update">수정</button>
	<button class="memo delete">삭제</button>
</div>
<script>
	document.querySelector(".delete").addEventListener("click",()=>{
		location.replace("${rootPath}/delete?m_seq=${MEMO.m_seq}")
	})
	document.querySelector(".update").addEventListener("click",()=>{
		location.href = "${rootPath}/update?m_seq=${MEMO.m_seq}"
	})
</script>
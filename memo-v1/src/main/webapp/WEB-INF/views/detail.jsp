<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath }" />
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
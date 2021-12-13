<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath }" />
<link href="${rootPath}/static/css/list.css?ver=2021-12-12-001"
	rel="stylesheet"/>
<table class="memo_list detail">
	<tr>
		<th>No.</th>
		<th>작성자</th>
		<th>메모내용</th>
		<th>사진</th>
		<tr>
	<c:choose>
		<c:when test="${empty MEMO }">
			<tr>
				<td colspan="5">데이터가 없음</td>
		</c:when>
	<c:otherwise>
		<c:forEach items="${MEMO }" var="MEMO">
			<tr data-mnum="${MEMO.m_seq }">
				<td>${MEMO.m_seq }</td>
				<td>${MEMO.m_author }</td>
				<td>${MEMO.m_memo }</td>
				<c:choose>
				<c:when test="${not empty IMAGES }">
				<td><img width="50px" id="m_image"
			src="${rootPath}/files/${IMAGES.SAVENAME}"></td>
				</c:when>
					<c:otherwise>
					<td>
				<img id="to_image_thumnail"
			src="${rootPath}/static/images/noImage.png"
			width="30px"
			></td>
				</c:otherwise>
				</c:choose>
							
				
		</c:forEach>
	</c:otherwise>
	</c:choose>
</table>
	
<div class="btn_box">
	<button class="memo insert">메모등록</button>
</div>
<script>
	let m_insert = document.querySelector("button.insert");
	m_insert.addEventListener("click",(e)=>{
		location.href = "${rootPath}/insert"
	})
	
	
	let table = document.querySelector("table.detail")
	if(table){
		table.addEventListener("click",(e)=>{
			let target = e.target
			let tagName = target.tagName
			if(tagName === "TD"){
				let tr = target.closest("TR")
				let mSeq = tr.dataset.mnum
				location.href="${rootPath}/detail?m_seq=" + mSeq
			}
		})
	
	}
</script>
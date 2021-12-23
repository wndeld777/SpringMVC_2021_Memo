<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath }" />
<link href="${rootPath}/static/css/input.css?ver=2021-12-12-001"
	rel="stylesheet"/>

<form id="memo_input" method="POST" enctype="multipart/form-data">
	<fieldset>
		<div>
			<label>No.</label>
			 <input name="m_seq" id="m_seq" value="${MEMO.m_seq }" />
		</div>
		<div>
			<label>작성자이름</label>
			 <input name="m_author" id="m_author" placeholder="작성자이름을 입력하세요" value="${MEMO.m_author }"/>
		</div>
		<div>
			<label>날짜</label>
			 <input name="m_date" id="m_date" value="${MEMO.m_date }"/>
		</div>
		<div>
			<label>시간</label>
			 <input name="m_time" id="m_time" value="${MEMO.m_time }"/>
		</div>
		<div>
			<label>메모</label>
			 <input name="m_memo" id="m_memo" placeholder="메모를 입력하세요" value="${MEMO.m_memo }"/>
		</div>
		<div>
			<label>이미지</label>
			 <input accept="image/*" type="file" name="m_image" id="m_image" multiple="multiple" value="${MEMO.m_image}"/>
			 <div>
					<img width="100px" id="m_image" src="${rootPath}/files/${MEMO.m_image}">
			</div>
			 
		</div>
		<div class="btn_box">
			<button>저장</button>
			<button type="reset" class="reset">초기화</button>
			<button type="button" class="list">리스트로</button>
		</div>
	</fieldset>
</form>
<script>

	document.querySelector("button.list").addEventListener("click",()=>{
		location.href="${rootPath}/"
	})

</script>
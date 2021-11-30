<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath }" />

<form id="memo_input" method="POST">
	<fieldset>
		<div>
			<label>No.</label>
			 <input name="m_seq" id="m_seq" value=<c:out value="${MEMO.m_seq }"/> />
		</div>
		<div>
			<label>작성자이름</label>
			 <input name="m_author" id="m_author" placeholder="작성자이름을 입력하세요"/>
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
			 <input name="m_memo" id="m_memo" placeholder="메모를 입력하세요"/>
		</div>
		<div>
			<label>이미지</label>
			 <input name="m_image" id="m_image" placeholder="이미지를 넣으세요"/>
		</div>
		<div class="btn_box">
			<button type="button" class="save">저장</button>
			<button type="reset" class="reset">초기화</button>
			<button type="button" class="list">리스트로</button>
		</div>
	</fieldset>
</form>
<script>
	document.querySelector("button.save").addEventListener("click",(e)=>{
		document.querySelector("form#memo_input").submit()
	})
</script>
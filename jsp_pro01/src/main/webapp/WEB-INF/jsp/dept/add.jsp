<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import="dept.model.DeptDTO" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>부서 추가</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/styles.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/required.js"></script>
</head>
<body>
	<h1>부서 추가 화면</h1>
	<section class="container">
		<form class="small-form" action="./add" method="post">
			<div class="input-form wide">
				<label class="input-label">부서ID</label>
				<input class="input-text" type="text" name="deptId" value="${data.deptId}" placeholder="부서 ID">
				<c:if test="${errorCode eq 'deptId'}">
					<lavel class="input-label-error">${errorMsg}</lavel>
				</c:if>
			</div>
			<div class="input-form wide">
				<label class="input-label">부서명</label>
				<input class="input-text" type="text" name="deptName" value="${data.deptName}" placeholder="부서명">
			</div>
			<div class="input-form wide">
				<label class="input-label">매니저ID</label>
				<input class="input-text" type="text" name="mngId" value="${data.mngId}" placeholder="매니저 ID">
				<c:if test="${errorCode eq 'mngId'}">
					<lavel class="input-label-error">${errorMsg}</lavel>
				</c:if>
			</div>
			<div class="input-form wide">
				<label class="input-label">지역코드</label>
				<input class="input-text" type="text" name="locId" value="${data.locId}" placeholder="지역 코드">
				<c:if test="${errorCode eq 'locId'}">
					<lavel class="input-label-error">${errorMsg}</lavel>
				</c:if>
			</div>
			<div class="input-form wide form-right">
				<button class="btn btn-outline btn-ok" type="submit">저장</button>
				<button class="btn btn-outline btn-cancel" type="button" onclick="history.back();">취소</button>
			</div>
		</form>
	</section>
</body>
</html>
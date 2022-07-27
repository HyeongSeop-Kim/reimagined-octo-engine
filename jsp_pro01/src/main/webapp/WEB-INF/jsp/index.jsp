<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import="java.util.*, dept.model.DeptDTO" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Welcome JSP/Servlet</title>
	<%@ include file="./module/head.jsp" %>
</head>
<script type="text/javascript">
	function sendAjax() {
		$.ajax({
			type: "get", //전송타입(post, get)
			url: "ajax/test", //데이터 처리를 담당하는 서버주소
			data: {
				x: "Hello",
				y: 1234
			}, //서버에 전송할 데이터
			dataType: "json", //서버의 응답 데이터 형식(xml, text, json 등)
			success: function(data, status) {
				// 서버로 부터의 응답 코드가 200번일 때 동작할 함수 작성
				// data: 서버로 부터 받은 데이터 정보를 가지고 있는 객체
				// status: 응답 코드
				console.log("success: " + data);
				console.log("success: " + data.attributeName);
				console.log("success: " + status);
			},
			error: function(data, status) {
				// 서버로 부터의 응답 코드가 200이 아닐 때 동작할 함수 작성
				// data: 서버로 부터 받은 데이터 정보를 가지고 있는 객체
				// status: 응답 코드
				console.log("error: " + data);
				console.log("error: " + status);
			},
			complete: function(data, status) {
				// 통신 성공 여부와 관계 없이 완료 후 동작할 함수 작성
				console.log("complete: " + data);
				console.log("complete: " + status);
			}
		});
	}
</script>
<body>
	<%@ include file="/WEB-INF/jsp/module/navigation.jsp" %>
	<section class="container">
		<div>
			<button type="button" onclick="sendAjax();">비동기 통신</button>
		</div>
		<c:url var="loginUrl" value="/login" />
		<form class="small-form" action="${loginUrl}" method="post">
			<div class="input-form wide">
				<label class="input-label">직원ID</label>
				<input class="input-text" type="text" name="empId" value="">
				<c:if test="${errorCode eq 'deptId'}">
					<label class="input-label-error">${errorMsg}</label>
				</c:if>
			</div>
			<div class="input-form wide">
				<label class="input-label">부서명</label>
				<select class="select-form" name="deptId">
					<c:forEach items="${deptDatas}" var="deptDto">
						<option value="${deptDto.deptId}">${deptDto.deptName}</option>
					</c:forEach>
				</select>
				<c:if test="${errorCode eq 'deptId'}">
					<label class="input-label-error">${errorMsg}</label>
				</c:if>
			</div>
			<div class="input-form wide">
				<label class="input-label">이름</label>
				<input class="input-text" type="text" name="empName" value="">
				<c:if test="${errorCode eq 'deptName'}">
					<label class="input-label-error">${errorMsg}</label>
				</c:if>
			</div>
			<div class="input-form wide form-right">
				<button class="btn btn-outline btn-ok" type="submit">로그인</button>
			</div>
		</form>
	</section>
</body>
</html>
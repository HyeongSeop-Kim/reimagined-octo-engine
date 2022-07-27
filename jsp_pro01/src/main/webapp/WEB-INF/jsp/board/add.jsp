<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시글 등록</title>
	<link rel="stylesheet" type="text/css" href="../static/bs5/css/bootstrap.min.css">
	<script type="text/javascript" src="../static/bs5/js/bootstrap.min.js"></script>
</head>
<script type="text/javascript">
	function formCheck(form) {
		if(form.title.value === undefined || form.title.value.trim() === "") {
			var modal = new bootstrap.Modal(document.getElementById("errorModal"), {
				keyboard: false
			});
			modal.show();
			return;
		}
		form.submit();
	}
</script>
<body>
	<header></header>
	<section class="container">
		<div>
			<form action="/jsp01/board/add" method="post">
				<div class="mb-3">
					<input class="form-control" type="text" name="title" placeholder="제목을 입력하세요.">
				</div>
				<div class="mb-3">
					<textarea class="form-control" name="content" rews="8" placeholder="내용을 입력하세요.">
					</textarea>
				</div>
				<div class="mb-3 text-end">
					<button class="btn btn-primary" type="button" onclick="formCheck(this.form)"">저장</button>
				</div>
			</form>
		</div>

		<!-- Modal -->
		<div class="modal fade" id="errorModal" tabindex="-1" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title">입력 오류</h5>
						<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      		</div>
			      	<div class="modal-body">
			        	제목은 공란을 입력할 수 없습니다.<br>
			        	반드시 제목을 입력하세요.
			      	</div>
			   		<div class="modal-footer">
				        <button type="button" class="btn btn-sm btn-danger" data-bs-dismiss="modal">확인</button>
				    </div>
		  		</div>
		  	</div>
		</div>
	</section>
</body>
</html>
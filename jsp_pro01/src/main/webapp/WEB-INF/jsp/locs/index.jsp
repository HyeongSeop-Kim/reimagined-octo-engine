<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*, locs.model.LocsDTO" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>지역 조회 결과</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/static/css/styles.css">
	<script type="text/javascript" src="<%=request.getContextPath() %>/static/js/required.js"></script>
</head>
<body>
	<%@ include file="/WEB-INF/jsp/module/navigation.jsp" %>
	<h1>지역 조회 결과</h1>
	<div>
		<form action="./locs" method="get">
			<div>
				<input type="text" name="search">
				<button type="submit">조회</button>
			</div>
		</form>
	</div>
	<table>
		<tr>
			<th>LocationId</th>
			<th>StreetAddress</th>
			<th>PostalCode</th>
			<th>City</th>
			<th>StateProvince</th>
			<th>CountryId</th>
		</tr>
		<c:if test="${not empty datas}">
			<c:forEach items="${datas}" var="data">
				<tr>
					<td>${data.locationId}</td>
					<td>${data.streetAddress}</td>
					<td>${data.postalCode}</td>
					<td>${data.city}</td>
					<td>${data.stateProvince}</td>
					<td>${data.countryId}</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
</body>
</html>
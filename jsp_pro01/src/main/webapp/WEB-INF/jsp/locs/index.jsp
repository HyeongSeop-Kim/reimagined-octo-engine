<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*, locs.model.LocsDTO" %>    
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>지역 조회 결과</title>
</head>
<body>
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
		<% 
			if(request.getAttribute("datas") != null) {
				List<LocsDTO> datas = (List<LocsDTO>)request.getAttribute("datas");
				for(LocsDTO data: datas) { 
		%>
			<tr>
				<td><%=data.getLocationId()  %></td>
				<td><%=data.getStreetAddress()  %></td>
				<td><%=data.getPostalCode()  %></td>
				<td><%=data.getCity()  %></td>
				<td><%=data.getStateProvince()  %></td>
				<td><%=data.getCountryId()  %></td>
			</tr>
		<% 
				}
			}   else {
		%>
			<tr>
				<td colspan="4">검색 결과가 없습니다.</td>
			</tr>
		<%
			}
		%>
	</table>
</body>
</html>
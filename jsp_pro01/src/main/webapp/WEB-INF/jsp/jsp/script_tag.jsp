<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 지시자 태그 --%>
<%@ page import="java.util.*" %>
<%-- 선언 태그 --%>
<%! 
	// 멤버 변수
	private String name = "Hello";

// 메서드
	public String hello() {
		return "Hello";
	}
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>JSP - Scipt Tag</title>
</head>
<body>
	<h1>JSP - Scipt Tag</h1>
	<%-- 주석 --%>
	<%-- 스크립트릿 태그 --%>
	<%
		// Java 주석
		for(int i = 0; i < 5; i++) {
			Random rd = new Random();
			out.println("<li>" + rd.nextInt(100) + "</li>");
		}
	%>
	<% for(int i = 0; i < 5; i++) {%>
	<li><%= i %></li>
	<% } %>
	<%-- 표현식 태그 --%>
	<input type="text" value="<%=name %>"><br>
	<input type="text" value="<%=hello() %>">
</body>
</html>
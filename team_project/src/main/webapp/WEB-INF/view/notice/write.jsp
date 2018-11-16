<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새 글 쓰기</title>
</head>
<body>
	<form:form commandName="noticeDto" method="POST">
		<table border="1">
			<tr>
				<th><form:label path="nTitle">제목</form:label></th>
				<td><form:input path="nTitle"/>
		<%-- 		<form:errors path="nTitle"/></td> --%>
			</tr>
			<tr>
				<th><form:label path="notice">내용</form:label></th>
				<td><form:input path="notice"/>
			<%-- 	<form:errors path="notice"/></td> --%>
			</tr>
			<tr>
				<th><form:label path="name">작성자</form:label></th>
				<td><form:input path="name"/>
				<%-- <form:errors path="name"/></td> --%>
			</tr>
			<%-- <tr>
				<th><form:label path="password">비밀번호</form:label></th>
				<td><form:password path="password"/>
				<form:errors path="password"/></td>
			</tr> --%>
		</table>
		<div>
			<input type="submit" value="등록">
			<a href="<c:url value="/notice/list" />">목록</a>
		</div>
	</form:form>

</body>
</html>
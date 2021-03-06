<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정</title>
</head>
<body>
	<form:form commandName="noticeDto" method="POST">
		<table border="1">
			<tr>
				<th><form:label path="nTitle">제목</form:label></th>
				<td><form:input path="nTitle"/>
			</tr>
			<tr>
				<th><form:label path="notice">내용</form:label></th>
				<td><form:input path="notice"/>
			</tr>
			<tr>
				<th><form:label path="name">작성자</form:label></th>
				<td><form:label path="name">${noticeDto.name}</form:label>
			</tr>
		</table>
		<div>
			<input type="submit" value="등록">
			<a href="<c:url value="/notice/list" />">목록</a>
		</div>
	</form:form>

</body>
</html>
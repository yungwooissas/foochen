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
	<form:form commandName="recipeDto" method="POST">
		<table border="1">
			<tr>
				<th><form:label path="rTitle">제목</form:label></th>
				<td><form:input path="rTitle"/>
				<form:errors path="rTitle"/></td>
			</tr>
			<tr>
				<th><form:label path="rExplain">내용</form:label></th>
				<td><form:input path="rExplain"/>
				<form:errors path="rExplain"/></td>
			</tr>
			<tr>
				<th><form:label path="name">작성자</form:label></th>
				<td><form:input path="name"/>
				<form:errors path="name"/></td>
			</tr>
			
		</table>
		<div>
			<input type="submit" value="등록">
			<a href="<c:url value="/recipe/recipe" />">목록</a>
		</div>
	</form:form>

</body>
</html>
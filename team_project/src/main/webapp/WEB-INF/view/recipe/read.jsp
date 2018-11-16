<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${recipeDto.rTitle}&nbsp;내용</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>제목</th>
			<td>${recipeDto.rTitle }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${recipeDto.rExplain }</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${recipeDto.name }</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td>${recipeDto.rDate }</td>
		</tr>
		<tr>
			<th>조회수</th>
			<td>${recipeDto.rCount }</td>
		</tr>
	</table>
	<div>
		<a href="<c:url value="/recipe/edit/${recipeDto.rNumber }"/>">수정</a> 
		<a href="<c:url value="/recipe/delete/${recipeDto.rNumber }"/>">삭제</a> 
		<a href="<c:url value="/recipe/recipelist"/>">목록</a>
	</div>


</body>
</html>
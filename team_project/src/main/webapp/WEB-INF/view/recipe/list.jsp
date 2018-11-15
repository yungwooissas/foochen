<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>목록</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>게시글 번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>글내용</th>
			<th>사진</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<c:forEach var="recipeboard" items="${recipeList}" varStatus="loop">
			<tr>
				<td>${recipeboard.rNumber}</td>
				<td>${recipeboard.rTitle}</td>
				<td>${recipeboard.name}</td>
				<td>${recipeboard.rExplain}</td>
				<td>${recipeboard.rImage}</td>
				<td>${recipeboard.rDate}</td>
				<td>${recipeboard.rCount}</td>
			</tr>
		</c:forEach>
	</table>
	<a href="<c:url value="/recipe/recipewrite" />">새글</a>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${qnaDto.nTitle }&nbsp내용</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>제목</th>
			<td>${qnaDto.qTitle }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${qnaDto.qna }</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${qnaDto.name }</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td><fmt:formatDate value="${qnaDto.qDate }" pattern="yyyy.MM.dd"/></td>
		</tr>
	</table>
	<div>
		<c:if test="${approval =='approval' }">
			<a href="<c:url value="/qna/edit/${qnaDto.qNumber }"/>">수정</a>
			<a href="<c:url value="/qna/delete/${qnaDto.qNumber }"/>">삭제</a>
		</c:if>
			<a href="<c:url value="/qna/list"/>">목록</a>
	</div>
	
</body>
</html>
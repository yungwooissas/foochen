<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${noticeDto.nTitle }&nbsp내용</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>제목</th>
			<td>${noticeDto.nTitle }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${noticeDto.notice }</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${noticeDto.name }</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td><fmt:formatDate value="${noticeDto.nDate }" pattern="yyyy.MM.dd"/></td>
		</tr>
	</table>
	<div>
		<c:if test="${approval =='approval' }">
			<a href="<c:url value="/notice/edit/${noticeDto.nNumber }"/>">수정</a>
			<a href="<c:url value="/notice/delete/${noticeDto.nNumber }"/>">삭제</a>
		</c:if>
			<a href="<c:url value="/notice/list"/>">목록</a>
	</div>
	
</body>
</html>
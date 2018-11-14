<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
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
			<td>${notice.nDate }</td>
		</tr>
<%-- 		<tr>
			<th>조회수</th>
			<td>${notice.cnt }</td>
		</tr> --%>
	</table>
	<div>
		<a href="<c:url value="/notice/edit/${notice.nNumber }"/>">수정</a>
		<a href="<c:url value="/notice/delete/${notice.nNumber }"/>">삭제</a>
		<a href="<c:url value="/notice/list"/>">목록</a>
	</div>

</body>
</html>
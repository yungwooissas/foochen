<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>목록</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>NO</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<c:forEach var="notice" items="${noticeList }" varStatus="loop">
			<tr>
				<td>${notice.seq }</td>
				<td><a href="<c:url value="/notice/read/${notice.nNumber }" />">${notice.nTitle }</a></td>
				<td>${notice.writer }</td>
				<td>${notice.nDate }</td>
				<%-- <td>${notice.cnt }</td> --%>
			</tr>
		</c:forEach>
	</table>
	<a href="<c:url value="/notice/write"/>">새글</a>
</body>
</html>
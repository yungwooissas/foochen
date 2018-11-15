<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>톡 게시판(목록)</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>게시글 번호</th>
			<th>작성자</th>
			<th>글내용</th>					
			<th>사진</th>
			<c:if test="${tImage ne null}">	
			</c:if>
			<th>작성일</th>
		</tr>
		<c:forEach var="talkboard" items="${talkList}" varStatus="loop">
			<tr>
				<td>${talkboard.tNumber}</td>
				<td>${talkboard.name}</td>
				<td><a href="<c:url value="/talk/talkdetail/${talkboard.tNumber}"/>">
				${talkboard.talk}</a></td>
				<c:if test="${talkboard.tImage ne null}">			
					<td>${talkboard.tImage}</td>
				</c:if>									
				<td>${talkboard.tDate}</td>
			</tr>
		</c:forEach>
	</table>
	<a href="<c:url value="/talk/talkwrite" />">새글</a>
</body>
</html>
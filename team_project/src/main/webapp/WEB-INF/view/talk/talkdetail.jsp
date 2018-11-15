<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${talkDto.name}님의&nbsp내용</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>작성자</th>
			<td>${talkDto.name}</td>
		</tr>
		<tr>
			<th>작성시간</th>
			<td>${talkDto.tDate}</td>
		</tr>
		<tr>
			<th>사진</th>
			<td>${talkDto.tImage}</td>
		</tr>
		<tr>
			<th>글 내용</th>
			<td>${talkDto.talk}</td>
		</tr>
	</table>
	<div>
		<a href="<c:url value="/talk/talkupdate/${talkDto.tNumber}"/>">수정</a>
		<a href="<c:url value="/talk/talkdelete/${talkDto.tNumber}"/>">삭제</a>
		<a href="<c:url value="/talk/talklist"/>">톡 목록</a>
	</div>
</body>
</html>
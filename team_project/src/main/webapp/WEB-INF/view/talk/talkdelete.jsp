<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>삭제</title>
</head>
<body>	
	<form name="deleteForm"
	action="<c:url value="/talk/talkdelete" />" method="POST">
		<input size="1" name="tNumber" value="${tNumber}"/>
		번글을 삭제하시겠습니까?<br>
		닉네임<input name="name" />
		<input type="submit" value="삭제">
		<a href="<c:url value="/talk/talkdetail/${tNumber}" />">취소</a>
	</form>
	<div>${msg}</div>
</body>
</html>
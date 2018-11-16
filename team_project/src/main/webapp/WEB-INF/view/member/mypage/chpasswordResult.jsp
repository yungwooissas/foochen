<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 변경</title>
</head>
<body>
	<h3>결과확인</h3>
	<c:if test="${result == 1 }">
		<label>변경</label>
	</c:if>
	<c:if test="${result == 0 }">
		<label>비밀번호가 틀렸습니다</label>
	</c:if>
	<br>
	<a href="<c:url value='/mypage'/>">[돌아가기]</a>
	
</body>
</html>
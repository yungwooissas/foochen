<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정 결과 화면</title>
</head>
<body>

	<c:if test="${result == 1 }">
		<label>수정 성공</label>
	</c:if>
	<c:if test="${result == 0 }">
		<label>수정 실패</label>
	</c:if>

	<a href="<c:url value='/mypage'/>">[돌아가기]</a>

</body>
</html>
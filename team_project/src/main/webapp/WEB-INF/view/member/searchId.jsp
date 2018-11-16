<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디찾기</title>
</head>
<body>
	<form method="post">
		<p> 핸드폰번호를 입력하세요 : 
			<input type="tel" name="phone"><br>
		
		<c:if test="${ !empty email }">
		<p>${ email }</p>
		</c:if>
	<div>
		<a href="<c:url value='/main' />">[ 메인으로 ]</a>
		<a href="<c:url value='/login' />">[ 로그인으로 ]</a>
		<input type="submit" value="확인">
	</div>
	</form>
</body>
</html>
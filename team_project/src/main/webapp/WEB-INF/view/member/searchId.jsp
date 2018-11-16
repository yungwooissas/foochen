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
			<input type="submit" value="확인"></p>
		
		<c:if test="${ !empty email }">
		<p>${ email }</p>
		</c:if>
		
		<p><a href="<c:url value='/member/login' />">[ 로그인 ]</a></p>
		<p><a href="<c:url value='/member/main' />">[ 돌아가기 ]</a></p>
	</form>
</body>
</html>
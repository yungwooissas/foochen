<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>
</head>
<body>
	<c:if test="${ empty userInfo }">
		<p>환영합니다.</p>
		<p><a href="<c:url value='/member/register'/>">[ 회원가입 ]</a></p>
		<p><a href="<c:url value='/member/login' />">[ 로그인 ]</a></p>
		<p><a href="<c:url value='/member/searchId' />">[ id찾기 ]</a></p>
		<p><a href="<c:url value='/member/searchPassword' />">[ password찾기 ]</a></p>
	</c:if>
	
	<c:if test="${ !empty userInfo }">
		<p>${ userInfo.name }님 환영합니다</p>
		<p><a href="<c:url value='/member/logout' />">[ 로그아웃 ]</a></p>
		<p><a href="<c:url value='/member/out' />">[ 회원탈퇴 ]</a></p>
	</c:if>
</body>
</html>
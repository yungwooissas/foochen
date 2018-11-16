<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<style>
.nav {
	padding: 20px;
	margin: auto;
}

.ctest {
	background-color: white;
	margin: auto;
	width: 500px;
	padding: 20px;
}

.title {
	width: 150px;
}
</style>

</head>

<body>
	<div class="nav" align="center">
		<c:if test="${ empty userInfo }">
			<p>환영합니다.</p>
			<p>
				<a href="<c:url value='/register'/>">[ 회원가입 ]</a>
			</p>
			<p>
				<a href="<c:url value='/login' />">[ 로그인 ]</a>
			</p>
		</c:if>

		<c:if test="${ !empty userInfo }">
			<p>${ userInfo.name }님환영합니다</p>
			<p>
				<a href="<c:url value='/mypage' />">[ 마이페이지 ]</a>
			</p>
			<p>
				<a href="<c:url value='/logout' />">[ 로그아웃 ]</a>
			</p>
		</c:if>
	</div>
</body>
</html>
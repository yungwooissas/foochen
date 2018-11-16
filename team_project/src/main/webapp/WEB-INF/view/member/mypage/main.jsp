<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mypage</title>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<style>
.nav{
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
		<a href="<c:url value='/main'/>"><button type="button"
				class="btn btn-info">메인으로</button></a>&nbsp&nbsp&nbsp&nbsp
		<a href="<c:url value='/mypage/chpasswordStep1'/>"><button type="button"
				class="btn btn-info">비밀번호 변경</button></a>
	</div>
	<div class="ctest">
		<h3>
			<strong>${member.name }님 환영합니다.</strong>
		</h3>
		<table class="table table-condensed table-bordered">
			<tr>
				<td class="title">이름</td>
				<td>${member.name }</td>
			</tr>
			<tr>
				<td class="title">이메일</td>
				<td>${member.email }</td>
			</tr>
			<tr>
				<td class="title">등급</td>
				<td>${member.grade }</td>
			</tr>
			<tr>
				<td class="title">포인트</td>
				<td>${member.point }</td>
			</tr>
		</table>

		<a href="<c:url value='/mypage/modifyStep1'/>"><button type="button"
				class="btn btn-primary">정보수정</button></a> <a
			href="<c:url value='/mypage/out'/>"><button type="button"
				class="btn btn-danger">회원탈퇴</button></a>
	</div>
</body>
</html>
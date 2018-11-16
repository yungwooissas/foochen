<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 비밀번호 입력</title>
</head>
<body>
	<form method="post">
		<label>비밀번호 입력 : </label>
		<input type="password" name="tmppassword" />
		<input type="submit" value="입력"/>
		<br>
		<label style="color: red">${errormessage }</label>
	</form>
	<a href="<c:url value='/mypage'/>">[돌아가기]</a>
</body>
</html>
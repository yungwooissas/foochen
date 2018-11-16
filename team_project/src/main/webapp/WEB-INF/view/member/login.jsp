<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<form:form commandName="loginCommand">
		<form:errors />
		<p>
			<label> email : <form:input path="email" /> <form:errors
					path="email" />
			</label>
		</p>
		<p>
			<label> password : <form:password path="password" /> <form:errors
					path="password" />
			</label>
		</p>
		<p>
			<label> email 기억하기 <form:checkbox path="rememberEmail" />
			</label>
		</p>
		<p>
			<a href="<c:url value='/member/searchId' />">[ id찾기 ]</a>
		</p>
		<p>
			<a href="<c:url value='/member/searchPassword' />">[ password찾기 ]</a>
		</p>
	<a href="<c:url value='/register' />">[회원가입 ]</a>&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" value="확인" />
	</form:form>
</body>
</html>
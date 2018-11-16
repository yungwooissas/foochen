<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
		<label>
			email :
			<form:input path="email"/>
			<form:errors path="email" />
		</label>
	</p>
	<p>
		<label>
			password :
			<form:password path="password"/>
			<form:errors path="password" />
		</label>
	</p>
	<p>
		<label>
			email 기억하기
			<form:checkbox path="rememberEmail"/>
		</label>
	</p>
	<input type="submit" value="확인" />">
	<input type="button" value="회원가입">	
</form:form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>패스워드찾기</title>
</head>
<body>
	<form:form commandName="searchPasswordCommand" method="POST">
	<p>
	이메일 입력하세요 :
	<form:input path="email"/>
	</p>
	<p>
	이름 입력하세요 : 
	<form:input path="name"/>
	</p>
	<p>
	핸드폰번호 입력하세요 :
	<form:input path="phone"/>
	</p>
	<br><br><br>
	<c:if test="${ !empty searchPasswordCommand.password }">
		<p>비번은 : ${ searchPasswordCommand.password }</p>
	</c:if>
	
	<div>
		<input type="submit" value="확인">
		<a href="<c:url value='/member/main' />">[ 메인으로 돌아가기 ]</a>
		<a href="<c:url value='/member/login' />">[ 로그인 ]</a>
	</div>
	</form:form>
</body>
</html>
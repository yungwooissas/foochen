<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴</title>
</head>
<body>
	<form:form commandName="outCommand" method="POST">
	<table border="1">
	<tr>
		<th><form:label path="password">비밀번호 : </form:label></th>
		<td><form:password path="password"/></td>
	</tr>
	</table>
	<div>
		<input type="submit" value="탈퇴고고">
		<a href="<c:url value='/member/main' />">[ 탈퇴안할래영 ]</a>
	</div>
	</form:form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
</head>
<body>
	<label>회원 정보 수정</label>
	<form action="modifyResult" method="post" name="member">
	<input type="hidden" name="email" value="${member.email }">
	<table>
		<tr>
			<td>휴대폰 번호</td>
			<td><input type="text" value="${member.phone }" name="phone" required>
		</tr>
		<tr>
			<td>성별</td>
			<c:if test="${member.gender eq 0 }">
			<td><input type="text" value="남자" readonly required>
			</c:if>
			<c:if test="${member.gender eq 1 }">
			<td><input type="text" value="여자" readonly required>
			</c:if>
		</tr>
		<tr>
			<td>생일</td>
			<td><input type="text" value="${member.birth }" readonly required>
		</tr>
		<tr>
			<td>기호1</td>
			<td><input type="text" value="${member.like1 }" name="like1" required>
		</tr>
		<tr>
			<td>기호2</td>
			<td><input type="text" value="${member.like2 }" name="like2" required>
		</tr>
		
		<tr>
			<td><input type="submit" value="수정">
			<td><a href="<c:url value='/mypage'/>">[돌아가기]</a></td>
			
		</tr>
	</table>
	</form>
</body>
</html>
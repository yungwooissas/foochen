<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>톡게시판 수정</title>
</head>
<body>
	<form:form commandName="talkDto" method="POST">
		<table border="1">
			<tr>
				<th><form:label path="name">작성자</form:label></th>
				<td><form:input path="name" />
				<form:errors path="name" /></td>
			</tr>
			<tr>
				<th><form:label path="tImage">사진</form:label></th>
				<td><form:input type="file" path="tImage" />
				<form:errors path="tImage" />
			</tr>
			<tr>
				<th><form:label path="talk">내용</form:label></th>
				<td><form:input path="talk" />
				<form:errors path="talk" />
				</td>
			</tr>
		</table>
		<div>
			<input type="submit" value="등록"> <a
				href="<c:url value="/talk/talklist" />">목록</a>
		</div>
	</form:form>
</body>
</html>
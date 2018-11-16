<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 변경</title>
<script src="//code.jquery.com/jquery-3.2.1.min.js"></script>
<script>
	$(document).ready(function() {
		$("input").keyup(function(){
            var pwd1=$("#pwd1").val();
            var pwd2=$("#pwd2").val();
            if(pwd1 != "" || pwd2 != ""){
                if(pwd1 == pwd2){
                    $("#message").html("비밀번호 확인이 일치합니다.");
                    $("#submit").removeAttr("disabled");
                }else{
                    $("#message").html("비밀번호 확인이 일치하지않습니다.");
                    $("#submit").attr("disabled", "disabled");
                }    
            }
        });
	})
</script>
</head>
<body>
	<form action="chpasswordResult" method="post" name="changePassword">
		<input type="hidden" name="email" value="${member.email }">
		<table>
			<tr>
				<td>현재 비밀번호 :</td>
				<td><input type="password" name="nowPassword" required /></td>
			</tr>
			<tr>
				<td>새 비밀번호 :</td>
				<td><input type="password" name="newPassword" id="pwd1" required/></td>
			</tr>
			<tr>
				<td>새 비밀번호 확인 :</td>
				<td><input type="password" name="newPasswordConfirm" id="pwd2" required/></td>
			</tr>
			<tr>
				<td colspan="2"><label style="color: red" id="message">${errormessage }</label></td>
			</tr>
			<tr>
				<td><input type="submit" value="변경" id="submit" disabled="disabled"></td>
				<td><a href="<c:url value='/mypage'/>">[돌아가기]</a></td>
			<tr>
		</table>
	</form>
</body>
</html>
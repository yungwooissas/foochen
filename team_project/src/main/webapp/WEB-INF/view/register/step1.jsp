<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<style>
.regist {
	padding: 20px;
	margin: auto;
	width: 500px;
}
</style>
</head>
<body>
	<div class="regist">
		<h2>회원 정보 입력</h2>
		<form action="regResult" method="post" name="regist">
			ID(이메일) : <input type="text" name="email" id="email"
				value="${regData.email}" required="required" /><br>
			<button type="button" class="emailCheck">이메일 확인</button>

			<p class="result">
				<span class="msg">아이디를 확인해주십시오.</span>
			</p>

			비밀번호 : <input type="password" name="password"
				value="${regData.password}" required="required" /><br> 비밀번호
			확인: <input type="password" name="confirmPassword" required="required" /><br>
			이름 :<input type="text" name="name" value="${regData.name}"
				required="required" /><br> 핸드폰 : <input type="text"
				name="phone" value="${regData.phone}" placeholder="010-0000-0000"
				required="required" /> 성별 : <label><input type="radio"
				name=gender value="0" /> 남자</label> <label><input type="radio"
				name="gender" value="1" />여자</label><br> 생일 : <input type="text"
				name="birth" value="${regData.birth}" placeholder="ex)990101" /><br>
			회원님의 선호요리 : <label><input type="radio" name="like1"
				value="한식" required="required" />한식</label>
			<!-- 일단 1나만 선택으로~  -->
			<label><input type="radio" name="like1" value="중식"
				required="required" />중식</label> <label><input type="radio"
				name="like1" value="양식" required="required" />양식</label> <label><input
				type="radio" name="like1" value="일식" required="required" />일식</label> <label><input
				type="radio" name="like1" value="분식" required="required" />분식</label> <br>


			밥부터 디저트까지 : <label><input type="radio" name="like2"
				value="메인" required="required" />메인요리</label>
			<!-- 일단 1나만 선택으로~  -->
			<label><input type="radio" name="like2" value="디저트"
				required="required" />디저트</label> <label><input type="radio"
				name="like2" value="에피타이저" required="required" />에피타이저</label> <label><input
				type="radio" name="like2" value="반찬" required="required" />반찬</label> <label><input
				type="radio" name="like2" value="찌개" required="required" />찌개</label> <br>
			like3 : <label><input type="radio" name="like3" value="1"
				required="required" />1</label>
			<!-- 일단 1나만 선택으로~  -->
			<label><input type="radio" name="like3" value="2"
				required="required" />2</label> <label><input type="radio"
				name="like3" value="3" required="required" />3</label> <label><input
				type="radio" name="like3" value="4" required="required" />4</label> <label><input
				type="radio" name="like3" value="5" required="required" />5</label> <br>

			<a href="<c:url value='/main' />">[메인으로 ]</a> <br> <input
				type="reset" value="다시작성"> <input type="submit" value="회원가입">

		</form>
	</div>
	<script>
		$(".emailCheck").click(function() {

			var query = {
				email : $("#email").val()
			};

			$.ajax({
				url : "/testfoochen/emailCheck",
				type : "post",
				data : query,
				success : function(data) {

					if (data == 1) {
						$(".result .msg").text("사용 불가");
						$(".result .msg").attr("style", "color:#f00");
					} else {
						$(".result .msg").text("사용 가능");
						$(".result .msg").attr("style", "color:#00f");
					}
				}
			}); // ajax 끝
		});
	</script>


</body>
</html>
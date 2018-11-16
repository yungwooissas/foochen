<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항</title>
</head>
<body>
<section>
<b>공지사항</b>
<c:if test="${msg != null }">
	${msg}
</c:if>
<c:if test="${count == 0}">
<table>
	<tr>
		<td>
			게시판에 저장된 글이 없습니다.
		</td>
	</tr>
</table>
</c:if>
	<table border="1">
		<tr>
			<th>NO</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
		</tr>
		<c:forEach var="qna" items="${qnaList }" varStatus="loop">
			<tr>
				<td>${qna.qNumber }</td>
				<td><a href="<c:url value="/qna/read/${qna.qNumber }" />">${qna.qTitle }</a></td>
				<td>${qna.qame}</td>
				<td><fmt:formatDate value="${qna.qDate }" pattern="yyyy.MM.dd"/></td>
			</tr>
		</c:forEach>
	</table>
	<c:if test="${approval == 'approval'}">
		<a href="<c:url value="/qna/write"/>">새글</a>
	</c:if>
	<c:set var="pageNum" value="${pageNum}"/>
	<!-- 페이징 부분 -->
<c:if test="${count > 0 }">
	<!-- 컨트롤러에서 가져옴 (전체 글개수 / 한페이지 수 나머지가 0이면 0 아니면 1을 imsi에 넣는다.-->
		<c:set var="imsi" value="${count % pageSize == 0 ? 0 : 1 }"/> 
	<!-- 전체 글개수 / 한페이지 수 더하기 imsi -->
		<fmt:parseNumber var="pageCount" value="${count / pageSize + imsi }" integerOnly="true"/>
	<!-- 페이징 한번에 몇개 출력시키나? 밑에 페이지 숫자 나오는 개수 -->
		<c:set var="pageBlock" value="${3 }"/>
	<!-- 컨트롤러에서 가져온 현재 페이지 나누기 페이지 블럭을 result에 넣음 무조건 정수 형태 -->
		<fmt:parseNumber var="result" value="${currentPage / pageBlock }" integerOnly="true"/>
		<c:if test="${currentPage % pageBlock == 0 }">
			<fmt:parseNumber var="result" value="${currentPage/pageBlock -1}" integerOnly="true"/>
		</c:if>
	<!-- 현제페이지가 있는 곳을 기준으로 시작페이지와 끝페이지 계산 -->
		<c:set var="startPage" value="${result * pageBlock + 1 }"/>
		<c:set var="endPage" value="${startPage +pageBlock - 1 }"/>
	<!-- 위에서 계산한 끝페이지가 페이지 총 개수보다 적으면 마지막페이지로 페이지 개수를 정함 -->
		<c:if test="${endPage > pageCount }">
			<c:set var="endPage" value="${pageCount }"/>
		</c:if>
	<!-- 시작페이지가 페이지 블락보다 크면 이전 버튼 나오고 누르면 시작페이지 전페이지로 이동 -->
		<c:if test="${startPage > pageBlock }">
		
			<a href="${pageContext.request.contextPath}/qna/list?pageNum=${startPage - 1}">이전</a>
		</c:if>
	<!-- 시작페이지 부터 끝페이지 까지 반복해서 페이지 숫자 출력, 그 페이지 누르면 이동 -->
		<c:forEach var = "i" begin="${startPage }" end="${endPage }">
			<a href="${pageContext.request.contextPath}/qna/list?pageNum=${i }">[${i }]</a>
		</c:forEach>
	<!-- 끝페이지가 페이지 숫자보다 작으면 다음버튼 나온다. 그 버튼 누르면 시작페이지 + 1으로 이동 -->
		<c:if test="${endPage < pageCount }">
			<a href="${pageContext.request.contextPath}/qna/list?pageNum=${endPage + 1}">다음</a>
	</c:if>
</c:if>
</section>
</body>
</html>
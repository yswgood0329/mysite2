<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%pageContext.setAttribute("newline", "\n");%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.servletContext.contextPath }/assets/css/board.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<jsp:include page="/WEB-INF/views/includes/header.jsp"/>
		<div id="content">
			<div id="board" class="board-form">
				<table class="tbl-ex">
				<c:set var="vo" value="${vo }"/>
					<tr>
						<th colspan="2">글보기</th>
					</tr>
					<tr>
						<td class="label" >제목</td>
						<td>${vo.title }</td>
					</tr>
					<tr>
						<td class="label">내용</td>
						<td>
							<div class="view-content">
								${fn:replace(vo.context, newline, "<br>") }
							</div>
						</td>
					</tr>
				</table>
			
				<div class="bottom">
						<a href="${pageContext.servletContext.contextPath }/board">글목록</a>
						<c:if test="${authuser.no eq vo.userNo }">
							<a href="${pageContext.servletContext.contextPath }/board?a=modifyform&no=${vo.no }">글수정</a>
						</c:if>
						<a href="${pageContext.servletContext.contextPath }/board?a=commentform&no=${vo.no }">답글</a>
				</div>
				<table width=550 height=30 border=1>
					<tr>
						<td>댓글을 입력하세요</td>
					</tr>
				</table><br/>
				<table width=550>
					<tr border=1>
						<td colspan=3 bgcolor="#F2F3F5" >이름 내용</td>
					</tr>
					<tr height=5px>
						<td width=10%>좋아요</td>
						<td width=15%>답글 달기</td>
						<td>시간</td>
					</tr>
				</table>
				
			</div>
		</div>
		<jsp:include page="/WEB-INF/views//includes/navigation.jsp"/>
		<jsp:include page="/WEB-INF/views//includes/footer.jsp"/>
	</div>
</body>
</html>
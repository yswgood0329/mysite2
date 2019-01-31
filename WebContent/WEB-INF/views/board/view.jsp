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
				<!-- <p>${param.pageNo } : ${param.sqlNo } : ${pageCount } : ${pages } : ${nowPage } : ${maxPage }</p> -->
				<div class="bottom">
						<a href="${pageContext.servletContext.contextPath }/board?pageNo=0&sqlNo=0">글목록</a>
						<c:if test="${authuser.no eq vo.userNo }">
							<a href="${pageContext.servletContext.contextPath }/board?a=modifyform&no=${vo.no }">글수정</a>
							<a href="${pageContext.servletContext.contextPath }/board?a=replyform&no=${vo.no }">답글</a>
						</c:if> <!-- 답글도 로그인을 해야 작성할수 있도록 수정 (옆의 if문을 한칸 아래로 옮기면 됨!!!) -->
						
				</div>
				<form class="" method="post" action="${pageContext.servletContext.contextPath }/board?a=view&no=${vo.no}&userNo=${authuser.no }">
					<table width=550 height=30>
						<tr>
							<c:if test="${not empty authuser.no}">
								<td><input type="text" name="comment_content" value="" size="70%"></td>
								<td width=8%><input type="submit" value="등록"></td>
							</c:if>
						</tr>
					</table><br/>
					<table width=550>
						<c:forEach items="${list }" var="comment_vo" varStatus="status">
							<tr border=1>
								<td height=25 colspan=3 bgcolor="#F2F3F5" >${comment_vo.userName } ${comment_vo.content }</td>
							</tr>
							<tr height=5px>
								<td width=10%><a href="${pageContext.servletContext.contextPath }/board?a=view&no=${vo.no}&commentNo=${comment_vo.no }">좋아요</a> ${comment_vo.good }</td>
								<td>${comment_vo.writeDate }</td>
								<c:if test="${authuser.name eq comment_vo.userName }">
									<td><a href="${pageContext.servletContext.contextPath }/board?a=view&no=${vo.no}&commentNo=${comment_vo.no }&aa=delete">삭제</a></td>
								</c:if>
							</tr>
						</c:forEach>
					</table>
				</form>
			</div>
		</div>
		<jsp:include page="/WEB-INF/views//includes/navigation.jsp"/>
		<jsp:include page="/WEB-INF/views//includes/footer.jsp"/>
	</div>
</body>
</html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="<%=request.getContextPath() %>/assets/css/board.css" rel="stylesheet" type="text/css">
<style>

	

</style>
</head>
<body>
	<div id="container">
		<jsp:include page="/WEB-INF/views/includes/header.jsp"/>
		<div id="content">
			<div id="board">
				<form id="search_form" action="${pageContext.servletContext.contextPath }/board?a=find" method="post">
					<select name="find">
						<option value="all">전체</option>
						<option value="title">제목</option>
						<option value="content">내용</option>
						<option value="user">작성자</option>
					</select>
					<input type="text" id="kwd" name="kwd" value="">
					<input type="submit" value="찾기">
				</form>
				<table class="tbl-ex">
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>글쓴이</th>
						<th>조회수</th>
						<th>작성일</th>
						<th>&nbsp;</th>
					</tr>
					
					<c:set var="count" value="${fn:length(list) }"/>
					
					<c:forEach items="${list }" var="vo" varStatus="status">
					<tr>
						<td>${count - status.index }</td>
						<td style="padding-left:${25*(vo.depth) }px; text-align:left;">
						<c:if test="${vo.orderNo ne 1 }">
							<img src="/mysite2/assets/images/reply.png" style="width:10px">
						</c:if>
						<a href="${pageContext.servletContext.contextPath }/board?a=view&no=${vo.no}">${vo.title }</a></td>
						<td>${vo.userNo }</td> <!-- 이부분 수정 해야 합니다. user name이 나오도록 해야 합니다. -->
						<td>${vo.hit }</td>
						<td>${vo.writeDate }</td>
						<td>
						<%-- 이부분 수정 해야 됩니다. --%>
						<%-- 조회수도 수정 해야 됩니다. --%>
						<c:if test="${authuser.no eq vo.userNo }">
							<a href="${pageContext.servletContext.contextPath }/board?a=deleteform&no=${vo.no }" class="del"><img src="/mysite2/assets/images/recycle.png"></a></td>
						</c:if>
					</tr>
					</c:forEach>
				</table>
				
				<!-- pager 추가 -->
				<div class="pager">
					<ul>
						<li class="selected"><a href="${pageContext.servletContext.contextPath }/board">◀</a></li>
						<li class="selected"><a href="${pageContext.servletContext.contextPath }/board">1</a></li>
						<li class="selected"><a href="${pageContext.servletContext.contextPath }/board">2</a></li>
						<li class="selected"><a href="${pageContext.servletContext.contextPath }/board">3</a></li>
						<li class="selected"><a href="${pageContext.servletContext.contextPath }/board">4</a></li>
						<li class="selected"><a href="${pageContext.servletContext.contextPath }/board">5</a></li>
						<li class="selected"><a href="${pageContext.servletContext.contextPath }/board">▶</a></li>
					</ul>
				</div>					
				<!-- pager 추가 -->
				
				<div class="bottom">
					<a href="${pageContext.servletContext.contextPath }/board?a=writeform" id="new-book">글쓰기</a>
				</div>				
			</div>
		</div>
		<jsp:include page="/WEB-INF/views//includes/navigation.jsp"/>
		<jsp:include page="/WEB-INF/views//includes/footer.jsp"/>
	</div>
</body>
</html>
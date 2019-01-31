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
					<input type="hidden" name="pageNo" value="0">
					<input type="hidden" name="sqlNo" value="0">
					<input type="text" id="kwd" name="kwd" value="${param.kwd }">
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
					
					<c:set var="count" value="${pageCount }"/>
					
					<c:forEach items="${list }" var="vo" varStatus="status">
					<tr>
						<td>${count - (param.sqlNo * 10) - status.index }</td>
						<td style="padding-left:${25*(vo.depth) }px; text-align:left;">
						<c:if test="${vo.orderNo ne 1 }">
							<img src="/mysite2/assets/images/reply.png" style="width:10px">
						</c:if>
						<a href="${pageContext.servletContext.contextPath }/board?a=view&no=${vo.no}">${vo.title }</a></td>
						<td>${vo.context }</td> <!-- 이부분 수정 해야 합니다. user name이 나오도록 해야 합니다. -->
						<td>${vo.hit }</td>
						<td>${vo.writeDate }</td>
						<td>
						<%-- 이부분 수정 해야 됩니다. --%>
						<%-- 조회수도 수정 해야 됩니다. --%>
							<c:if test="${authuser.no eq vo.userNo }">
								<a href="${pageContext.servletContext.contextPath }/board?a=deleteform&no=${vo.no }" class="del"><img src="/mysite2/assets/images/recycle.png"></a>
							</c:if>
						</td>
					</tr>
					</c:forEach>
				</table>
				
				<!-- pager 추가 -->
				<div class="pager">
				
					<ul>
						<c:choose>
							<c:when test="${param.pageNo eq 0 }">
								<li class="none-selected">
									<p>◀</p>
								</li>
							</c:when>
							<c:otherwise>
								<li class="selected"><a href="${pageContext.servletContext.contextPath }/board?pageNo=${param.pageNo - 5 }&sqlNo=${param.pageNo-5 }&find=${param.find }&kwd=${param.kwd }">◀</a></li>
							</c:otherwise>
						</c:choose>
						<fmt:parseNumber var="pages" integerOnly="true" value="${(pageCount-1)/10 }"/>
						
						<c:forEach var="i" begin="0" end="4" step="1">
							<c:choose>
							
								<c:when test="${pages >= param.pageNo + i }">
									<c:choose>
										<c:when test="${param.sqlNo+1 == param.pageNo+i+1 }">
											<li class="selected_now">
												<p>${param.pageNo+i+1 }</p>
											</li>
										</c:when>
										<c:otherwise>
											<li class="selected">
												<a href="${pageContext.servletContext.contextPath }/board?pageNo=${param.pageNo }&sqlNo=${param.pageNo + i }&find=${param.find }&kwd=${param.kwd }">${param.pageNo+i+1 }</a>
											</li>
										</c:otherwise>
									</c:choose>
								</c:when>
								
								<c:otherwise>
									<li class="none-selected">
										<p>${param.pageNo+i+1 }</p>
									</li>
								</c:otherwise>
								
							</c:choose>
						</c:forEach>
						<fmt:parseNumber var="maxPage" integerOnly="true" value="${pages/10 }"/>
						<fmt:parseNumber var="nowPage" integerOnly="true" value="${param.sqlNo/10 }"/>
						
						<c:choose>
							<c:when test="${maxPage > nowPage }">
								<li class="selected"><a href="${pageContext.servletContext.contextPath }/board?pageNo=${param.pageNo + 5 }&sqlNo=${param.pageNo+5 }&find=${param.find }&kwd=${param.kwd }">▶</a></li>
							</c:when>
							<c:otherwise>
								<li class="none-selected">
									<p>▶</p>
								</li>
							</c:otherwise>
						</c:choose>
						
					</ul>
					<!--  <p>${param.pageNo } : ${param.sqlNo } : ${pageCount } : ${pages } : ${nowPage } : ${maxPage }</p> -->
				
				</div>					
				<!-- pager 추가 -->
				<c:if test="${not empty authuser }">
					<div class="bottom">
						<a href="${pageContext.servletContext.contextPath }/board?a=writeform" id="new-book">글쓰기</a>
					</div>
				</c:if>				
			</div>
		</div>
		<jsp:include page="/WEB-INF/views//includes/navigation.jsp"/>
		<jsp:include page="/WEB-INF/views//includes/footer.jsp"/>
	</div>
</body>
</html>
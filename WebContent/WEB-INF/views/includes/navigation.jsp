<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="navigation">
			<ul>
				<li><a href="<%= request.getContextPath()%>">홈</a></li>
				<li><a href="<%= request.getContextPath()%>">Ballboy</a></li>
				<li><a href="<%= request.getContextPath()%>/guestbook?a=guestbook">방명록</a></li>
				<li><a href="<%= request.getContextPath()%>/board">게시판</a></li>
			</ul>
		</div>
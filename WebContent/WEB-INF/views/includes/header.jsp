<%@page import="com.douzone.mysite.vo.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="header">
			<h1>MySite</h1>
			<ul>
				<%
					UserVo authUser = (UserVo)session.getAttribute("authuser");
					// System.out.println(authUser.toString());
					if(null == authUser){
						
				%>
						<li><a href="<%= request.getContextPath()%>/user?a=loginform">로그인</a><li>
						<li><a href="<%=request.getContextPath()%>/user?a=joinform">회원가입</a><li>
				<%	} else { %>
						<li><a href="<%=request.getContextPath()%>/user?a=modifyform">회원정보수정</a><li>
						<li><a href="<%=request.getContextPath()%>/user?a=logout">로그아웃</a><li>
						<li><%=authUser.getName() %>님 안녕하세요 ^^;</li>
						
				<%
					}
				%>
			</ul>
		</div>
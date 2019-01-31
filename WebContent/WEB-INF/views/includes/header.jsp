<%@page import="com.douzone.mysite.vo.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="header">

			<h1><a href="<%= request.getContextPath()%>">승우의 프로그래밍 세상</a></h1>
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
						<li><%=authUser.getName() %>님 반갑습니다. </li>
						
				<%
					}
				%>
			</ul>
		</div>
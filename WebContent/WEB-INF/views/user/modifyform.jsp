<%@page import="com.douzone.mysite.vo.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="<%= request.getContextPath()%>/assets/css/user.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<jsp:include page="/WEB-INF/views/includes/header.jsp"/>
		<div id="content">
			<div id="user">

				<form id="join-form" name="joinForm" method="post" action="<%=request.getContextPath() %>/user">
					<input type="hidden" name = "a" value = "modify"/>
					
					<label class="block-label" for="name">이름</label>
					<input id="name" name="name" type="text" value="">
					
					<% UserVo authUser = (UserVo)session.getAttribute("authuser"); %>
					
					<label class="block-label" for="email">이메일</label>
					<input type="hidden" name="email" value=<%= authUser.getEmail() %>/>
					<h3><%= authUser.getEmail() %></h3>
					
					<input type="hidden" name="no" value=<%= authUser.getNo() %>/>
					
					<label class="block-label">패스워드</label>
					<input name="password" type="password" value="">
					
					<fieldset>
						<legend>성별</legend> <%-- if문을 사용해서 사용자의 성별을 기본 체크로 수정 --%>
						<label>여</label> <input type="radio" name="gender" value="female" checked="checked">
						<label>남</label> <input type="radio" name="gender" value="male">
					</fieldset>
					
					<input type="submit" value="수정하기">
					
				</form>
			</div>
		</div>
		<jsp:include page="/WEB-INF/views//includes/navigation.jsp"/>
		<jsp:include page="/WEB-INF/views//includes/footer.jsp"/>
	</div>
</body>
</html>
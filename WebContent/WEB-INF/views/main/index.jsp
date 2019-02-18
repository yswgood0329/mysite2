<%@page import="com.douzone.mysite.vo.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title></title>
        <link type="text/css" rel="stylesheet" href="${pageContext.servletContext.contextPath }/assets/css/css3DLayerd.css">
        <link type="text/css" rel="stylesheet" href="${pageContext.servletContext.contextPath }/assets/css/header.css">
        <link type="text/css" rel="stylesheet" href="${pageContext.servletContext.contextPath }/assets/css/footer.css">
        <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
              rel="stylesheet"
              integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
              crossorigin="anonymous">
    </head>
    <body>
        <div class="header">
            <ul>
            	<%
					UserVo authUser = (UserVo)session.getAttribute("authuser");
					// System.out.println(authUser.toString());
					if(null == authUser){
						
				%>
                <li><a href="<%=request.getContextPath()%>/user?a=joinform">
                    <span>회원가입</span>
                </a></li>
                <li><a href="<%= request.getContextPath()%>/user?a=loginform"">
                    <span>로그인</span>
                </a></li>
                <%	} else { %>
                <li><span><%=authUser.getName() %></span></li>
                <li><a href="<%=request.getContextPath()%>/user?a=modifyform">
                    <span>정보수정</span>
                </a></li>
                <li><a href="<%=request.getContextPath()%>/user?a=logout">
                    <span>로그아웃</span>
                </a></li>
                
                <%
					}
				%>
            </ul>
        </div>
        <div class="navigator">
        <ul>
            <li><a href="index2.jsp">
                <span></span>
                <span></span>
                <span></span>
                <span></span>
                <span class="fa fa-home" aria-hidden="true"></span>
            </a></li>
            <li><a href="<%= request.getContextPath()%>/guestbook?a=guestbook">
                <span></span>
                <span></span>
                <span></span>
                <span></span>
                <span class="fa fa-comment" aria-hidden="true"></span>
            </a></li>
            <li><a href="<%= request.getContextPath()%>/guestbook?a=ajax">
                <span></span>
                <span></span>
                <span></span>
                <span></span>
                <span class="fa fa-comment" aria-hidden="true"></span>
            </a></li>
            <li><a href="<%= request.getContextPath()%>/board?pageNo=0&sqlNo=0">
                <span></span>
                <span></span>
                <span></span>
                <span></span>
                <span class="fa fa-newspaper-o" aria-hidden="true"></span>
            </a></li>
            <li><a href="http://github.com/yswgood0329">
                <span></span>
                <span></span>
                <span></span>
                <span></span>
                <span class="fa fa-github" aria-hidden="true"></span>
            </a></li>
        </ul>
        </div>
        <div class="footer">
            <span>Copyleft (o) 2018 All Wrongs Reserved</span>
        </div>
    </body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.servletContext.contextPath }/assets/css/main.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<jsp:include page="/WEB-INF/views/includes/header.jsp"/>
		<div id="wrapper">
			<div id="content">
				<div id="site-introduction">
					<img id="profile" src="${pageContext.servletContext.contextPath }/assets/images/느려.PNG" style="width:200px">
					<h2>안녕하세요. 양승우의  mysite에 오신 것을 환영합니다.</h2>
					<p>
						이 사이트는 웹 프로그래밍 실습 과제 예제 사이트 입니다.<br>
						겁나 열심히 만들었구요.... 잘 봐주세요.....<br>
						그런데 로그인을 안하시면 글쓰기나 수정 아무것도 안되요<br><br>
						<strong><font size="4em" color="red">꼭 회원 가입 하시고 로그인 하셔야 됩니다.</font></strong><br><br>
						버튼도 없다고 기능 구현 안한거 <strong><font size="3em" color="red">절대</font></strong> 아닙니다.<br><br>
						<a href="${pageContext.servletContext.contextPath }/guestbook?a=guestbook">방명록</a>에 글 남기기<br>
					</p>
				</div>
			</div>
		</div>
		<jsp:include page="/WEB-INF/views//includes/navigation.jsp"/>
		<jsp:include page="/WEB-INF/views//includes/footer.jsp"/>
		
	</div>
</body>
</html>
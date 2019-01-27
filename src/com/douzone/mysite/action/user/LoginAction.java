package com.douzone.mysite.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.douzone.mvc.action.Action;
import com.douzone.mvc.util.WebUtils;
import com.douzone.mysite.repository.UserDao;
import com.douzone.mysite.vo.UserVo;

public class LoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		UserVo authUser = new UserDao().get(email, password);
		
		if(authUser == null) {
			System.out.println("인증 실패");
//			인증 실패
			request.setAttribute("result", "fail");
			WebUtils.forward(request, response, "/WEB-INF/views/user/loginform.jsp");
			return;
		}
		
//		인증성공 -> 인증처리 -> 로그인 성공
//		request.getSession(false);  // 없으면  null
		HttpSession session = request.getSession(true);
		
		session.setAttribute("authuser", authUser);
		
//		main redirect
		WebUtils.redirect(request, response, request.getContextPath());
	}

}

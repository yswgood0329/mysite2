package com.douzone.mysite.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.douzone.mvc.action.Action;
import com.douzone.mvc.util.WebUtils;

public class LogoutAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//세션 가져오기
		HttpSession session = request.getSession();
		
		// 로그 아웃 처리
		if(session != null && session.getAttribute("authuser") != null) {
			// 로그인된 상태에서 로그아웃 할 경우
			session.removeAttribute("authuser");
			session.invalidate();	// session 아이디 날리고 새로 만들어라 
		}
		
		WebUtils.redirect(request, response, request.getContextPath());
	}

}

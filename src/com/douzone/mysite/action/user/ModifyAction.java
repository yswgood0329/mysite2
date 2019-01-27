package com.douzone.mysite.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzone.mvc.action.Action;
import com.douzone.mvc.util.WebUtils;
import com.douzone.mysite.repository.UserDao;
import com.douzone.mysite.vo.UserVo;

public class ModifyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("email").replaceAll("/", "");
		String gender = request.getParameter("gender");
		long no = Long.parseLong(request.getParameter("no").replaceAll("/", ""));
		
		System.out.println(name + " : " + password + " : " + email + " : " + gender + " : " + request.getParameter("no"));
		
		UserVo vo = new UserVo (name, email, password, gender, no);
		
		new UserDao().Update(vo);
		WebUtils.redirect(request, response, request.getContextPath());

	}

}

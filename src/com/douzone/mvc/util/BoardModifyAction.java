package com.douzone.mvc.util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzone.mvc.action.Action;
import com.douzone.mysite.repository.BoardDao;

public class BoardModifyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		new BoardDao().modify(Long.parseLong(request.getParameter("no")), request.getParameter("title"), request.getParameter("content"));
		
		WebUtils.forward(request, response, "/board?a=view&no=" + request.getParameter("no"));

	}

}

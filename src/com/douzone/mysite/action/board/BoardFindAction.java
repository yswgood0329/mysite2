package com.douzone.mysite.action.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzone.mvc.action.Action;
import com.douzone.mvc.util.WebUtils;
import com.douzone.mysite.repository.BoardDao;
import com.douzone.mysite.vo.BoardVo;

public class BoardFindAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("find " + request.getParameter("find"));
		System.out.println("kwd " + request.getParameter("kwd"));
		
		List<BoardVo> list = new BoardDao().getTitleList(request.getParameter("find"), request.getParameter("kwd"));
		request.setAttribute("list", list);
		WebUtils.forward(request, response, "/WEB-INF/views/board/list.jsp");
	}

}


/*
select * from board



*/
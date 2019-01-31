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

public class BoardListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		List<BoardVo> list = new BoardDao().getTitleList(request.getParameter("find"), request.getParameter("kwd"), Integer.parseInt(request.getParameter("sqlNo")), false);
		
		int count = new BoardDao().getTitleList(request.getParameter("find"), request.getParameter("kwd"), Integer.parseInt(request.getParameter("sqlNo")), true).size();
		request.setAttribute("list", list);
		request.setAttribute("pageCount", count);
		
		System.out.println("list : " + list.toString());
		System.out.println("count : " + count);
		
		
		WebUtils.forward(request, response, "/WEB-INF/views/board/list.jsp");
	}

}

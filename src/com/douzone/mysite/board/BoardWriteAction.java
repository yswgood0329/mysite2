package com.douzone.mysite.board;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzone.mvc.action.Action;
import com.douzone.mvc.util.WebUtils;
import com.douzone.mysite.repository.BoardDao;
import com.douzone.mysite.vo.BoardVo;

public class BoardWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// userNo, title, content
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		long userNo = Long.parseLong(request.getParameter("userNo"));
		int groupNo = ("".equals(request.getParameter("op")))?0:Integer.parseInt(request.getParameter("op"));
		
		
		
		//new BoardDao().Write(new BoardVo(long no, String title, String context, String writeDate, int hit, int groupNo, int orderNo, int depth, long userNo));
		new BoardDao().Write(new BoardVo(0, title, content, (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date()), 0, groupNo, 0, 0, userNo));
		WebUtils.redirect(request, response, request.getContextPath());
	}

}

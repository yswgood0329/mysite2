package com.douzone.mysite.action.board;

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
		System.out.println("BoardWriteAction" + request.getParameter("gno") + " : " + request.getParameter("ono") + " : " + request.getParameter("depth"));
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int groupNo = ("".equals(request.getParameter("gno")))?1:Integer.parseInt(request.getParameter("gno"));
		int orderNo = ("".equals(request.getParameter("ono")))?1:Integer.parseInt(request.getParameter("ono"))+1;
		int depth = ("".equals(request.getParameter("depth")))?0:Integer.parseInt(request.getParameter("depth"))+1;
		long userNo = Long.parseLong(request.getParameter("userNo"));
		
//		System.out.println(title + " : " + content + " : " + groupNo + " : " + orderNo + " : " + depth + " : " + userNo);
		
		//new BoardDao().Write(new BoardVo(long no, String title, String context, String writeDate, int hit, int groupNo, int orderNo, int depth, long userNo));
		new BoardDao().Write(new BoardVo(title, content, 0, groupNo, orderNo, depth, userNo));
		WebUtils.redirect(request, response, request.getContextPath());
	}

}

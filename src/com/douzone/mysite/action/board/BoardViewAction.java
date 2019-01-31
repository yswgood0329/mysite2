package com.douzone.mysite.action.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzone.mvc.action.Action;
import com.douzone.mvc.util.WebUtils;
import com.douzone.mysite.repository.BoardDao;
import com.douzone.mysite.repository.CommentDao;
import com.douzone.mysite.vo.BoardVo;
import com.douzone.mysite.vo.CommentVo;

public class BoardViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
//		System.out.println("string : " + "".equals(request.getParameter("comment_content")));
//		System.out.println("null : " + (request.getParameter("comment_content") == null));
		String content = request.getParameter("comment_content");
		long no = Long.parseLong(request.getParameter("no"));
		if(!("".equals(content) || content == null)) {
			System.out.println("여기 작성" + request.getParameter("userNo"));
			new CommentDao().insertComment(content, no, Long.parseLong(request.getParameter("userNo")));
		} else if (request.getParameter("commentNo") != null){
			System.out.println("commentNo" + request.getParameter("commentNo"));
			new CommentDao().goodComment(Long.parseLong(request.getParameter("commentNo")));
		} else {
			System.out.println("여기 작성 ㄴㄴ");
		}
		if ("delete".equals(request.getParameter("aa"))){
			new CommentDao().deleteComment(Long.parseLong(request.getParameter("commentNo")), -1);
		}
		
		new BoardDao().hitUpdate(no);
		
//		System.out.println("no : " + no);
		
		BoardVo vo = new BoardDao().View(no);
		List<CommentVo> list = new CommentDao().getCommentList(no);
		
		request.setAttribute("vo", vo);
		request.setAttribute("list", list);
		
		WebUtils.forward(request, response, "/WEB-INF/views/board/view.jsp");

	}

}

package com.douzone.mysite.board;

import com.douzone.mvc.action.AbstractActionFactory;
import com.douzone.mvc.action.Action;

public class BoardActionFactory extends AbstractActionFactory {

	@Override
	public Action getAction(String actionName) {
		Action action = null;
		
		/*
		 * list		게시글 리스트 보기
		 * view		게시글 보기
		 * insert	게시글 추가
		 * delete	게시글 삭제
		 * modify	게시글 수정
		 */
		
		if("write".equals(actionName)) {
			action = new BoardWriteAction();
		} else if("writeform".equals(actionName)) {
			action = new BoardWriteFormAction();
		} else if("deleteform".equals(actionName)) {
			action = new BoardDeleteFormAction();
		} else if("delete".equals(actionName)) {
			action = new BoardDeleteAction();
		} else if("modifyform".equals(actionName)) {
			action = new BoardModifyFormAction();
		} else if("view".equals(actionName)) {
			action = new BoardViewAction();
		} else {	// list
			action = new BoardListAction();
		}
		
		return action;
	}

}

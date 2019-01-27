package com.douzone.mysite.action.guestbook;

import com.douzone.mvc.action.AbstractActionFactory;
import com.douzone.mvc.action.Action;

public class GuestBookActionFactory extends AbstractActionFactory {

	@Override
	public Action getAction(String actionName) {
		Action action = null;
		if("insert".equals(actionName)) {
			action = new GuestBookInsertAction();
		} else if("deleteform".equals(actionName)){
			action = new GuestBookDeleteFormAction();
		} else if("delete".equals(actionName)){
			action = new GuestBookDeleteAction();
		} else {
			action = new GuestBookListAction();
		}
		
		return action;
	}

}

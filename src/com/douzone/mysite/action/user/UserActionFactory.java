package com.douzone.mysite.action.user;

import com.douzone.mvc.action.AbstractActionFactory;
import com.douzone.mvc.action.Action;
import com.douzone.mysite.action.main.IndexAction;

public class UserActionFactory extends AbstractActionFactory {

	@Override
	public Action getAction(String actionName) {
		System.out.println("test userActionFactory");
		Action action = null;
		if("joinform".equals(actionName)){
			action = new JoinFormAction();
		} else if("join".equals(actionName)){
			action = new JoinAction();
		} else if("joinsuccess".equals(actionName)){
			action = new JoinSuccessAction();
		} else if("loginform".equals(actionName)){
			action = new LoginFormAction();
		} else if("login".equals(actionName)){
			action = new LoginAction();
		} else if("modifyform".equals(actionName)){
			action = new ModifyFormAction();
		} else if("modify".equals(actionName)){
			action = new ModifyAction();
		} else if("logout".equals(actionName)){
			action = new LogoutAction();
		} else if("ajax-checkemail".equals(actionName)){
			action = new AjaxCheckEmailAction();
		} else {
			action = new IndexAction();
		}
		return action;
	}

}

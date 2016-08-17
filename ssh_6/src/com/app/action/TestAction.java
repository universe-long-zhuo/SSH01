package com.app.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Scope("prototype")
@Controller("testAction")
public class TestAction extends ActionSupport{

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
	

}

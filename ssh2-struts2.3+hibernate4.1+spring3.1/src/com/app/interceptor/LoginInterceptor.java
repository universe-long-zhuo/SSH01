package com.app.interceptor;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

@SuppressWarnings("serial")
public class LoginInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession();
		String method = arg0.getInvocationContext().getName();
		
		if(session.getAttribute("username")==null && !"*LoginAction".equals(method)){
			session.invalidate();
			return "login";
		}
		return arg0.invoke();
	}

	
}

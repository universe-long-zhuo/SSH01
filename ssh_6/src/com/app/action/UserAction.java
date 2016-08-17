package com.app.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.app.SpringAnnotationDef;
import com.app.model.User;
import com.app.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Component
@Namespace("/")
public class UserAction extends ActionSupport{

    @Resource(name=SpringAnnotationDef.USER_SERVICE)
    private UserService service;
    
    private String name;
    
    private User user1;

    @Action(value="getUser",results = {@Result(name=SUCCESS,location = "/JSP/test1.jsp")})
    public String getUser(){
        User user = service.getUser(2);
        setUser1(service.getUser(2));
        name = user.getUsername();
        System.out.println("ÐÕÃû£º" + name);
        return SUCCESS;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getUser1() {
		return user1;
	}

	public void setUser1(User user1) {
		this.user1 = user1;
	}
}

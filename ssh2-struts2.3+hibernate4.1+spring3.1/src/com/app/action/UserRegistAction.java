package com.app.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.app.dao.UserDao;
import com.app.model.User;
import com.app.util.UtilTool;
import com.opensymphony.xwork2.ActionSupport;

/**
 * ÓÃ»§×¢²á
 * @author lbz
 *
 */
@Scope("prototype")
@SuppressWarnings("serial")
@ParentPackage("struts-default")
@Namespace("/")
@Results({ @Result(name="success",location="/login.jsp") })
public class UserRegistAction extends ActionSupport {
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private UtilTool tool;
	private User user;
	
	@Override
	@Action("userRegistAction")
	public String execute() throws Exception {
		String md5Pw = tool.md5(user.getPassword());
		user.setPassword(md5Pw);
		userDao.save(user);
		return SUCCESS;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}

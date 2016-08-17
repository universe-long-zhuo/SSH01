package com.app.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.app.dao.UserDao;
import com.app.util.UtilTool;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 验证用户登录
 * @author lbz
 *
 */
@SuppressWarnings("serial")
@ParentPackage("struts-default")
@Namespace("/")
@Results({ @Result(name="success",location="/JSP/center.jsp"),@Result(name="error",location="/login.jsp") })
public class UserLoginAction extends ActionSupport {
	
	private String username;
	
	private String password;
		
	@Autowired
	private UserDao userDao;
	@Autowired
	private UtilTool tool;
	
	@Override
	@Action("userLoginAction")
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		if(userDao.login(username, tool.md5(password))){
			request.getSession().setAttribute("username", username);
			return SUCCESS;
		}else{
			this.addFieldError("loginError","用户名或密码错误，请重新输入！");
			return ERROR;
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}

package com.app.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;

//import com.app.model.Page;
import com.app.util.PageBean;
import com.app.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Scope("prototype")
@ParentPackage("base-default")
@Namespace("/")
@Results({ @Result(name="success",location="/JSP/userList.jsp")})
public class ListUserAction extends ActionSupport {
	
	@Resource(name="userService")
	private UserService userService;
	
	private int page;
	private PageBean pageBean;
	
	public int getPage() {
		return page;
	}
	
	public void setPage(int page) {
		this.page = page;
	}
	
	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	@Action("listUserAction")
	public String execute() throws Exception{
		this.pageBean = userService.queryForPage(3, page);
		return SUCCESS;
	}

}

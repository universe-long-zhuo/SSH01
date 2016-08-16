package com.wyz.action;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.wyz.entities.BookInfo;
import com.wyz.service.BookService;
import com.wyz.utility.SitePage;

@SuppressWarnings("serial")
public class BookAction extends ActionSupport {
	
	private BookInfo bookInfo;
	private BookService bookService;
	private String page;
	public BookInfo getBookInfo() {
		return bookInfo;
	}
	public void setBookInfo(BookInfo bookInfo) {
		this.bookInfo = bookInfo;
	}
	public BookService getBookService() {
		return bookService;
	}
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	
	// 获取表列和分页
	@SuppressWarnings("unchecked")
	public String showAllRecord() {
		int size = 3;
		try {
			Integer.parseInt(this.getPage() + "");
		} catch (Exception e) {
			System.out.println("参数错误！");
			this.setPage("1");
		}
		SitePage sitePage = new SitePage();
		sitePage.setCurrentPage(Integer.parseInt(this.getPage() + ""));
		sitePage.setPageSize(3);
		sitePage.setPageUrl("showBook");
		sitePage.setRecordCount(this.bookService.getBookCount());
		try {
			ServletActionContext.getRequest().setAttribute("bookpage", sitePage.getPage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("list", this.bookService.showAll(Integer.parseInt(this.getPage() + ""), size));
		return SUCCESS;
	}

}

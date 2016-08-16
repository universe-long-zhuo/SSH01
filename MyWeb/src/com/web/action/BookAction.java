package com.web.action;

import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.web.bean.BookInfo;
import com.web.service.BookService;
import com.web.utiliy.SitePage;

@SuppressWarnings("serial")
public class BookAction extends ActionSupport {
	private BookInfo bookInfo;
	private BookService bookService;
	private int[] ids;
	private String page;
	
	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public int[] getIds() {
		return ids;
	}

	public void setIds(int[] ids) {
		this.ids = ids;
	}

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
	
	/**
	 * 保存记录
	 * @return
	 */
	public String save(){
		this.bookService.saveRecord(this.bookInfo);
		return SUCCESS;
	}
	
	/**
	 * 更新记录
	 */
	public String update(){
		this.bookService.updateRecord(bookInfo);
		return SUCCESS;
	}
	
	/**
	 * 删除一条记录
	 */
	public String del(){
		this.bookService.delRecord(bookInfo);
		return SUCCESS;		
	}
	
	/**
	 * 删除多条记录
	 */
	public String delAll(){
		this.bookService.delAll(ids);
		return SUCCESS;		
	}
	
	/**
	 * 查询一条记录
	 */
	public String showRecord(){
		bookInfo = this.bookService.showById(bookInfo.getId());
		return SUCCESS;
	}
	
	/**
	 * 显示所有记录
	 */
	@SuppressWarnings("unchecked")
	public String showAllRecord(){
		int size=3;
		try {
			Integer.parseInt(this.getPage()+"");
			
		} catch (Exception e) {
			System.out.println("参数错误！");
			this.setPage("1");
		}		
		SitePage sitePage = new SitePage();
		sitePage.setCurrentPage(Integer.parseInt(this.getPage()+""));
		sitePage.setPageSize(3);
		sitePage.setPageUrl("showBook");
		sitePage.setRecordCount(this.bookService.getBookCount());
		try {
			ServletActionContext.getRequest().setAttribute("bookpage", sitePage.getPage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("list", this.bookService.showAll(Integer.parseInt(this.getPage()+""),size));	
		return SUCCESS;
	}
}

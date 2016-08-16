package com.wyz.utility;
/**
 * 分页类
 *
 */
public class SitePage {
	private int pageCount;   //总共页数
	private int pageSize;    //每页显示数量
	private int recordCount; //记录总数
	private int currentPage; //当前页数
	private String pageUrl;  //当前url地址
	/**
	 * 默认构造器
	 */
	public SitePage() {
		this.pageCount = 0;
		this.pageSize = 3;
		this.recordCount = 0;
		this.currentPage = 1;
		this.pageUrl = "showBook";
	}
	/**
	 * 设置每页显示数量
	 * @param pageSize
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	/**
	 * 设置记录总数
	 * @param recordCount
	 */
	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}
	/**
	 * 设置当前页数
	 * @param currentPage
	 */
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	/**
	 * 设置当前url地址
	 * @param pageUrl
	 */
	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}
	/**
	 * 获取分页总数
	 * @return Integer
	 * @throws Exception
	 */
	private int getPageCount() throws Exception {
		//如果每页显示数量小于或等于0，抛出错误异常
		if(this.pageSize <= 0) {
			throw new Exception("每页显示数量必须大于零");
		}
		//计算分页总数
		if(this.recordCount % this.pageSize == 0)
			this.pageCount = this.recordCount / this.pageSize;
		else
			this.pageCount = this.recordCount / this.pageSize + 1;
		if(this.pageCount == 0) {
			this.pageCount = 1;
		}
		
		return this.pageCount;
	}
	/**
	 * 获得分页展示
	 * @return
	 * @throws Exception
	 */
	public String getPage() throws Exception {
		//获取分页总数
		getPageCount();
		String pageStr = "";
		//设置上一页
		if(this.currentPage > 1 && this.pageCount > 1) {
			pageStr += "<a href=\""+ this.pageUrl +"?page="+ (this.currentPage -1 ) +"\"><</a>";
		}
		else {
			pageStr += "<span class=\"disabled\"><</span>";
		}
		//中间页数
		for(int i = (this.currentPage - 6);i < (this.currentPage + 6);i++) {
			if(i > 0 && i <= this.pageCount) {
				if(this.currentPage == i) {
					pageStr += "<span class=\"current\">"+ i +"</span>";
				}
				else {
					pageStr += "<a href=\""+ this.pageUrl +"?page="+ i +"\">"+ i +"</a>";
				}
			}
		}
		//下一页
		if(this.currentPage < this.pageCount) {
			pageStr += "<a href=\""+ this.pageUrl +"?page="+ (this.currentPage + 1 ) +"\">></a>";
		}
		else {
			pageStr += "<span class=\"disabled\">></span>";
		}
		
		return pageStr;
	}
}

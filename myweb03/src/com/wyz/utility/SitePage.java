package com.wyz.utility;
/**
 * ��ҳ��
 *
 */
public class SitePage {
	private int pageCount;   //�ܹ�ҳ��
	private int pageSize;    //ÿҳ��ʾ����
	private int recordCount; //��¼����
	private int currentPage; //��ǰҳ��
	private String pageUrl;  //��ǰurl��ַ
	/**
	 * Ĭ�Ϲ�����
	 */
	public SitePage() {
		this.pageCount = 0;
		this.pageSize = 3;
		this.recordCount = 0;
		this.currentPage = 1;
		this.pageUrl = "showBook";
	}
	/**
	 * ����ÿҳ��ʾ����
	 * @param pageSize
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	/**
	 * ���ü�¼����
	 * @param recordCount
	 */
	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}
	/**
	 * ���õ�ǰҳ��
	 * @param currentPage
	 */
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	/**
	 * ���õ�ǰurl��ַ
	 * @param pageUrl
	 */
	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}
	/**
	 * ��ȡ��ҳ����
	 * @return Integer
	 * @throws Exception
	 */
	private int getPageCount() throws Exception {
		//���ÿҳ��ʾ����С�ڻ����0���׳������쳣
		if(this.pageSize <= 0) {
			throw new Exception("ÿҳ��ʾ�������������");
		}
		//�����ҳ����
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
	 * ��÷�ҳչʾ
	 * @return
	 * @throws Exception
	 */
	public String getPage() throws Exception {
		//��ȡ��ҳ����
		getPageCount();
		String pageStr = "";
		//������һҳ
		if(this.currentPage > 1 && this.pageCount > 1) {
			pageStr += "<a href=\""+ this.pageUrl +"?page="+ (this.currentPage -1 ) +"\"><</a>";
		}
		else {
			pageStr += "<span class=\"disabled\"><</span>";
		}
		//�м�ҳ��
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
		//��һҳ
		if(this.currentPage < this.pageCount) {
			pageStr += "<a href=\""+ this.pageUrl +"?page="+ (this.currentPage + 1 ) +"\">></a>";
		}
		else {
			pageStr += "<span class=\"disabled\">></span>";
		}
		
		return pageStr;
	}
}

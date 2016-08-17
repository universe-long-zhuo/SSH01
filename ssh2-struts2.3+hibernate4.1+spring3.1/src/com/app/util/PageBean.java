package com.app.util;

import java.util.List;

public class PageBean {
	
	//ĳһҳ�ļ�¼�б�
		@SuppressWarnings("rawtypes")
		private List list;
		
		
		private int allRow;          //�ܼ�¼��		
		private int totalPage;       //��ҳ��		
		private int currentPage;     //��ǰҳ		
		private int pageSize;        //ÿҳ��¼��	
		
		private boolean isFirstPage; //�Ƿ�Ϊ��һҳ	
		private boolean isLastPage;  //�Ƿ�Ϊ���һҳ		
		private boolean hasPrePage;  //�Ƿ���ǰһҳ
		private boolean hasNexPage;  //�Ƿ��к�һҳ
		
		@SuppressWarnings("rawtypes")
		public List getList() {
			return list;
		}
		@SuppressWarnings("rawtypes")
		public void setList(List list) {
			this.list = list;
		}
		public int getAllRow() {
			return allRow;
		}
		public void setAllRow(int allRow) {
			this.allRow = allRow;
		}
		public int getTotalPage() {
			return totalPage;
		}
		public void setTotalPage(int totalPage) {
			this.totalPage = totalPage;
		}
		public int getCurrentPage() {
			return currentPage;
		}
		public void setCurrentPage(int currentPage) {
			this.currentPage = currentPage;
		}
		public int getPageSize() {
			return pageSize;
		}
		public void setPageSize(int pageSize) {
			this.pageSize = pageSize;
		}

		/**
		 * ��ʼ��ҳ��Ϣ
		 */
		public void init(){
			this.isFirstPage = isFirstPage();
			this.isLastPage = isLastPage();
			this.hasPrePage = hasPrePage();
			this.hasNexPage = hasNexPage();
		}
		
		public boolean isFirstPage(){
			return currentPage == 1;
		}
		
		public boolean isLastPage(){
			return currentPage == totalPage;
		}
		
		public boolean hasPrePage(){
			return currentPage != 1;
		}
		
		public boolean hasNexPage(){
			return currentPage !=totalPage;
		}
		
		/**
		 * ������ҳ��
		 * @param pageSize ÿҳ��¼��
		 * @param allRow �ܼ�¼��
		 * @return int ��ҳ��
		 */
		public static int countTotalPage(final int pageSize,final int allRow){
			int totalPage = allRow % pageSize == 0 ? allRow/pageSize:allRow/pageSize + 1;
			return totalPage;
		}
		
		/**
		 *  ���㵱ǰ��ʼ�ļ�¼
		 * @param pageSize ÿҳ��¼��
		 * @param currentPage ��ǰ�ڼ�ҳ
		 * @return int ��ǰҳ��ʼ�ļ�¼��
		 */
		public static int countOffset(final int pageSize,final int currentPage){
			final int offset = pageSize * (currentPage - 1);
			return offset;
		}

		/**
		 * ���㵱ǰҳ����Ϊ0����URL��û��"?page="������1����
		 * @param page
		 * @return int
		 */
		public static int countCurrentPage(int page){
			final int currentPage = (page == 0 ? 1:page);
			return currentPage;
		}

}

package com.wyz.service.impl;

import java.util.List;

import com.wyz.entities.BookInfo;
import com.wyz.dao.BookDAO;
import com.wyz.service.BookService;

public class BookServiceImpl implements BookService{
	
	private BookDAO bookDAO;
	
	public BookDAO getBookDAO() {
		return bookDAO;
	}
	public void setBookDAO(BookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}

	// ��ȡ���кͷ�ҳ
	public List<BookInfo> showAll(int page, final int size) {
		return this.bookDAO.showAllRecord(page, size);
	}
	
	// ��ȡ������
	public int getBookCount() {
		return this.bookDAO.getCount();
	}

}

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

	// 获取表列和分页
	public List<BookInfo> showAll(int page, final int size) {
		return this.bookDAO.showAllRecord(page, size);
	}
	
	// 获取总条数
	public int getBookCount() {
		return this.bookDAO.getCount();
	}

}

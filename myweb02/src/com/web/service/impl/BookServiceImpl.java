package com.web.service.impl;

import java.util.List;

import com.web.bean.BookInfo;
import com.web.dao.BookDAO;
import com.web.service.BookService;

public class BookServiceImpl implements BookService {

	private BookDAO bookDAO;
		
	public BookDAO getBookDAO() {
		return bookDAO;
	}

	public void setBookDAO(BookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}

	public void delAll(int[] ids) {
		this.bookDAO.delAllBook(ids);
	}

	public void delRecord(BookInfo bookInfo) {
		this.bookDAO.delBook(bookInfo);
	}

	public void saveRecord(BookInfo bookInfo) {
		this.bookDAO.saveBook(bookInfo);
	}

	public List<BookInfo> showAll(int page,final int size) {
		return this.bookDAO.showAllRecord(page,size);
	}

	public BookInfo showById(Integer id) {
		return this.bookDAO.findById(id);
	}

	public void updateRecord(BookInfo bookInfo) {
		this.bookDAO.updateBook(bookInfo);
	}
	
	public int getBookCount(){
		return this.bookDAO.getCount();
	}

}

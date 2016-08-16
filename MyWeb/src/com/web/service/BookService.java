package com.web.service;

import java.util.List;

import com.web.bean.BookInfo;

public interface BookService {
	public void saveRecord(BookInfo bookInfo);
	
	public void delRecord(BookInfo bookInfo);
	
	public void updateRecord(BookInfo bookInfo);
	
	public BookInfo showById(Integer id);
	
	public List<BookInfo> showAll(int page,final int size);
	
	public void delAll(int[] ids);
	
	public int getBookCount();
}

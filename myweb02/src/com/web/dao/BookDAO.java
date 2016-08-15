package com.web.dao;

import java.util.List;
import com.web.bean.BookInfo;

public interface BookDAO {
	
	public void saveBook(BookInfo bookInfo);
	
	public void delBook(BookInfo bookInfo);
	
	public void delAllBook(int[] ids);
	
	public void updateBook(BookInfo bookInfo);
	
	public BookInfo findById(Integer id);
	
	public List<BookInfo> showAllRecord(int page,final int size);
	
	public int getCount();
}

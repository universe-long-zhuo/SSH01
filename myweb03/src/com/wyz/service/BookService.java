package com.wyz.service;

import java.util.List;

import com.wyz.entities.BookInfo;

public interface BookService {
	
	// 获取列表和分页
	public List<BookInfo> showAll(int page, final int size);
	// 获取总条数
	public int getBookCount();

}

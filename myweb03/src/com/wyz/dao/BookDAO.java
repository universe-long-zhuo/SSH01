package com.wyz.dao;

import java.util.List;
import com.wyz.entities.BookInfo;

public interface BookDAO {
	
	// 获取列表和分页
	public List<BookInfo> showAllRecord(int page, final int size);
	// 获取总条数
	public int getCount();

}

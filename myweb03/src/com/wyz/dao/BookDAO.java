package com.wyz.dao;

import java.util.List;
import com.wyz.entities.BookInfo;

public interface BookDAO {
	
	// ��ȡ�б�ͷ�ҳ
	public List<BookInfo> showAllRecord(int page, final int size);
	// ��ȡ������
	public int getCount();

}

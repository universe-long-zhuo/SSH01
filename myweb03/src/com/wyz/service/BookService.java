package com.wyz.service;

import java.util.List;

import com.wyz.entities.BookInfo;

public interface BookService {
	
	// ��ȡ�б�ͷ�ҳ
	public List<BookInfo> showAll(int page, final int size);
	// ��ȡ������
	public int getBookCount();

}

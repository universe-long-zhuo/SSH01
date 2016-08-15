package com.web.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.web.bean.BookInfo;
import com.web.dao.BookDAO;

public class BookDAOImpl extends HibernateDaoSupport implements BookDAO {

	/**
	 * 删除多条记录
	 */
	public void delAllBook(int[] ids) {
		List<BookInfo> bookInfo = new ArrayList<BookInfo>();
		for(int i=0; i<ids.length;i++){
			BookInfo book = this.findById(ids[i]);
			bookInfo.add(book);
			System.out.println("实现Book：" + book);
		}
		System.out.println("实现批量：" + bookInfo);
		this.getHibernateTemplate().deleteAll(bookInfo);
	}

	/**
	 * 删除一条记录
	 */
	public void delBook(BookInfo bookInfo) {
		this.getHibernateTemplate().delete(bookInfo);
	}

	/**
	 * 显示一条记录
	 */
	public BookInfo findById(Integer id) {
		BookInfo bookInfo = (BookInfo) this.getHibernateTemplate().get(BookInfo.class, id);
		System.out.println("实现实体id：" + id);
		return bookInfo;
	}

	/**
	 * 保存记录
	 */
	public void saveBook(BookInfo bookInfo) {
		this.getHibernateTemplate().save(bookInfo);
	}

	/**
	 * 显示所有记录
	 */
	@SuppressWarnings("unchecked")
	public List<BookInfo> showAllRecord(int page,final int size) {
		//String hql="from BookInfo";
		//return (List<BookInfo>)this.getHibernateTemplate().find(hql);
		if(page <= 0) {
            page = 1;
        }
        final int curPage = page;
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {
	           public Object doInHibernate(Session session) throws HibernateException, SQLException {
	               Query query = session.createQuery("from BookInfo");
	               List result = query.setFirstResult((curPage -1) * size).setMaxResults(size).list();
	               return result;
	           }
	        });
		return list;
	}

	/**
	 * 更新记录
	 */
	public void updateBook(BookInfo bookInfo) {
		this.getHibernateTemplate().update(bookInfo);
	}
	
	@SuppressWarnings("unchecked")
	public int getCount(){
		List list = getHibernateTemplate().executeFind(new HibernateCallback(){
    		public Object doInHibernate(Session session) throws HibernateException, SQLException {
    			Query query = session.createQuery("select count(*) from BookInfo");
    			return query.list();    			
    		}
    	});
    	return Integer.parseInt(list.get(0) + "");
	}

}

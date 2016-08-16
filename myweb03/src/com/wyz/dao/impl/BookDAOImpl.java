package com.wyz.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.wyz.entities.BookInfo;
import com.wyz.dao.BookDAO;

public class BookDAOImpl extends HibernateDaoSupport implements BookDAO {
	
	/**
	 * 显示所有记录
	 */
	@SuppressWarnings("unchecked")
	public List<BookInfo> showAllRecord(int page, final int size) {
		if (page <= 0) {
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
	 * 获取总条数
	 */
	@SuppressWarnings("unchecked")
	public int getCount() {
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery("select count(*) from BookInfo");
				return query.list();
			}
		});
		return Integer.parseInt(list.get(0) + "");
	}
}

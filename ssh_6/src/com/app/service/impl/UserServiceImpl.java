package com.app.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.app.SpringAnnotationDef;
import com.app.dao.BaseDao;
//import com.app.model.Page;
import com.app.util.PageBean;
import com.app.model.User;
import com.app.service.UserService;


@Service(SpringAnnotationDef.USER_SERVICE)
public class UserServiceImpl implements UserService{


    @SuppressWarnings("rawtypes")
	@Resource(name=SpringAnnotationDef.USER_DAO)
    private BaseDao userDao;

    //��id��ѯ�û�
    @SuppressWarnings("unchecked")
	@Override
    public User getUser(int id) {
        return (User)userDao.get(id);
    }

    //��ҳ��ѯ
	@SuppressWarnings("unchecked")
	@Override
	public PageBean queryForPage(int page, int pageSize) {
		
		System.out.println("1.ҵ��-��ҳ��ѯ�� " + pageSize + "," + page);
		final String hql = "from User";  //�ı�ʵ����@t_user
		int allRow = userDao.getCount(hql);
		int totalPage = PageBean.countTotalPage(pageSize, allRow);
		final int offset = PageBean.countOffset(pageSize, page);
		final int length = pageSize;
		final int currentPage = PageBean.countCurrentPage(page);
		List<User> list = userDao.queryForPage(hql, offset, length);
		System.out.println("2.ҵ��-��ҳ��ѯ: " + hql + "," + offset + "," + length);
		
		PageBean pageBean = new PageBean();
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(currentPage);
		pageBean.setAllRow(allRow);
		pageBean.setTotalPage(totalPage);
		pageBean.setList(list);
		return pageBean;
	}
}

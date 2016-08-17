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

    //按id查询用户
    @SuppressWarnings("unchecked")
	@Override
    public User getUser(int id) {
        return (User)userDao.get(id);
    }

    //分页查询
	@SuppressWarnings("unchecked")
	@Override
	public PageBean queryForPage(int page, int pageSize) {
		
		System.out.println("1.业务-分页查询： " + pageSize + "," + page);
		final String hql = "from User";  //改变实体类@t_user
		int allRow = userDao.getCount(hql);
		int totalPage = PageBean.countTotalPage(pageSize, allRow);
		final int offset = PageBean.countOffset(pageSize, page);
		final int length = pageSize;
		final int currentPage = PageBean.countCurrentPage(page);
		List<User> list = userDao.queryForPage(hql, offset, length);
		System.out.println("2.业务-分页查询: " + hql + "," + offset + "," + length);
		
		PageBean pageBean = new PageBean();
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(currentPage);
		pageBean.setAllRow(allRow);
		pageBean.setTotalPage(totalPage);
		pageBean.setList(list);
		return pageBean;
	}
}

package com.app.service;

//import com.app.model.Page;
import com.app.util.PageBean;
import com.app.model.User;

public interface UserService {

	/**
	 * 按id查询用户
	 * @param id
	 * @return
	 */
    public User getUser(int id);
    
    /**
     * 分页查询
     * @param pageSize 当前第几页
     * @param currentPage 每页记录数量
     * @return Page 分页信息
     */
    public PageBean queryForPage(int pageSize,int page);


}

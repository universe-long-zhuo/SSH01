package com.app.dao;

import com.app.model.User;
/**
 * 用户名DAO接口
 * @author lbz
 *
 */
public interface UserDao extends  BaseDao<User,Integer>{
	 
	/**
	 * 用户登录
	 * @param username 用户名
	 * @param password 密码
	 * @return Boolean 是否登录成功
	 */
	public Boolean login(String username,String password);
}

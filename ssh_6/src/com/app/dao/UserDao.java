package com.app.dao;

import com.app.model.User;
/**
 * �û���DAO�ӿ�
 * @author lbz
 *
 */
public interface UserDao extends  BaseDao<User,Integer>{
	 
	/**
	 * �û���¼
	 * @param username �û���
	 * @param password ����
	 * @return Boolean �Ƿ��¼�ɹ�
	 */
	public Boolean login(String username,String password);
}

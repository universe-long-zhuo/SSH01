package com.app.service;

//import com.app.model.Page;
import com.app.util.PageBean;
import com.app.model.User;

public interface UserService {

	/**
	 * ��id��ѯ�û�
	 * @param id
	 * @return
	 */
    public User getUser(int id);
    
    /**
     * ��ҳ��ѯ
     * @param pageSize ��ǰ�ڼ�ҳ
     * @param currentPage ÿҳ��¼����
     * @return Page ��ҳ��Ϣ
     */
    public PageBean queryForPage(int pageSize,int page);


}

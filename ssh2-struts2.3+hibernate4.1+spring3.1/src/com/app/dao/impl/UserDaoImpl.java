package com.app.dao.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.app.SpringAnnotationDef;
import com.app.dao.UserDao;
import com.app.model.User;

@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository(SpringAnnotationDef.USER_DAO)
public  class UserDaoImpl extends BaseDaoImpl<User,Integer> implements UserDao{
    
    public UserDaoImpl(){
        super(User.class);
    }

    //ÓÃ»§µÇÂ¼
	@Override
	public Boolean login(String username, String password) {
		return validate("select count(*) from User where username=? and password=?",new Object[]{username,password});
	}
    
    
}

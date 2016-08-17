package com.test;

import java.util.List;

import junit.framework.TestCase;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.dao.UserDao;
import com.app.model.User;

public class TestUserDao extends TestCase {

    //读spring配置文件
    public static BeanFactory factory = new ClassPathXmlApplicationContext("com/resources/applicationContext_*.xml");
    UserDao dao = (UserDao)factory.getBean("userDao");
    
    //插入新记录
    public void testInsert() throws Exception {
    	User user = new User();
    	user.setUsername("李六");
    	user.setPassword("123");
    	dao.save(user);
    	System.out.println("保存成功！");
    }
    
    //根据id查询数据
    public void testGet() throws Exception {
        User user = dao.get(1);
        System.out.println("用户名：" + user.getUsername() + ",密码：" + user.getPassword());
    }
    
    public void testListAll() throws Exception{
    	System.out.println(dao.countAll());
    }
    
    public void testGetAll() throws Exception{
        List<User> list = dao.listAll();
        for(User user:list){
            System.out.println("用户名：" + user.getUsername() + ",密码：" + user.getPassword());
        }
    }
    
}

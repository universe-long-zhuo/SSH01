package com.app.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.app.SpringAnnotationDef;
import com.app.dao.BaseDao;

/**
 * 访问数据库基类的实现类
 * @author lbz
 *
 * @param <T> 实体模型
 * @param <ID> 实体的id
 */
@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Transactional
public  class BaseDaoImpl<T extends Serializable,ID extends Serializable> implements BaseDao<T,ID> {


    protected Class<T> entity;

    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;
    

    public BaseDaoImpl(Class<T> entityClass){
        this.entity = entityClass;
    }

    //保存记录
    @SuppressWarnings("unchecked")
	@Override
    public T save(T model) {
        return (T)getSession().save(model);
    }

    //保存或更新的记录
    @Override
    public void saveOrUpdate(T model) {
        getSession().saveOrUpdate(model);
    }

    //更新记录
    @Override
    public void update(T model) {
        getSession().update(model);
    }

    //保存或更新记录
    @Override
    public void merge(T model) {
        getSession().merge(model);
    }

    //删除记录
    @Override
    public void delete(ID id) {
        getSession().delete(this.get(id));
    }

    //删除实体对象
    @Override
    public void deleteObject(T model) {
        getSession().delete(model);
    }

    //根据id获取记录
    @SuppressWarnings("unchecked")
	@Override
    public T get(ID id) {
        try {
			return (T)getSession().get(this.entity,id);
		} catch (Exception e) {
			return null;
		}
    }

    //统计所有记录数量
    @Override
    public int countAll() {
        return  listAll().size();
    }

    //获取所有记录
    @SuppressWarnings("unchecked")
	@Override
    public List<T> listAll() {
        return (List<T>)getSession().createCriteria(this.entity).list();
    }
    
    @Override
    public int getCount(String hql){
    	return getSession().createQuery(hql).list().size();
    }
    
    //按页查询记录
  	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
  	public List<T> queryForPage(final String hql, final int offset, final int length) {
  		Query query = getSession().createQuery(hql);
  		query.setFirstResult(offset);
  		query.setMaxResults(length);
  		List<T> list = query.list();
  		return list;
  	}


    //是否存在
    @Override
    public boolean exists(ID id) {
        return get(id)!=null;
    }

    //是否存在
    @Override
    public void flush() {
        getSession().flush();
    }

    //清除
    @Override
    public void clear() {
        getSession().clear();
    }

    //获取session
    
    /**
     * 从数据库中获取一个实体类的集合或一列值
     * @param hql hql语句
     * @param args 参数列表
     * @return List
     */
    @SuppressWarnings("rawtypes")
	public List getList(String hql,Object[] args){
    	try{
    		return getQuery(hql,args).list();
    	}catch (Exception e){
    		e.printStackTrace();
    		return new ArrayList();
    	}
    }
    
    /**
     * 从数据库中获取一个实体或一个值
     * @param hql hql语句
     * @param args 参数列表
     * @return Object
     */
    @SuppressWarnings("rawtypes")
	public Object getObject(String hql,Object[] args){
    	List list = getList(hql,args);
    	if(list.size()>0){
    		return list.get(0);
    	}
    	return null;
    }
    
    /**
     * 判断数据库是否有该记录
     * @param hql hql语句select count(*) from...
     * @param args 参数列表
     * @return Boolean
     */
    public Boolean validate(String hql,Object[] args){
    	try{
    		Object value = getObject(hql,args);
    		if(null!=value && Integer.parseInt(value.toString())>0){
    			return true;
    		}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return false;
    }
    
    //获取Query
    private Query getQuery(String hql,Object[] args){
    	Query query = getSession().createQuery(hql);
    	if(null != args && args.length > 0) {
    		for (int i=0;i<args.length;i++){
    			query.setParameter(i, args[i]);
    		}
    	}
    	return query;
    }

    protected Session getSession(){
    	return sessionFactory.getCurrentSession();
    }
    
}

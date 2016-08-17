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
 * �������ݿ�����ʵ����
 * @author lbz
 *
 * @param <T> ʵ��ģ��
 * @param <ID> ʵ���id
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

    //�����¼
    @SuppressWarnings("unchecked")
	@Override
    public T save(T model) {
        return (T)getSession().save(model);
    }

    //�������µļ�¼
    @Override
    public void saveOrUpdate(T model) {
        getSession().saveOrUpdate(model);
    }

    //���¼�¼
    @Override
    public void update(T model) {
        getSession().update(model);
    }

    //�������¼�¼
    @Override
    public void merge(T model) {
        getSession().merge(model);
    }

    //ɾ����¼
    @Override
    public void delete(ID id) {
        getSession().delete(this.get(id));
    }

    //ɾ��ʵ�����
    @Override
    public void deleteObject(T model) {
        getSession().delete(model);
    }

    //����id��ȡ��¼
    @SuppressWarnings("unchecked")
	@Override
    public T get(ID id) {
        try {
			return (T)getSession().get(this.entity,id);
		} catch (Exception e) {
			return null;
		}
    }

    //ͳ�����м�¼����
    @Override
    public int countAll() {
        return  listAll().size();
    }

    //��ȡ���м�¼
    @SuppressWarnings("unchecked")
	@Override
    public List<T> listAll() {
        return (List<T>)getSession().createCriteria(this.entity).list();
    }
    
    @Override
    public int getCount(String hql){
    	return getSession().createQuery(hql).list().size();
    }
    
    //��ҳ��ѯ��¼
  	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
  	public List<T> queryForPage(final String hql, final int offset, final int length) {
  		Query query = getSession().createQuery(hql);
  		query.setFirstResult(offset);
  		query.setMaxResults(length);
  		List<T> list = query.list();
  		return list;
  	}


    //�Ƿ����
    @Override
    public boolean exists(ID id) {
        return get(id)!=null;
    }

    //�Ƿ����
    @Override
    public void flush() {
        getSession().flush();
    }

    //���
    @Override
    public void clear() {
        getSession().clear();
    }

    //��ȡsession
    
    /**
     * �����ݿ��л�ȡһ��ʵ����ļ��ϻ�һ��ֵ
     * @param hql hql���
     * @param args �����б�
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
     * �����ݿ��л�ȡһ��ʵ���һ��ֵ
     * @param hql hql���
     * @param args �����б�
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
     * �ж����ݿ��Ƿ��иü�¼
     * @param hql hql���select count(*) from...
     * @param args �����б�
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
    
    //��ȡQuery
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

package com.app.dao;

import java.util.List;

/**
 * �������ݵĻ���DAO
 * @author lbz
 *
 * @param <T> ʵ��
 * @param <ID> ʵ��id
 */

public interface BaseDao<T,ID> {
    
	/**
	 * �����¼
	 * @param model ʵ��ģ��
	 * @return T
	 */
    public T save(T model);

    /**
     * �������¼�¼
     * @param model ʵ��ģ��
     */
    public void saveOrUpdate(T model);
    
    /**
     * ���¼�¼
     * @param model
     */
    public void update(T model);
    
    /**
     * �������µļ�¼
     * @param model
     */
    public void merge(T model);

    /**
     * ����idɾ����¼
     * @param id ʵ���id
     */
    public void delete(ID id);

    /**
     * ɾ��ʵ�����
     * @param model ʵ��
     */
    public void deleteObject(T model);

    /**
     * ����id��ȡ��¼
     * @param id ʵ���id
     * @return T
     */
    public T get(ID id);
    
    /**
     * ͳ�����м�¼����
     * @return int
     */
    public int countAll();

    /**
     * ��ȡ���м�¼
     * @return list
     */
    public List<T> listAll();
    
    /**
     * ��ѯ����¼������
     * @param hql hql���
     * @return int 
     */
    public int getCount(String hql);

    /**
     * ��ҳ��ѯ��¼
     * @param hql hql���
     * @param offset ��ʼ��¼
     * @param pageSize ÿҳ��¼����
     * @return
     */
    public List<T> queryForPage(final String hql,final int offset,final int length);
    
    
    /**
     * �Ƿ����
     * @param id ʵ���id
     * @return Boolean
     */
    boolean exists(ID id);
    
    /**
     * ˢ��
     */
    public void flush();
    
    /**
     * ���
     */
    public void clear();

}

package com.app.dao;

import java.util.List;

/**
 * 访问数据的基类DAO
 * @author lbz
 *
 * @param <T> 实体
 * @param <ID> 实体id
 */

public interface BaseDao<T,ID> {
    
	/**
	 * 保存记录
	 * @param model 实体模型
	 * @return T
	 */
    public T save(T model);

    /**
     * 保存或更新记录
     * @param model 实体模型
     */
    public void saveOrUpdate(T model);
    
    /**
     * 更新记录
     * @param model
     */
    public void update(T model);
    
    /**
     * 保存或更新的记录
     * @param model
     */
    public void merge(T model);

    /**
     * 根据id删除记录
     * @param id 实体的id
     */
    public void delete(ID id);

    /**
     * 删除实体对象
     * @param model 实体
     */
    public void deleteObject(T model);

    /**
     * 根据id获取记录
     * @param id 实体的id
     * @return T
     */
    public T get(ID id);
    
    /**
     * 统计所有记录数量
     * @return int
     */
    public int countAll();

    /**
     * 获取所有记录
     * @return list
     */
    public List<T> listAll();
    
    /**
     * 查询到记录的数量
     * @param hql hql语句
     * @return int 
     */
    public int getCount(String hql);

    /**
     * 按页查询记录
     * @param hql hql语句
     * @param offset 开始记录
     * @param pageSize 每页记录数量
     * @return
     */
    public List<T> queryForPage(final String hql,final int offset,final int length);
    
    
    /**
     * 是否存在
     * @param id 实体的id
     * @return Boolean
     */
    boolean exists(ID id);
    
    /**
     * 刷新
     */
    public void flush();
    
    /**
     * 清除
     */
    public void clear();

}

/**
 * 
 */
package com.edu.common.dao.impl;

import com.edu.common.Pages;
import com.edu.common.bean.BaseEntity;
import com.edu.common.dao.DaoException;
import com.edu.common.dao.IGenericDao;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * @explain: {类说明:dao层实现基类}
 * @author: lc
 * @param <T>
 * @Version:1.0
 * @dateTime: 2015年6月3日
 */
public class GenericDaoImpl<T extends BaseEntity, PK extends Serializable>
				extends SqlSessionDaoSupport implements IGenericDao<T, PK> {
    /**
     * sqlmap.xml定义文件中对应的sqlid
     * insert 保存
     */
    public static final String SQLID_INSERT = "insert";
    /**
     * 根据主键进行修改
     */
    public static final String SQLID_UPDATE = "updateByPrimaryKey";
    /**
     * 根据主键及参数选择性的修改
     */
    public static final String SQLID_UPDATE_PARAM = "updateByIdSelective";
    /**
     * 查询表中所有数据，没有条件的查询
     */
    public static final String SQLID_SELECT = "selectAll";
    /**
     * 根据主键查询对应实体对象
     */
    public static final String SQLID_SELECT_PK = "selectByPrimaryKey";
    /**
     * 根据查询条件获取集合对象 带分页
     */
    public static final String SQLID_SELECT_PARAM = "selectByCondition";
    /**
     * 根据查询条件获取带其它实体的集合对象 带分页
     */
    public static final String SQLID_SELECT_FK = "selectFkByCondition";
    /**
     * 查询对应表中的条数
     */
    public static final String SQLID_COUNT = "count";
    /**
     * 带条件的查询对应表中的条数
     */
    public static final String SQLID_COUNT_PARAM = "countByParam";

    /**
     * 带条件的查询对应表中名称条数
     */
    public static final String SQLID_COUNTNAME_PARAM = "isNameExists";

    /**
     * 根据主键逻辑删除，也就是更新表中是否删除的标识，如果没有删除标识自己，可以写成物理删除语句
     */
    public static final String SQLID_DELETE = "deleteByPrimaryKey";
    /**
     * 根据主键物理删除对象
     */
	public static final String SQLID_TRUNCATE = "truncateDeleteByPrimaryKey";
	
	/**
     * 映射查询出来对象
     */
	public static final String selectFetchObjects = "selectFetchObjects";
  
    private String sqlmapNamespace = "";  
  
    /** 
     * sqlmapNamespace，对应sqlmap.xml中的命名空间
     * @return 
     */  
    public String getSqlmapNamespace() {  
        return sqlmapNamespace;  
    }
    
    /** 
     * sqlmapNamespace的设置方法，可以用于spring注入 
     *  
     * @param sqlmapNamespace 
     */ 
    public void setSqlmapNamespace(String sqlmapNamespace) {  
        this.sqlmapNamespace = sqlmapNamespace;  
    }  
  
    @Resource
   	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
   		super.setSqlSessionFactory(sqlSessionFactory);
   	}
    
    public int countFetchObjects(Object params) throws DaoException {
        Integer count = (Integer) super.getSqlSession().selectOne(  
                sqlmapNamespace + ".countFetchObjects" , params);  
        return count.intValue();  
    } 
    /** 
     * 按条件查询记录 
     * @param param 查询出来对象 
     * @return 符合条件记录的实体对象的List 
     */  
    public Pages<T> selectFetchObjects(Object params) throws DaoException {
    	 Pages<T> result = new Pages<T>();
         int count = countFetchObjects(params);  
         result.setTotalsCount(count);  
         if (count > 0) {  
             List<T> data = super.getSqlSession().selectList(
                     sqlmapNamespace + "." + selectFetchObjects, params); 
             result.setResult(data);  
         }  
   
         return result;
    	 
    }
    
    public int count() throws DaoException {
        Integer count = (Integer) super.getSqlSession().selectOne(
        		sqlmapNamespace + "." + SQLID_COUNT);  
        return count.intValue();  
    }  
  
    public int count(Object params) throws DaoException {
        Integer count = (Integer) super.getSqlSession().selectOne(  
                sqlmapNamespace + "." + SQLID_COUNT_PARAM, params);  
        return count.intValue();  
    }  
  
    public int delete(PK primaryKey) throws DaoException {
        int rows = super.getSqlSession().update( 
                sqlmapNamespace + "." + SQLID_DELETE, primaryKey);  
        return rows;  
    }
    
    public int truncate(PK primaryKey) throws DaoException {
        int rows = super.getSqlSession().delete(  
                sqlmapNamespace + "." + SQLID_TRUNCATE,primaryKey);
        return rows;  
    }  
  
    @SuppressWarnings("unchecked")
	public T selectByPrimaryKey(PK primaryKey) throws DaoException {
        return (T) super.getSqlSession().selectOne(  
                sqlmapNamespace + "." + SQLID_SELECT_PK, primaryKey);  
    }  
  
    public int insert(T entity) throws DaoException {
    	return super.getSqlSession().insert(sqlmapNamespace + "." + SQLID_INSERT,  
                entity);  
    }  
  
    public List<T> select() throws DaoException {
        return super.getSqlSession().selectList(
                sqlmapNamespace + "." + SQLID_SELECT);  
    }  
  
    public List<T> selectByCondition(Object params) throws DaoException {
        return super.getSqlSession().selectList(  
                sqlmapNamespace + "." + SQLID_SELECT_PARAM, params);  
    }  
  
    public Pages<T> selectPagination(Object params) throws DaoException {
    	Pages<T> result = new Pages<T>();
        int count = count(params);  
        result.setTotalsCount(count);  
        if (count > 0) {  
            List<T> data = super.getSqlSession().selectList(  
                    sqlmapNamespace + "." + SQLID_SELECT_PARAM, params);  
            result.setResult(data);  
        }  
        return result;  
    }  
  
    public List<T> selectFk(Object params) throws DaoException {
        return super.getSqlSession().selectList(  
                sqlmapNamespace + "." + SQLID_SELECT_FK, params);  
    }  
  
    public Pages<T> selectFkPagination(Object params) throws DaoException {
    	Pages<T> result = new Pages<T>();
        int count = count(params);  
        result.setTotalsCount(count);  
        if (count > 0) {  
            List<T> data = super.getSqlSession().selectList( 
                    sqlmapNamespace + "." + SQLID_SELECT_FK, params);  
            result.setResult(data);  
        }  
  
        return result;  
    }

    /**
     * 查询符合条件的名称是否存在
     *
     * @param params 条件
     * @return 大于0表示名称存在，否则不存在
     * @throws DaoException
     */
    @Override
    public int isNameExists(Object params) throws DaoException {
        Integer count = (Integer) super.getSqlSession().selectOne(
                sqlmapNamespace + "." + SQLID_COUNTNAME_PARAM, params);
        return count.intValue();
    }

    public int update(T entity) throws DaoException {
        return super.getSqlSession().update(  
                sqlmapNamespace + "." + SQLID_UPDATE, entity);  
    }  
  
    public int updateByParams(T entity) throws DaoException {
        if (entity == null )
            throw new DaoException(
                    "参数设置错误:使用带参数的update必须设定update的column！");  
  
        return super.getSqlSession().update(
                sqlmapNamespace + "." + SQLID_UPDATE_PARAM, entity);
    }  
  
     public void batchInsert(final List<T> list) throws DaoException {
        if(list == null || list.isEmpty()) {
        	return;
        }
        for (T entity : list) {
        	super.getSqlSession().insert(sqlmapNamespace + "." + SQLID_INSERT,  
                    entity);  
		}
    }  
  
    public void batchUpdate(final List<T> list) throws DaoException {
           
    }  
  
    public void batchDelete(final List<PK> list) throws DaoException {
         if(list == null || list.isEmpty()) {
        	 return;
         }
         for (PK primaryKey : list) {
			super.getSqlSession().update( 
	                sqlmapNamespace + "." + SQLID_DELETE, primaryKey);
		}
    } 
		
		
}

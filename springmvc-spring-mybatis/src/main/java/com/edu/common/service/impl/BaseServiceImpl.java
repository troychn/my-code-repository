package com.edu.common.service.impl;

import com.edu.common.Pages;
import com.edu.common.bean.BaseEntity;
import com.edu.common.dao.IBaseDao;
import com.edu.common.service.IBaseService;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 抽象的baseService,专门用于继承
 */
public abstract class BaseServiceImpl<T extends BaseEntity,PK extends Serializable>
						implements IBaseService<T,PK> {


    protected IBaseDao<T,PK> dao ;
    
    /** 
     * 按条件查询记录 
     * @param params 查询出来对象
     * @return 符合条件记录的实体对象的List 
     */  
    public Pages<T> selectFetchObjects(Object params) throws Exception{
    	return dao.selectFetchObjects(params);
    };  

    //注入dao
    @Resource
    public void setDao(IBaseDao<T, PK> dao) {
        this.dao = dao;
    }

	/**
     * 插入一个实体（在数据库INSERT一条记录） 
     * @param entity 实体对象 
     */  
    public int insert(T entity) throws Exception {
    	return dao.insert(entity);
    }
      
    /** 
     * 修改一个实体对象（UPDATE一条记录） 
     * @param entity 实体对象 
     * @return 修改的对象个数，正常情况=1 
     */  
    public int update(T entity) throws Exception {
    	return dao.update(entity);
    }
      
    /** 
     * 修改符合条件的记录 
     * <p>此方法特别适合于一次性把多条记录的某些字段值设置为新值（定值）的情况，比如修改符合条件的记录的状态字段</p> 
     * <p>此方法的另一个用途是把一条记录的个别字段的值修改为新值（定值），此时要把条件设置为该记录的主键</p> 
     * @param entity 用于产生SQL的参数值，包括WHERE条件、目标字段和新值等
     * @return 修改的记录个数，用于判断修改是否成功 
     */  
    public int updateByParams(T entity) throws Exception {
    	return dao.updateByParams(entity);
    }
      
    /** 
     * 按主键删除记录 
     * @param primaryKey 主键对象 
     * @return 删除的对象个数，正常情况=1 
     */  
    public int delete(PK primaryKey) throws Exception {
    	return dao.delete(primaryKey);
    }
  
      
    /** 
     * 清空表，比delete具有更高的效率，而且是从数据库中物理删除（delete是逻辑删除，被删除的记录依然占有空间） 
     * <p><strong>此方法一定要慎用！</strong></p> 
     * @return 
     */  
    public int truncate(PK primaryKey) throws Exception {
    	return dao.truncate(primaryKey);
    }
      
    /** 
     * 查询整表总记录数 
     * @return 整表总记录数 
     */  
    public int count() throws Exception {
    	return dao.count();
    }
    /** 
     * 查询整表总记录数 
     * @return 整表总记录数 
     */  
    public int countFetchObjects(Object param) throws Exception {
    	return dao.countFetchObjects(param);
    }
      
    /** 
     * 查询符合条件的记录数 
     * @param param 查询条件参数，包括WHERE条件（其他参数内容不起作用）。此参数设置为null，则相当于count() 
     * @return 
     */  
    public int count(Map<String, Object> param) throws Exception {
    	return dao.count(param);
    }
  
    /** 
     * 按主键取记录 
     * @param primaryKey 主键值 
     * @return 记录实体对象，如果没有符合主键条件的记录，则返回null 
     */  
    public T selectByPrimaryKey(PK primaryKey) throws Exception {
    	return dao.selectByPrimaryKey(primaryKey);
    }
  
    /** 
     * 取全部记录 
     * @return 全部记录实体对象的List 
     */  
    public List<T> select() throws Exception {
    	return dao.select();
    }
      
    /** 
     * 按条件查询记录 
     * @param param 查询条件参数，包括WHERE条件、分页条件、排序条件 
     * @return 符合条件记录的实体对象的List 
     */  
    public List<T> selectByCondition(Map<String, Object> param) throws Exception {
    	return dao.selectByCondition(param);
    }
      
    /** 
     * 按条件查询记录，并处理成分页结果 
     * @param param 查询条件参数，包括WHERE条件、分页条件、排序条件 
     * @return PaginationResult对象，包括（符合条件的）总记录数、页实体对象List等 
     */  
    public Pages<T> selectPagination(Map<String, Object> param) throws Exception {
    	Pages<T> pages = new Pages<T>();
        if(param == null || param.get("startIndex") == null){
            if(param == null) {
            	param = new HashMap<String, Object>();
            }
            param.put("startIndex", pages.getCurrentPage() * pages.getPageSize());
            param.put("pageSize", pages.getPageSize());
        }
        pages = dao.selectPagination(param);
        if(param.get("currentPage") != null){
            pages.setCurrentPage(Integer.parseInt((String) param.get("currentPage")));
        }
    	return pages;
    }
      
    /** 
     * 按条件查询记录，并把有外键关联的字段的关联对象也处理出来 
     * <p>此方法是为了避免1+N而设置的</p> 
     * @param param 查询条件参数，包括WHERE条件、分页条件、排序条件<strong>（不包括外键关联表条件）</strong> 
     * @return 符合条件记录的实体对象的List 
     */  
    public List<T> selectFk(Map<String, Object> param) throws Exception {
    	return dao.selectFk(param);
    }
      
    /** 
     * 按条件查询记录，并把有外键关联的字段的关联对象也处理出来，并处理成分页结果 
     * <p>此方法是为了避免1+N而设置的</p> 
     * @param param 查询条件参数，包括WHERE条件、分页条件、排序条件<strong>（不包括外键关联表条件）</strong> 
     * @return PaginationResult对象，包括（符合条件的）总记录数、页实体对象List等 
     */  
    public Pages<T> selectFkPagination(Map<String, Object> param) throws Exception {
        Pages<T> pages = new Pages<T>();
        if (param == null || param.get("startIndex") == null) {
            if (param == null) {
                param = new HashMap<String, Object>();
            }
            param.put("startIndex", pages.getCurrentPage() * pages.getPageSize());
            param.put("pageSize", pages.getPageSize());
        }
        pages = dao.selectFkPagination(param);
        if (param.get("currentPage") != null) {
            pages.setCurrentPage(Integer.parseInt((String) param.get("currentPage")));
        }
        return pages;
    }

}

package com.edu.commonConfig.dao;

import com.edu.common.Pages;
import com.edu.common.dao.DaoException;
import com.edu.common.dao.IGenericDao;
import com.edu.commonConfig.bean.KnowlegePoint;

import java.util.List;

/**
 * Created by lc on 2015/6/4.
 * 知识点dao层接口
 */
public interface KnowlegePointDao extends IGenericDao<KnowlegePoint, Integer> {

    /**
     * 根据条件查询已经启用的知识点
     * @param params
     * @return List<KnowlegePoint> 知识点集合
     * @throws DaoException
     */
    public List<KnowlegePoint> selectEnableByCondition(Object params)throws DaoException;

    /**
     * 根据指定的知识点ID数组查询知识点集合
     * @param idsArray 知识点ID数组
     * @return 知识点集合
     * @throws DaoException
     */
    public List<KnowlegePoint> getKnowlegePoint2Ids(Object idsArray) throws DaoException;
    
    public Pages<KnowlegePoint> getKnowlegePointCountPaper(Object params)throws DaoException;
    
    
}
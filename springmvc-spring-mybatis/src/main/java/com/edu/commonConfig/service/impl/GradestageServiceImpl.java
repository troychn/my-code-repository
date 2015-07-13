/**
 * 
 */
package com.edu.commonConfig.service.impl;

import com.edu.common.dao.IBaseDao;
import com.edu.common.service.impl.BaseServiceImpl;
import com.edu.commonConfig.bean.Gradestage;
import com.edu.commonConfig.dao.GradestageDao;
import com.edu.commonConfig.service.IGradestageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @explain: {类说明:学科Service实现类}
 * @author: lc
 * @Version: 1.0
 * @dateTime: 2015年6月4日
 */
@Service(value="gradestageService")
public class GradestageServiceImpl extends BaseServiceImpl<Gradestage, Integer> implements
		IGradestageService {

	/*@Autowired
	private SubjectDao subjectDao;

	public SubjectServiceImpl() {
		super.setDao(subjectDao);
	}*/

	private GradestageDao gradestageDao;

	@Autowired
	public void setDao(IBaseDao<Gradestage, Integer> dao) {
		super.setDao(dao);
		this.gradestageDao = (GradestageDao) dao;
	}
}

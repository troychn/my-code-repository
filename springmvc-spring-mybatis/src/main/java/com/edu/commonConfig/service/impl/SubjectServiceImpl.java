/**
 * 
 */
package com.edu.commonConfig.service.impl;

import com.edu.common.dao.IBaseDao;
import com.edu.common.service.impl.BaseServiceImpl;
import com.edu.commonConfig.bean.Subject;
import com.edu.commonConfig.dao.SubjectDao;
import com.edu.commonConfig.service.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @explain: {类说明:学科Service实现类}
 * @author: lc
 * @Version: 1.0
 * @dateTime: 2015年6月4日
 */
@Service(value="subjectService")
public class SubjectServiceImpl extends BaseServiceImpl<Subject, Integer> implements
		ISubjectService {

	/*@Autowired
	private SubjectDao subjectDao;

	public SubjectServiceImpl() {
		super.setDao(subjectDao);
	}*/

	private SubjectDao subjectDao;

	@Autowired
	public void setDao(IBaseDao<Subject, Integer> dao) {
		super.setDao(dao);
		this.subjectDao = (SubjectDao) dao;
	}
}

/**
 * 
 */
package edu.commonConfig.service.impl;

import com.edu.commonConfig.bean.Subject;
import com.edu.commonConfig.service.ISubjectService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @explain: {类说明:}
 * @author: liucheng
 * @Version:
 * @dateTime: 2015年6月4日
 */
@RunWith(JUnit4ClassRunner.class)
//配置了@ContextConfiguration注解并使用该注解的locations属性指明spring和配置文件之后，15
@ContextConfiguration(locations = {"classpath:spring/basicContext.xml"})
public class SubjectServiceImplTest {

	@Autowired
	private ISubjectService subjectService;
	
	 @Test
    public void testSave() throws Exception {
    	Subject subject = new Subject();
    	subject.setSubjectName("语文");
    	subject.setIsEnable(1);
    	subject.setSubjectDesc("小学一年级语文");
    	subject.setCreated("2015-06-14 21:37:04");
    	subject.setModified("2015-06-14 21:37:04");
		subject.setGradestageId(28);
		subject.setVersion(1);
    	subjectService.insert(subject);
    }

    @Test
    public void testFind()throws Exception{
    	Subject subject = subjectService.selectByPrimaryKey(5);
    	System.out.println(subject);
    }

	@Test
	public void testList() throws Exception{
		Map<String, Object> prams = new HashMap<String, Object>();
		List<Subject> subjects = subjectService.selectByCondition(prams);
		for (Subject subject : subjects) {
			System.out.println(subject);
		}
	}

}

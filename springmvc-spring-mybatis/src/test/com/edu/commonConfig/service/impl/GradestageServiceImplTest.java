package com.edu.commonConfig.service.impl;

import com.edu.commonConfig.bean.Gradestage;
import com.edu.commonConfig.service.IGradestageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

/**
 * Created by Administrator on 2015/7/13.
 */
@RunWith(JUnit4ClassRunner.class)
//配置了@ContextConfiguration注解并使用该注解的locations属性指明spring和配置文件之后，15
@ContextConfiguration(locations = {"classpath:spring/basicContext.xml"})
public class GradestageServiceImplTest {

    @Autowired
    private IGradestageService gradestageService;

    @Test
    public void testSave() throws Exception {
        Gradestage gradestage = new Gradestage("高中111111111111111111",
                "小学阶段学段", 1, 0, "2015-06-14 21:33:32", "2015-06-14 21:33:32", 1);
        int id = gradestageService.insert(gradestage);
        System.out.println(id + "-----------------save");
    }

    @Test
    public void testDelete() throws Exception{
        int id = gradestageService.truncateDeleteByPrimaryKey(40);
        System.out.println(id+"---------------delete");
    }

}
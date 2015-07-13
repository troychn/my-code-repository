package spring.jpa.service.impl;

import com.spring.jpa.UserEntity;
import com.spring.jpa.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lc on 2015/7/9.
 */
@RunWith(JUnit4ClassRunner.class)
//配置了@ContextConfiguration注解并使用该注解的locations属性指明spring和配置文件之后，15
//@ContextConfiguration(locations = {"classpath:springjpa-persistence/spring-persistence-jpa.xml"})
@ContextConfiguration(locations = {"classpath:spring-jpa.xml"})
public class UserServiceImplTest {

    @Resource
    private IUserService userService;

    @Test
    public void testSaveUser() throws Exception {
        UserEntity userEntity = new UserEntity();
        userEntity.setName("李四2");
        userEntity.setAge(24);
        userEntity.setAddress("上海");
        userService.saveUser(userEntity);
    }

    @Test
    public void testDeleteUser() throws Exception {
        userService.deleteUser(14);
    }

    @Test
    public void testFindUserById() throws Exception {
        UserEntity userEntity = userService.findUserById(14);
        System.out.println(userEntity);
    }

    @Test
    public void testFindAllUsers() throws Exception {
        List<UserEntity> userEntities = userService.findAllUsers();
        for (int i = 0; i < userEntities.size(); i++) {
            System.out.println(userEntities.get(i));
        }
    }

    @Test
    public void testFindAllUserByPage() throws Exception {
        PageRequest page = new PageRequest(0, 2);
        Page<UserEntity> userEntities = userService.findAllUserByPage(page);
        for (UserEntity userEntity : userEntities) {
            System.out.println(userEntity);
        }
       /* for (int i = 0; i < userEntities.getSize(); i++) {
            System.out.println(userEntities.getContent().get(i));
        }*/
    }
}
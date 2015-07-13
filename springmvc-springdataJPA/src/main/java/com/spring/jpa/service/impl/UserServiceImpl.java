package com.spring.jpa.service.impl;

import com.spring.jpa.UserEntity;
import com.spring.jpa.dao.IUserDao;
import com.spring.jpa.service.IUserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lc on 2015/7/9.
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {
    // 推荐用Resource来替代AutoWrite注解
    @Resource
    private IUserDao userDao;

    /**
     * 新建用户
     *
     * @param userEntity
     */
    @Override
    public void saveUser(UserEntity userEntity) {
        userDao.save(userEntity);
        /*
        测试事务
        int i = 10/0;
        userEntity.setName("王五");
        userDao.save(userEntity);*/
    }

    /**
     * 删除用户
     *
     * @param id
     */
    @Override
    public void deleteUser(Integer id) {
        userDao.delete(id);
    }

    /**
     * 查找单个用户
     *
     * @param id
     * @return
     */
    @Override
    public UserEntity findUserById(Integer id) {
        return userDao.findOne(id);
    }

    /**
     * 查找所有用户
     *
     * @return
     */
    @Override
    public List<UserEntity> findAllUsers() {
        return (List<UserEntity>) userDao.findAll();
    }

    /**
     * 根据一个分页对象查询user集合（还可以添加一个Store排序属性）
     * PageRequest    是spring自己封装的请求分页类，实现了Pageable接口，包涵从请求中获得的分页属性（当前页和大小）和获取方法
     * 通过调用分页方法，返回一个Page<>一个泛型集合的分页对象，里面包涵了通过查询计算出的各个属性和结果集
     * 详细类结构和属性请参阅源码
     *
     * @param page
     * @return
     */
    @Override
    public Page<UserEntity> findAllUserByPage(PageRequest page) {
        return userDao.findAll(page);
    }
}

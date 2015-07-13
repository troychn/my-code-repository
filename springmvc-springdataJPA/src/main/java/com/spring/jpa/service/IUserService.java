package com.spring.jpa.service;

import com.spring.jpa.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * Created by lc on 2015/7/9.
 */
public interface IUserService {

    /**
     * 新建用户
     *
     * @param userEntity
     */
    public void saveUser(UserEntity userEntity);

    /**
     * 删除用户
     *
     * @param id
     */
    public void deleteUser(Integer id);

    /**
     * 查找单个用户
     *
     * @param id
     * @return
     */
    public UserEntity findUserById(Integer id);

    /**
     * 查找所有用户
     *
     * @return
     */
    public List<UserEntity> findAllUsers();

    /**
     * 根据一个分页对象查询user集合（还可以添加一个Store排序属性）
     * PageRequest    是spring自己封装的请求分页类，实现了Pageable接口，包涵从请求中获得的分页属性（当前页和大小）和获取方法
     * 通过调用分页方法，返回一个Page<>一个泛型集合的分页对象，里面包涵了通过查询计算出的各个属性和结果集
     * 详细类结构和属性请参阅源码
     *
     * @param page
     * @return
     */
    public Page<UserEntity> findAllUserByPage(PageRequest page);
}

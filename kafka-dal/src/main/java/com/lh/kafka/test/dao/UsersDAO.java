package com.lh.kafka.test.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.lh.kafka.test.entity.UsersDO;
import java.util.List;
import com.lh.kafka.test.mapper.UsersDOMapper;

/**
* The Table users.
* 用户表
*/
@Repository
public class UsersDAO{

    @Autowired
    private UsersDOMapper usersDOMapper;

    /**
     * desc:插入表:users.<br/>
     * @param entity entity
     * @return Long
     */
    public Long insert(UsersDO entity){
        return usersDOMapper.insert(entity);
    }
    /**
     * desc:批量插入表:users.<br/>
     * @param list list
     * @return Long
     */
    public Long insertBatch(List<UsersDO> list){
        return usersDOMapper.insertBatch(list);
    }
    /**
     * desc:根据主键删除数据:users.<br/>
     * @param id id
     * @return Long
     */
    public Long deleteById(Long id){
        return usersDOMapper.deleteById(id);
    }
    /**
     * desc:根据主键获取数据:users.<br/>
     * @param id id
     * @return UsersDO
     */
    public UsersDO getById(Long id){
        return usersDOMapper.getById(id);
    }
    /**
     * desc:根据唯一约束UsersPhone更新表:users.<br/>
     * @param entity entity
     * @return Long
     */
    public Long updateByUsersPhone(UsersDO entity){
        return usersDOMapper.updateByUsersPhone(entity);
    }
    /**
     * desc:根据唯一约束UsersPhone删除数据:users.<br/>
     * @param phone phone
     * @return Long
     */
    public Long deleteByUsersPhone(String phone){
        return usersDOMapper.deleteByUsersPhone(phone);
    }
    /**
     * desc:根据唯一约束UsersPhone获取数据:users.<br/>
     * @param phone phone
     * @return UsersDO
     */
    public UsersDO getByUsersPhone(String phone){
        return usersDOMapper.getByUsersPhone(phone);
    }
    /**
     * desc:getByUsersUserName.<br/>
     * @param phone phone
     * @return UsersDO
     */
    public UsersDO getByUsersUserName(String phone){
        return usersDOMapper.getByUsersUserName(phone);
    }
}

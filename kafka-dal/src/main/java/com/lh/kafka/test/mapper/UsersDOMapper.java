package com.lh.kafka.test.mapper;

import com.lh.kafka.test.entity.UsersDO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 由于需要对分页支持,请直接使用对应的DAO类
 * The Table users.
 * 用户表
 */
public interface UsersDOMapper{

    /**
     * desc:插入表:users.<br/>
     * @param entity entity
     * @return Long
     */
    Long insert(UsersDO entity);
    /**
     * desc:批量插入表:users.<br/>
     * @param list list
     * @return Long
     */
    Long insertBatch(List<UsersDO> list);
    /**
     * desc:根据主键删除数据:users.<br/>
     * @param id id
     * @return Long
     */
    Long deleteById(Long id);
    /**
     * desc:根据主键获取数据:users.<br/>
     * @param id id
     * @return UsersDO
     */
    UsersDO getById(Long id);
    /**
     * desc:根据唯一约束UsersPhone更新表:users.<br/>
     * @param entity entity
     * @return Long
     */
    Long updateByUsersPhone(UsersDO entity);
    /**
     * desc:根据唯一约束UsersPhone删除数据:users.<br/>
     * @param phone phone
     * @return Long
     */
    Long deleteByUsersPhone(@Param("phone")String phone);
    /**
     * desc:根据唯一约束UsersPhone获取数据:users.<br/>
     * @param phone phone
     * @return UsersDO
     */
    UsersDO getByUsersPhone(@Param("phone")String phone);
    /**
     * desc:getByUsersUserName.<br/>
     * @param phone phone
     * @return UsersDO
     */
    UsersDO getByUsersUserName(@Param("phone")String phone);
}

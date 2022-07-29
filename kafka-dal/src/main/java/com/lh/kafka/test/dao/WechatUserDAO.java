package com.lh.kafka.test.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.lh.kafka.test.entity.WechatUserDO;
import java.util.List;
import com.lh.kafka.test.mapper.WechatUserDOMapper;

/**
* The Table wechat_user.
* 用户微信表
*/
@Repository
public class WechatUserDAO{

    @Autowired
    private WechatUserDOMapper wechatUserDOMapper;

    /**
     * desc:插入表:wechat_user.<br/>
     * @param entity entity
     * @return Long
     */
    public Long insert(WechatUserDO entity){
        return wechatUserDOMapper.insert(entity);
    }
    /**
     * desc:批量插入表:wechat_user.<br/>
     * @param list list
     * @return Long
     */
    public Long insertBatch(List<WechatUserDO> list){
        return wechatUserDOMapper.insertBatch(list);
    }
    /**
     * desc:根据主键删除数据:wechat_user.<br/>
     * @param id id
     * @return Long
     */
    public Long deleteById(Long id){
        return wechatUserDOMapper.deleteById(id);
    }
    /**
     * desc:根据主键获取数据:wechat_user.<br/>
     * @param id id
     * @return WechatUserDO
     */
    public WechatUserDO getById(Long id){
        return wechatUserDOMapper.getById(id);
    }
    /**
     * desc:根据唯一约束WechatUserUserId更新表:wechat_user.<br/>
     * @param entity entity
     * @return Long
     */
    public Long updateByWechatUserUserId(WechatUserDO entity){
        return wechatUserDOMapper.updateByWechatUserUserId(entity);
    }
    /**
     * desc:根据唯一约束WechatUserUserId删除数据:wechat_user.<br/>
     * @param userId userId
     * @return Long
     */
    public Long deleteByWechatUserUserId(Long userId){
        return wechatUserDOMapper.deleteByWechatUserUserId(userId);
    }
    /**
     * desc:根据唯一约束WechatUserUserId获取数据:wechat_user.<br/>
     * @param userId userId
     * @return WechatUserDO
     */
    public WechatUserDO getByWechatUserUserId(Long userId){
        return wechatUserDOMapper.getByWechatUserUserId(userId);
    }
}

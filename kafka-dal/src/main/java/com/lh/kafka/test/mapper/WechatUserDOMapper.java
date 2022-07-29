package com.lh.kafka.test.mapper;

import com.lh.kafka.test.entity.WechatUserDO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 由于需要对分页支持,请直接使用对应的DAO类
 * The Table wechat_user.
 * 用户微信表
 */
public interface WechatUserDOMapper{

    /**
     * desc:插入表:wechat_user.<br/>
     * @param entity entity
     * @return Long
     */
    Long insert(WechatUserDO entity);
    /**
     * desc:批量插入表:wechat_user.<br/>
     * @param list list
     * @return Long
     */
    Long insertBatch(List<WechatUserDO> list);
    /**
     * desc:根据主键删除数据:wechat_user.<br/>
     * @param id id
     * @return Long
     */
    Long deleteById(Long id);
    /**
     * desc:根据主键获取数据:wechat_user.<br/>
     * @param id id
     * @return WechatUserDO
     */
    WechatUserDO getById(Long id);
    /**
     * desc:根据唯一约束WechatUserUserId更新表:wechat_user.<br/>
     * @param entity entity
     * @return Long
     */
    Long updateByWechatUserUserId(WechatUserDO entity);
    /**
     * desc:根据唯一约束WechatUserUserId删除数据:wechat_user.<br/>
     * @param userId userId
     * @return Long
     */
    Long deleteByWechatUserUserId(Long userId);
    /**
     * desc:根据唯一约束WechatUserUserId获取数据:wechat_user.<br/>
     * @param userId userId
     * @return WechatUserDO
     */
    WechatUserDO getByWechatUserUserId(Long userId);
}

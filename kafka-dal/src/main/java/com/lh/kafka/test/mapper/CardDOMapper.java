package com.lh.kafka.test.mapper;

import com.lh.kafka.test.entity.CardDO;

import java.util.List;

/**
 * 由于需要对分页支持,请直接使用对应的DAO类
 * The Table card.
 * CARD
 */
public interface CardDOMapper {

    /**
     * desc:插入表:card.<br/>
     *
     * @param entity entity
     * @return Long
     */
    Long insert(CardDO entity);

    /**
     * desc:批量插入表:card.<br/>
     *
     * @param list list
     * @return Long
     */
    Long insertBatch(List<CardDO> list);

    /**
     * desc:根据主键删除数据:card.<br/>
     *
     * @param id id
     * @return Long
     */
    Long deleteById(Long id);

    /**
     * desc:根据主键获取数据:card.<br/>
     *
     * @param id id
     * @return CardDO
     */
    CardDO getById(Long id);
}

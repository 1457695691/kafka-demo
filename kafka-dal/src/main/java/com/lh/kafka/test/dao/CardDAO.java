package com.lh.kafka.test.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.lh.kafka.test.entity.CardDO;
import java.util.List;
import com.lh.kafka.test.mapper.CardDOMapper;

/**
* The Table card.
* CARD
*/
@Repository
public class CardDAO{

    @Autowired
    private CardDOMapper cardDOMapper;

    /**
     * desc:插入表:card.<br/>
     * @param entity entity
     * @return Long
     */
    public Long insert(CardDO entity){
        return cardDOMapper.insert(entity);
    }
    /**
     * desc:批量插入表:card.<br/>
     * @param list list
     * @return Long
     */
    public Long insertBatch(List<CardDO> list){
        return cardDOMapper.insertBatch(list);
    }
    /**
     * desc:根据主键删除数据:card.<br/>
     * @param id id
     * @return Long
     */
    public Long deleteById(Long id){
        return cardDOMapper.deleteById(id);
    }
    /**
     * desc:根据主键获取数据:card.<br/>
     * @param id id
     * @return CardDO
     */
    public CardDO getById(Long id){
        return cardDOMapper.getById(id);
    }
}

package com.lh.kafka.test.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.lh.kafka.test.entity.TableNameDO;
import java.util.List;
import com.lh.kafka.test.mapper.TableNameDOMapper;

/**
* The Table table_name.
* TABLE_NAME
*/
@Repository
public class TableNameDAO{

    @Autowired
    private TableNameDOMapper tableNameDOMapper;

    /**
     * desc:插入表:table_name.<br/>
     * @param entity entity
     * @return Long
     */
    public Long insert(TableNameDO entity){
        return tableNameDOMapper.insert(entity);
    }
    /**
     * desc:批量插入表:table_name.<br/>
     * @param list list
     * @return Long
     */
    public Long insertBatch(List<TableNameDO> list){
        return tableNameDOMapper.insertBatch(list);
    }
    /**
     * desc:根据主键删除数据:table_name.<br/>
     * @param id id
     * @return Long
     */
    public Long deleteById(Long id){
        return tableNameDOMapper.deleteById(id);
    }
    /**
     * desc:根据主键获取数据:table_name.<br/>
     * @param id id
     * @return TableNameDO
     */
    public TableNameDO getById(Long id){
        return tableNameDOMapper.getById(id);
    }
}

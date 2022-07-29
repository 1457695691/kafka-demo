package com.lh.kafka.test.mapper;

import com.lh.kafka.test.entity.TableNameDO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 由于需要对分页支持,请直接使用对应的DAO类
 * The Table table_name.
 * TABLE_NAME
 */
public interface TableNameDOMapper{

    /**
     * desc:插入表:table_name.<br/>
     * @param entity entity
     * @return Long
     */
    Long insert(TableNameDO entity);
    /**
     * desc:批量插入表:table_name.<br/>
     * @param list list
     * @return Long
     */
    Long insertBatch(List<TableNameDO> list);
    /**
     * desc:根据主键删除数据:table_name.<br/>
     * @param id id
     * @return Long
     */
    Long deleteById(Long id);
    /**
     * desc:根据主键获取数据:table_name.<br/>
     * @param id id
     * @return TableNameDO
     */
    TableNameDO getById(Long id);
}

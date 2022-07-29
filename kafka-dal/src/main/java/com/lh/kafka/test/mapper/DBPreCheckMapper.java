package com.lh.kafka.test.mapper;
import java.util.List;
/**
 * 数据库字段检查
 */
public interface DBPreCheckMapper{

    List<String> dbColumnCheck();
}

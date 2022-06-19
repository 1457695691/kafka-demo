package com.lh.kafka.error;

/**
 * @author lh
 * 自定义错误接口
 */
public interface AppError {

    /**
     * 获取代码
     *
     * @return String
     */
    String getErrorCode();

    /**
     * 获取详情
     *
     * @return String
     */
    String getErrorMessage();
}
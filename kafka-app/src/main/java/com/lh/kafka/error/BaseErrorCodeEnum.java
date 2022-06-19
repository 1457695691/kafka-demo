package com.lh.kafka.error;

/**
 * 错误代码枚举
 *
 * @author lh
 */
public enum BaseErrorCodeEnum implements AppError {

    SUCCESS("成功", "SUCCESS"),
    ERROR_SYS_1001("sorry，网站服务忙，稍后再试～", "SYS1001"),
    ERROR_SYS_1002("参数错误", "SYS1002");

    private final String errorCode;
    private final String errorMsg;

    BaseErrorCodeEnum(String errorMsg, String errorCode) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    @Override
    public String getErrorCode() {
        return this.errorCode;
    }

    @Override
    public String getErrorMessage() {
        return this.errorMsg;
    }
}

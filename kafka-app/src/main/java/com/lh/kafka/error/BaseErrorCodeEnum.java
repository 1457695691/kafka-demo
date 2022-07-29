package com.lh.kafka.error;

/**
 * 错误代码枚举
 *
 * @author lh
 */
public enum BaseErrorCodeEnum implements AppError {

    SUCCESS("成功", "SUCCESS"),
    ERROR_SYS_1001("sorry，网站服务忙，稍后再试～", "SYS1001"),
    ERROR_SYS_1002("参数错误", "SYS1002"),
    ERROR_SYS_1003("密码错误，请检查", "SYS1003"),

    ERROR_USER_1001("sorry，该手机号已注册～", "USER1001"),
    ERROR_USER_1002("sorry，该用户不存在请重新注册～", "USER1002"),
    ERROR_USER_1003("登录过期，请重新登录", "USER1003"),
    ;

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

package com.lh.kafka.entitys;


import com.lh.kafka.error.AppError;
import com.lh.kafka.error.BaseErrorCodeEnum;

import java.io.Serializable;

/**
 * 统一响应报文
 *
 * @author lh
 */
public class JsonResponse<T> implements Serializable {

    //防止序列化失败
    private static final Long serialVersionUID = -1L;

    private Boolean success = true;
    private String errorCode;
    private String errorMsg;
    private T data;

    public JsonResponse() {
        this.errorCode = BaseErrorCodeEnum.SUCCESS.getErrorCode();
        this.errorMsg = BaseErrorCodeEnum.SUCCESS.getErrorMessage();
    }

    public JsonResponse setError(AppError error) {
        this.success = false;
        this.errorCode = error.getErrorCode();
        this.errorMsg = error.getErrorMessage();
        return this;
    }

    public Boolean isSuccess() {
        return this.success;
    }

    public JsonResponse setSuccess(Boolean success) {
        this.success = success;
        return this;
    }

    public String getErrorCode() {
        return null != this.errorCode && !"null".equals(this.errorCode) ? this.errorCode : "";
    }

    public JsonResponse setErrorCode(String errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    public String getErrorMsg() {
        return null != this.errorMsg && !"null".equals(this.errorMsg) ? this.errorMsg : "";
    }

    public JsonResponse setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
        return this;
    }

    public T getData() {
        return this.data;
    }

    public JsonResponse<T> setData(T data) {
        this.data = data;
        return this;
    }

    public static <T> JsonResponse<T> success(T data) {
        return (new JsonResponse()).setData(data);
    }

    public static <T> JsonResponse<T> success() {
        return (new JsonResponse()).setData(null);
    }

    public static JsonResponse fail(String code, String message) {
        return (new JsonResponse()).setSuccess(false).setErrorCode(code).setErrorMsg(message);
    }

    public static JsonResponse fail(String message) {
        return (new JsonResponse()).setSuccess(false).setErrorMsg(message).setErrorCode("FALSE").setData("");
    }

    public static JsonResponse fail(BaseErrorCodeEnum codeenum) {
        return (new JsonResponse()).setSuccess(false).setErrorCode(codeenum.getErrorCode()).setErrorMsg(codeenum.getErrorMessage());
    }

    public static JsonResponse fail(AppError codeenum) {
        return (new JsonResponse()).setSuccess(false).setErrorCode(codeenum.getErrorCode()).setErrorMsg(codeenum.getErrorMessage());
    }

    @Override
    public String toString() {
        return "JsonResponse{success=" + this.success + ", errorCode='" + this.errorCode + '\'' + ", errorMsg='" + this.errorMsg + '\'' + ", data=" + this.data + '}';
    }
}
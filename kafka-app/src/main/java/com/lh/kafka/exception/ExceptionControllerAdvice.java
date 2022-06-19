package com.lh.kafka.exception;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lh.kafka.annotation.BodyReaderRequestWrapper;
import com.lh.kafka.entitys.JsonResponse;
import com.lh.kafka.error.BaseErrorCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author lh
 * @Description SpringController 异常捕获处理增强
 **/
@Slf4j
@ControllerAdvice
public class ExceptionControllerAdvice {

    /**
     * 全局未知异常捕捉处理
     *
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Throwable.class)
    public JSONObject errorHandler(
            HttpServletRequest request,
            Throwable ex
    ) {
        try {
            BodyReaderRequestWrapper requestWrapper = new BodyReaderRequestWrapper(request);
            log.error("errorHandler path:{} requestBody:{} e:{}",
                    request.getServletPath(),
                    requestWrapper.getBody(),
                    ex
            );
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        JsonResponse jsonResponse = new JsonResponse();
        jsonResponse.setSuccess(false);
        jsonResponse.setErrorCode(BaseErrorCodeEnum.ERROR_SYS_1001.getErrorCode());
        jsonResponse.setErrorMsg(BaseErrorCodeEnum.ERROR_SYS_1001.getErrorMessage());
        JSONObject jsonObject = (JSONObject) JSON.toJSON(jsonResponse);
        return jsonObject;
    }

    /**
     * 拦截捕捉自定义异常 AppException.class
     *
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = AppException.class)
    public JSONObject myErrorHandler(HttpServletRequest request, AppException ex) {
        try {
            BodyReaderRequestWrapper requestWrapper = new BodyReaderRequestWrapper(request);
            log.error("errorHandler path:{} requestBody:{} e:{}",
                    request.getServletPath(),
                    requestWrapper.getBody(),
                    ex
            );
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        JsonResponse jsonResponse = new JsonResponse();
        jsonResponse.setSuccess(false);
        jsonResponse.setErrorCode(ex.getErrorCode());
        jsonResponse.setErrorMsg(ex.getMessage());
        jsonResponse.setData(JSONObject.toJSON(ex.getResult()));
        JSONObject jsonObject = (JSONObject) JSON.toJSON(jsonResponse);
        return jsonObject;
    }

    /**
     * 拦截Request入惨异常 MethodArgumentNotValidException.class
     *
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public JSONObject argumentNotValidExceptionErrorHandler(
            MethodArgumentNotValidException ex,
            HttpServletRequest request
    ) {
        try {
            BodyReaderRequestWrapper requestWrapper = new BodyReaderRequestWrapper(request);
            log.error("businessExceptionErrorHandler path:{} requestBody:{} e:{}",
                    request.getServletPath(),
                    requestWrapper.getBody(),
                    ex
            );
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        JsonResponse jsonResponse = new JsonResponse();
        jsonResponse.setSuccess(false);
        jsonResponse.setErrorCode(BaseErrorCodeEnum.ERROR_SYS_1002.getErrorCode());
        FieldError fieldError = ex.getBindingResult().getFieldError();
        jsonResponse.setErrorMsg(fieldError.getDefaultMessage());
        JSONObject jsonObject = (JSONObject) JSON.toJSON(jsonResponse);
        return jsonObject;
    }


}
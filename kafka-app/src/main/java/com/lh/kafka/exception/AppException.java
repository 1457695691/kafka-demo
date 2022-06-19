package com.lh.kafka.exception;

import com.alibaba.fastjson.JSONObject;
import com.lh.kafka.error.AppError;
import org.springframework.util.StringUtils;

import java.text.MessageFormat;

/**
 * @author lh
 */

public class AppException extends RuntimeException {
	private String errorCode;
	private String errorMsg;
	private Object[] params;
	private JSONObject result;

	public AppException() {
		super();
	}

	public AppException(AppError appError) {
		super(appError.getErrorCode());
		this.errorCode = appError.getErrorCode();
		this.errorMsg = appError.getErrorMessage();
	}

	public AppException(AppError appError, JSONObject result) {
		super(appError.getErrorCode());
		this.errorCode = appError.getErrorCode();
		this.errorMsg = appError.getErrorMessage();
		this.result = result;
	}

	public AppException(String errorCode, String errorMsg) {
		super(errorCode);
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}

	public AppException(String errorCode, String errorMsg, Object... params) {
		super(errorCode);
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
		this.params = params;
	}

	public AppException(AppError appError, Object... params) {
		super(appError.getErrorCode());
		this.errorCode = appError.getErrorCode();
		this.errorMsg = appError.getErrorMessage();
		this.params = params;
	}

	public AppException(String errorCode, Throwable cause) {
		super(errorCode, cause);
		this.errorCode = errorCode;
	}

	public AppException(Throwable cause) {
		super(cause);
	}

	@Override
	public String getMessage() {
		String message;
		if (StringUtils.hasText(this.errorMsg)) {
			if (params != null && params.length > 0) {
				message = MessageFormat.format(this.errorMsg, this.params);
			} else {
				message = this.errorMsg;
			}
		} else {
			message = super.getMessage();
		}
		return message;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public Object getResult() {
		return result;
	}
}

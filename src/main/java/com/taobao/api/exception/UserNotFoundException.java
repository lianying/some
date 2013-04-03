package com.taobao.api.exception;


public class UserNotFoundException extends TaobaoApiException {
    public UserNotFoundException(String errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }

    public UserNotFoundException(Throwable cause) {
        super(cause);
    }

    public UserNotFoundException(String errorCode, String errorMessage, String subErrorCode, String subErrorMessage) {
        super(errorCode, errorMessage, subErrorCode, subErrorMessage);
    }
}

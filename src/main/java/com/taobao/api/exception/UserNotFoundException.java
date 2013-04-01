package com.taobao.api.exception;


@SuppressWarnings("serial")
public class UserNotFoundException extends TaobaoApiException {

    public UserNotFoundException(String message, String errorCode, String errorMessage, String subErrorCode,
        String subErrorMessage) {
        super(message, errorCode, errorMessage, subErrorCode, subErrorMessage);
    }

    public UserNotFoundException(String errorCode, String errorMessage, String subErrorCode, String subErrorMessage) {
        super(errorCode, errorMessage, subErrorCode, subErrorMessage);
    }

    public UserNotFoundException(String errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }

}

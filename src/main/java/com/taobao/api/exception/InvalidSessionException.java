package com.taobao.api.exception;


public class InvalidSessionException extends AuthException {
    public InvalidSessionException(String errorCode, String errorMessage, String subErrorCode, String subErrorMessage) {
        super(errorCode, errorMessage, subErrorCode, subErrorMessage, null);
    }
}

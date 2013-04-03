package com.taobao.api.exception;


public class R2AuthorizeInvalidException extends AuthException {
    public R2AuthorizeInvalidException(String errorCode, String errorMessage, String subErrorCode, String subErrorMessage, String session) {
        super(errorCode, errorMessage, subErrorCode, subErrorMessage, session);
    }
}

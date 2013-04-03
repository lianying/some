package com.taobao.api.exception;


public class ItemNotFoundException extends TaobaoApiException {
    public ItemNotFoundException(String errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }

    public ItemNotFoundException(String errorCode, String errorMessage, String subErrorCode, String subErrorMessage) {
        super(errorCode, errorMessage, subErrorCode, subErrorMessage);
    }

    public ItemNotFoundException(Throwable cause) {
        super(cause);
    }
}

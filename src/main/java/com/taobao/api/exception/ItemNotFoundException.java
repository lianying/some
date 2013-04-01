package com.taobao.api.exception;

public class ItemNotFoundException extends ItemException {
    private static final long serialVersionUID = 1L;

    public ItemNotFoundException(String errorCode, String errorMessage, String subErrorCode, String subErrorMessage) {
        super(errorCode, errorMessage, subErrorCode, subErrorMessage);
    }
}

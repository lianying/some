package com.taobao.api.exception;


public class ShopNotFoundException extends TaobaoApiException {
    public ShopNotFoundException(String errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }

    public ShopNotFoundException(Throwable cause) {
        super(cause);
    }

    public ShopNotFoundException(String errorCode, String errorMessage, String subErrorCode, String subErrorMessage) {
        super(errorCode, errorMessage, subErrorCode, subErrorMessage);
    }
}

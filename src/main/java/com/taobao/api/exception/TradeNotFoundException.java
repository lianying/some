package com.taobao.api.exception;


public class TradeNotFoundException extends TaobaoApiException {
    public TradeNotFoundException(String errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }

    public TradeNotFoundException(Throwable cause) {
        super(cause);
    }

    public TradeNotFoundException(String errorCode, String errorMessage, String subErrorCode, String subErrorMessage) {
        super(errorCode, errorMessage, subErrorCode, subErrorMessage);
    }
}

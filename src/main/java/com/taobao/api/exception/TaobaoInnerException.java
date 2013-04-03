package com.taobao.api.exception;


/**
 * 淘宝服务平台内部错误导致的异常
 */
public class TaobaoInnerException extends TaobaoApiException {
    public TaobaoInnerException(String errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }

    public TaobaoInnerException(Throwable cause) {
        super(cause);
    }

    public TaobaoInnerException(String errorCode, String errorMessage, String subErrorCode, String subErrorMessage) {
        super(errorCode, errorMessage, subErrorCode, subErrorMessage);
    }
}

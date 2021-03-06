package com.taobao.api.exception;


/**
 * 重试超过最大重试次数时抛出的异常
 */
public class ReachMaxRetrysException extends TaobaoApiException {
    public ReachMaxRetrysException(String errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }

    public ReachMaxRetrysException(Throwable cause) {
        super(cause);
    }

    public ReachMaxRetrysException(String errorCode, String errorMessage, String subErrorCode, String subErrorMessage) {
        super(errorCode, errorMessage, subErrorCode, subErrorMessage);
    }
}

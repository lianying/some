package com.taobao.api.exception;

public class RemoteServiceTimeoutException extends TaobaoInnerException {
    public RemoteServiceTimeoutException(String errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }

    public RemoteServiceTimeoutException(Throwable cause) {
        super(cause);
    }

    public RemoteServiceTimeoutException(String errorCode, String errorMessage, String subErrorCode, String subErrorMessage) {
        super(errorCode, errorMessage, subErrorCode, subErrorMessage);
    }
}

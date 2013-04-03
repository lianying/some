package com.taobao.api.exception;

public class RemoteConnectionTimeoutException extends TaobaoInnerException {

    public RemoteConnectionTimeoutException(String errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }

    public RemoteConnectionTimeoutException(Throwable cause) {
        super(cause);
    }

    public RemoteConnectionTimeoutException(String errorCode, String errorMessage, String subErrorCode, String subErrorMessage) {
        super(errorCode, errorMessage, subErrorCode, subErrorMessage);
    }
}

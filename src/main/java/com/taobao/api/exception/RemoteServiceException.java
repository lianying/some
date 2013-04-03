package com.taobao.api.exception;


public class RemoteServiceException extends TaobaoApiException {
    public RemoteServiceException(Throwable cause) {
        super(cause);
    }

    public RemoteServiceException(String errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }

    public RemoteServiceException(String errorCode, String errorMessage, String subErrorCode, String subErrorMessage) {
        super(errorCode, errorMessage, subErrorCode, subErrorMessage);
    }
}

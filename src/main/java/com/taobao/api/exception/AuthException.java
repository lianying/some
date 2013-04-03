package com.taobao.api.exception;


/**
 * 授权异常，比如Session过期，R2级别授权过期
 */
public abstract class AuthException extends TaobaoApiException {
    private String session;

    public AuthException(String errorCode, String errorMessage, String subErrorCode, String subErrorMessage, String session) {
        super(errorCode, errorMessage, subErrorCode, subErrorMessage);
        this.session = session;
    }

    /**
     * @return Taobao API Session
     */
    public String getSession() {
        return session;
    }
}

package com.taobao.api;

public interface ExceptionHandler {
    /**
     * 处理异常
     * @param e
     */
    public void handle(TaobaoApiException e);
}

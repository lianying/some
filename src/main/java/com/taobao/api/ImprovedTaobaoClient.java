/**   
 * @Title: ImprovedTaobaoClient.java 
 * @Package com.thinkgem.jeesite.modules.top.service.topapi 
 * @Description: TODO
 * @author 10060484
 * @date 2013/03/22 15:33:39 
 * @version V1.0   
 */
package com.taobao.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.taobao.api.exception.ErrorResponseTranslator;
import com.taobao.api.exception.ReachMaxRetrysException;

/**
 * @author 10060484
 * 
 */
public class ImprovedTaobaoClient {

	private static Logger log = LoggerFactory
			.getLogger(ImprovedTaobaoClient.class);

	private static final int MAX_RETRIES = 3;

	private DefaultTaobaoClient defaultTaobaoClient;
	
	public ImprovedTaobaoClient(String serverUrl, String appKey,
			String appSecret) {
		defaultTaobaoClient = new DefaultTaobaoClient(serverUrl, appKey, appSecret);
	}

	public <T extends TaobaoResponse> T execute(TaobaoRequest<T> request) {
		return executeInner(request, null, MAX_RETRIES);
	}

	public <T extends TaobaoResponse> T execute(TaobaoRequest<T> request,
			String session) {
		return executeInner(request, session, MAX_RETRIES);
	}

	/**
	 * @param retries
	 *            已经重试过的次数
	 * @param <T>
	 * @return
	 */
	private <T extends TaobaoResponse> T executeInner(TaobaoRequest<T> request,
			String session, int retries) {
		T response = null;
		try {
			if (session == null) {
				response = defaultTaobaoClient.execute(request);
			} else {
				response = defaultTaobaoClient.execute(request, session);
			}
		} catch (ApiException e) {
			if (retries < MAX_RETRIES) {
				Object[] params = new Object[] {
						request.getClass().getSimpleName(), retries + 1,
						e.getMessage() };
				log.info(
						"retry to execute taobao api request: {}, retries:{}, {}",
						params);
				return executeInner(request, session, retries + 1);
			}
			throw new ReachMaxRetrysException(e);
		}
		
		if (!response.isSuccess()) {
			String errorCode = response.getErrorCode();
			String errorMessage = response.getMsg();
			String subErrorCode = response.getSubCode();
			String subErrorMessage = response.getSubMsg();
			ErrorResponseTranslator.throwException(errorCode, errorMessage,
					subErrorCode, subErrorMessage, null);
		}

		return response;
	}

}

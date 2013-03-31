package com.taobao.api.response;

import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.domain.Shipping;

import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.logistics.dummy.send response.
 * 
 * @author auto create
 * @since 1.0, null
 */
public class LogisticsDummySendResponse extends TaobaoResponse {

	private static final long serialVersionUID = 8175482257685933317L;

	/** 
	 * 返回发货是否成功is_success
	 */
	@ApiField("shipping")
	private Shipping shipping;

	public void setShipping(Shipping shipping) {
		this.shipping = shipping;
	}
	public Shipping getShipping( ) {
		return this.shipping;
	}

}

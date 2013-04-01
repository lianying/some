package com.taobao.api.response;

import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.domain.Sku;

import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.item.sku.delete response.
 * 
 * @author auto create
 * @since 1.0, null
 */
public class ItemSkuDeleteResponse extends TaobaoResponse {

	private static final long serialVersionUID = 8396726785497382188L;

	/** 
	 * Sku结构
	 */
	@ApiField("sku")
	private Sku sku;

	public void setSku(Sku sku) {
		this.sku = sku;
	}
	public Sku getSku( ) {
		return this.sku;
	}

}

package com.taobao.api.response;

import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.domain.PropImg;

import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.item.propimg.upload response.
 * 
 * @author auto create
 * @since 1.0, null
 */
public class ItemPropimgUploadResponse extends TaobaoResponse {

	private static final long serialVersionUID = 4234588184537431433L;

	/** 
	 * PropImg属性图片结构
	 */
	@ApiField("prop_img")
	private PropImg propImg;

	public void setPropImg(PropImg propImg) {
		this.propImg = propImg;
	}
	public PropImg getPropImg( ) {
		return this.propImg;
	}

}

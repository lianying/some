package com.taobao.api.response;

import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.domain.ItemImg;

import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.item.img.delete response.
 * 
 * @author auto create
 * @since 1.0, null
 */
public class ItemImgDeleteResponse extends TaobaoResponse {

	private static final long serialVersionUID = 7679811495587426332L;

	/** 
	 * 商品图片结构
	 */
	@ApiField("item_img")
	private ItemImg itemImg;

	public void setItemImg(ItemImg itemImg) {
		this.itemImg = itemImg;
	}
	public ItemImg getItemImg( ) {
		return this.itemImg;
	}

}

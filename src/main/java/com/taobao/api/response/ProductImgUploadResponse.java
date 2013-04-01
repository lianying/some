package com.taobao.api.response;

import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.domain.ProductImg;

import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.product.img.upload response.
 * 
 * @author auto create
 * @since 1.0, null
 */
public class ProductImgUploadResponse extends TaobaoResponse {

	private static final long serialVersionUID = 3494954365381534769L;

	/** 
	 * 返回产品图片结构中的：url,id,created,modified
	 */
	@ApiField("product_img")
	private ProductImg productImg;

	public void setProductImg(ProductImg productImg) {
		this.productImg = productImg;
	}
	public ProductImg getProductImg( ) {
		return this.productImg;
	}

}

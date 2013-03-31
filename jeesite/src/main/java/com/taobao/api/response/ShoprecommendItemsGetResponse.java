package com.taobao.api.response;

import java.util.List;
import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.internal.mapping.ApiListField;
import com.taobao.api.domain.FavoriteItem;

import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.shoprecommend.items.get response.
 * 
 * @author auto create
 * @since 1.0, null
 */
public class ShoprecommendItemsGetResponse extends TaobaoResponse {

	private static final long serialVersionUID = 8765144448255896674L;

	/** 
	 * 返回与店铺关联的宝贝集合
	 */
	@ApiListField("favorite_items")
	@ApiField("favorite_item")
	private List<FavoriteItem> favoriteItems;

	public void setFavoriteItems(List<FavoriteItem> favoriteItems) {
		this.favoriteItems = favoriteItems;
	}
	public List<FavoriteItem> getFavoriteItems( ) {
		return this.favoriteItems;
	}

}

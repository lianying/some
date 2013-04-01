package com.taobao.api.request;

import com.taobao.api.internal.util.RequestCheckUtils;
import java.util.Map;

import com.taobao.api.TaobaoRequest;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.response.MarketingPromotionKfcResponse;
import com.taobao.api.ApiRuleException;
/**
 * TOP API: taobao.marketing.promotion.kfc request
 * 
 * @author auto create
 * @since 1.0, 2013-03-14 16:30:16
 */
public class MarketingPromotionKfcRequest implements TaobaoRequest<MarketingPromotionKfcResponse> {

	private TaobaoHashMap udfParams; // add user-defined text parameters
	private Long timestamp;

	/** 
	* 活动描述
	 */
	private String promotionDesc;

	/** 
	* 活动名称
	 */
	private String promotionTitle;

	public void setPromotionDesc(String promotionDesc) {
		this.promotionDesc = promotionDesc;
	}
	public String getPromotionDesc() {
		return this.promotionDesc;
	}

	public void setPromotionTitle(String promotionTitle) {
		this.promotionTitle = promotionTitle;
	}
	public String getPromotionTitle() {
		return this.promotionTitle;
	}
	private Map<String,String> headerMap=new TaobaoHashMap();
	
	public Long getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public String getApiMethodName() {
		return "taobao.marketing.promotion.kfc";
	}

	public Map<String, String> getTextParams() {		
		TaobaoHashMap txtParams = new TaobaoHashMap();
		txtParams.put("promotion_desc", this.promotionDesc);
		txtParams.put("promotion_title", this.promotionTitle);
		if(this.udfParams != null) {
			txtParams.putAll(this.udfParams);
		}
		return txtParams;
	}

	public void putOtherTextParam(String key, String value) {
		if(this.udfParams == null) {
			this.udfParams = new TaobaoHashMap();
		}
		this.udfParams.put(key, value);
	}

	public Class<MarketingPromotionKfcResponse> getResponseClass() {
		return MarketingPromotionKfcResponse.class;
	}

	public void check() throws ApiRuleException {
		
		RequestCheckUtils.checkNotEmpty(promotionDesc,"promotionDesc");
		RequestCheckUtils.checkNotEmpty(promotionTitle,"promotionTitle");
	}
	
	public Map<String,String> getHeaderMap() {
		return headerMap;
	}
}

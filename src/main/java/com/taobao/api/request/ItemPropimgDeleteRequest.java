package com.taobao.api.request;

import com.taobao.api.internal.util.RequestCheckUtils;
import java.util.Map;

import com.taobao.api.TaobaoRequest;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.response.ItemPropimgDeleteResponse;
import com.taobao.api.ApiRuleException;
/**
 * TOP API: taobao.item.propimg.delete request
 * 
 * @author auto create
 * @since 1.0, 2013-03-14 16:30:14
 */
public class ItemPropimgDeleteRequest implements TaobaoRequest<ItemPropimgDeleteResponse> {

	private TaobaoHashMap udfParams; // add user-defined text parameters
	private Long timestamp;

	/** 
	* 商品属性图片ID
	 */
	private Long id;

	/** 
	* 商品数字ID，必选
	 */
	private Long numIid;

	public void setId(Long id) {
		this.id = id;
	}
	public Long getId() {
		return this.id;
	}

	public void setNumIid(Long numIid) {
		this.numIid = numIid;
	}
	public Long getNumIid() {
		return this.numIid;
	}
	private Map<String,String> headerMap=new TaobaoHashMap();
	
	public Long getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public String getApiMethodName() {
		return "taobao.item.propimg.delete";
	}

	public Map<String, String> getTextParams() {		
		TaobaoHashMap txtParams = new TaobaoHashMap();
		txtParams.put("id", this.id);
		txtParams.put("num_iid", this.numIid);
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

	public Class<ItemPropimgDeleteResponse> getResponseClass() {
		return ItemPropimgDeleteResponse.class;
	}

	public void check() throws ApiRuleException {
		
		RequestCheckUtils.checkNotEmpty(id,"id");
		RequestCheckUtils.checkNotEmpty(numIid,"numIid");
		RequestCheckUtils.checkMinValue(numIid,0L,"numIid");
	}
	
	public Map<String,String> getHeaderMap() {
		return headerMap;
	}
}

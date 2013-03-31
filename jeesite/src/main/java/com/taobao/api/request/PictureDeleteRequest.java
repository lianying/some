package com.taobao.api.request;

import com.taobao.api.internal.util.RequestCheckUtils;
import java.util.Map;

import com.taobao.api.TaobaoRequest;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.response.PictureDeleteResponse;
import com.taobao.api.ApiRuleException;
/**
 * TOP API: taobao.picture.delete request
 * 
 * @author auto create
 * @since 1.0, 2013-03-14 16:30:18
 */
public class PictureDeleteRequest implements TaobaoRequest<PictureDeleteResponse> {

	private TaobaoHashMap udfParams; // add user-defined text parameters
	private Long timestamp;

	/** 
	* 图片ID字符串,可以一个也可以一组,用英文逗号间隔,如450,120,155
	 */
	private String pictureIds;

	public void setPictureIds(String pictureIds) {
		this.pictureIds = pictureIds;
	}
	public String getPictureIds() {
		return this.pictureIds;
	}
	private Map<String,String> headerMap=new TaobaoHashMap();
	
	public Long getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public String getApiMethodName() {
		return "taobao.picture.delete";
	}

	public Map<String, String> getTextParams() {		
		TaobaoHashMap txtParams = new TaobaoHashMap();
		txtParams.put("picture_ids", this.pictureIds);
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

	public Class<PictureDeleteResponse> getResponseClass() {
		return PictureDeleteResponse.class;
	}

	public void check() throws ApiRuleException {
		
		RequestCheckUtils.checkNotEmpty(pictureIds,"pictureIds");
	}
	
	public Map<String,String> getHeaderMap() {
		return headerMap;
	}
}

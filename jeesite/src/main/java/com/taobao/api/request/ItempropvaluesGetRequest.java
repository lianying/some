package com.taobao.api.request;

import com.taobao.api.internal.util.RequestCheckUtils;
import java.util.Map;

import com.taobao.api.TaobaoRequest;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.response.ItempropvaluesGetResponse;
import com.taobao.api.ApiRuleException;
/**
 * TOP API: taobao.itempropvalues.get request
 * 
 * @author auto create
 * @since 1.0, 2013-03-14 16:30:14
 */
public class ItempropvaluesGetRequest implements TaobaoRequest<ItempropvaluesGetResponse> {

	private TaobaoHashMap udfParams; // add user-defined text parameters
	private Long timestamp;

	/** 
	* 叶子类目ID ,通过taobao.itemcats.get获得叶子类目ID
	 */
	private Long cid;

	/** 
	* 需要返回的字段。目前支持有：cid,pid,prop_name,vid,name,name_alias,status,sort_order
	 */
	private String fields;

	/** 
	* 属性和属性值 id串，格式例如(pid1;pid2)或(pid1:vid1;pid2:vid2)或(pid1;pid2:vid2)
	 */
	private String pvs;

	/** 
	* 获取类目的类型：1代表集市、2代表天猫
	 */
	private Long type;

	public void setCid(Long cid) {
		this.cid = cid;
	}
	public Long getCid() {
		return this.cid;
	}

	public void setFields(String fields) {
		this.fields = fields;
	}
	public String getFields() {
		return this.fields;
	}

	public void setPvs(String pvs) {
		this.pvs = pvs;
	}
	public String getPvs() {
		return this.pvs;
	}

	public void setType(Long type) {
		this.type = type;
	}
	public Long getType() {
		return this.type;
	}
	private Map<String,String> headerMap=new TaobaoHashMap();
	
	public Long getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public String getApiMethodName() {
		return "taobao.itempropvalues.get";
	}

	public Map<String, String> getTextParams() {		
		TaobaoHashMap txtParams = new TaobaoHashMap();
		txtParams.put("cid", this.cid);
		txtParams.put("fields", this.fields);
		txtParams.put("pvs", this.pvs);
		txtParams.put("type", this.type);
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

	public Class<ItempropvaluesGetResponse> getResponseClass() {
		return ItempropvaluesGetResponse.class;
	}

	public void check() throws ApiRuleException {
		
		RequestCheckUtils.checkNotEmpty(cid,"cid");
		RequestCheckUtils.checkNotEmpty(fields,"fields");
		RequestCheckUtils.checkMaxValue(type,2L,"type");
		RequestCheckUtils.checkMinValue(type,1L,"type");
	}
	
	public Map<String,String> getHeaderMap() {
		return headerMap;
	}
}

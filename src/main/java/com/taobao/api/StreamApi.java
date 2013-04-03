package com.taobao.api;

import java.util.Date;
import java.util.List;

import com.taobao.api.domain.DiscardInfo;
import com.taobao.api.domain.NotifyTrade;
import com.taobao.api.request.CometDiscardinfoGetRequest;
import com.taobao.api.request.IncrementCustomerPermitRequest;
import com.taobao.api.request.IncrementTradesGetRequest;
import com.taobao.api.response.CometDiscardinfoGetResponse;
import com.taobao.api.response.IncrementTradesGetResponse;

/**
 * 主动通知业务API
 * 
 * @author Simon Leung
 *
 */
public class StreamApi {
	private ImprovedTaobaoClient taobaoClient;
	
	public StreamApi(ImprovedTaobaoClient taobaoClient) {
		this.taobaoClient = taobaoClient;
	}
	
	/**
	 * 为用户开通主动通知业务 <a href="http://api.taobao.com/apidoc/api.htm?path=cid:39-apiId:10882">taobao.increment.customer.permit </a>
	 * 
	 * @param session
	 */
	public void permitCustomer(String session) {
		IncrementCustomerPermitRequest request = new IncrementCustomerPermitRequest();
		taobaoClient.execute(request, session);
	}
	
	/**
	 * 获取在某时段丢失了的主动通知消息（用户、时间段、类型）
	 * 
	 * @param start 开始时间
	 * @param end 结束时间 (start与end之间的时间间隔不能超过1个小时)
	 * @return
	 */
	public List<DiscardInfo> getDiscardInfos(Date start, Date end) {
		CometDiscardinfoGetRequest request = new CometDiscardinfoGetRequest();
		request.setStart(start);
		request.setEnd(end);
		CometDiscardinfoGetResponse response = taobaoClient.execute(request);
		return response.getDiscardInfoList();
	}
	
	public PagingResult<NotifyTrade> getIncrementTrades(String nick, Date startModified, Date endModified, Long pageNo) {
		Long pageSize = 50L;
		
		IncrementTradesGetRequest request = new IncrementTradesGetRequest();
		request.setNick(nick);
		request.setStartModified(startModified);
		request.setEndModified(endModified);
		request.setPageNo(pageNo);
		request.setPageSize(pageSize);
		IncrementTradesGetResponse response = taobaoClient.execute(request);
		
		List<NotifyTrade> data = response.getNotifyTrades();
		long total = response.getTotalResults();

		return new PagingResult<NotifyTrade>(data, pageSize, pageNo, total);
	}
}

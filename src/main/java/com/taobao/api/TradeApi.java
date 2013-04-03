package com.taobao.api;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.FastDateFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.taobao.api.domain.Trade;
import com.taobao.api.request.TradeFullinfoGetRequest;
import com.taobao.api.request.TradeMemoUpdateRequest;
import com.taobao.api.request.TradesSoldIncrementGetRequest;
import com.taobao.api.response.TradeFullinfoGetResponse;
import com.taobao.api.response.TradesSoldIncrementGetResponse;

/**
 * <a href="http://open.taobao.com/doc/api_cat_detail.htm?category_id=102&cat_id=5">交易API</a>的实现
 * @author Simon Leung
 * 
 */
public class TradeApi {
	private static final Logger log = LoggerFactory.getLogger(TradeApi.class);

    private static final String FULL_INFO_FIELDS = "seller_nick,buyer_nick,title,type,created,tid,buyer_flag," +
            "status,payment,adjust_fee,post_fee,total_fee,pay_time,end_time,modified,consign_time," +
            "seller_memo,buyer_message,receiver_name,receiver_state,receiver_city,receiver_district," +
            "receiver_address,receiver_zip,receiver_mobile,receiver_phone,buyer_email,seller_flag," +
            "seller_cod_fee,buyer_cod_fee,cod_status,shipping_type,trade_from,orders";

    private static final String SIMPLE_FIELDS = "tid,modified";

    private static FastDateFormat dateFormat = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss");

	private ImprovedTaobaoClient taobaoClient;

	public TradeApi(ImprovedTaobaoClient taobaoClient) {
		this.taobaoClient = taobaoClient;
	}

	/**
	 * 获取单笔交易的详细信息 <a
	 * href="http://api.taobao.com/apidoc/api.htm?path=cid:5-apiId:54"
	 * >taobao.trade.fullinfo.get</a>
	 * @param tid trade id
	 * @return trade
	 */
	public Trade getTradeFullInfo(Long tid, String session) {
        log.debug("get trade[{}] full info", tid);
		TradeFullinfoGetRequest request = new TradeFullinfoGetRequest();
		request.setFields(FULL_INFO_FIELDS);
		request.setTid(tid);
		TradeFullinfoGetResponse response = taobaoClient.execute(request, session);
		return response.getTrade();
	}

	/**
	 * 搜索当前会话用户作为卖家已卖出的增量交易数据(仅包含tid及modified数据)
     * <ahref="http://api.taobao.com/apidoc/api.htm?path=cid:5-apiId:128">taobao.trades.sold.increment.get</a>
	 * 
	 * @param startModified
	 * @param endModified
	 * @param pageNo
	 * @param session
	 * @return 分页结果
	 */
	public PagingResult<Trade> getIncrementSoldTrades(final Date startModified, final Date endModified,
			final long pageNo, final String session) {
		TradesSoldIncrementGetRequest request = new TradesSoldIncrementGetRequest();
		request.setFields(SIMPLE_FIELDS);
		request.setStartModified(startModified);
		request.setEndModified(endModified);
		request.setPageNo(pageNo);
		request.setPageSize(50L);
		request.setUseHasNext(true);

		TradesSoldIncrementGetResponse response = taobaoClient.execute(request, session);
		List<Trade> trades = response.getTrades();

        if(log.isDebugEnabled()) {
            int total = (trades == null) ? 0 : trades.size();
            log.debug("get increment sold trades[" + total + "] modified in ["
                    + dateFormat.format(startModified) + "] - [" + dateFormat.format(endModified)
                    + "], pageNo[" + pageNo + "], session[" + session + "]");
        }
		return new PagingResult<Trade>(response.getTrades(), response.getHasNext());
	}

    public void updateMemo(Long tid, Long flag, String memo, String session) {
        if(log.isDebugEnabled()) {
            log.debug("update trade[" + tid + "}] memo to [" + memo + "] and flag to [" + flag + "]");
        }
        TradeMemoUpdateRequest request = new TradeMemoUpdateRequest();
        request.setTid(tid);
        request.setFlag(flag);

        if(StringUtils.isBlank(memo)) {
            request.setReset(true);
        }
        else {
            request.setMemo(memo);
        }

        taobaoClient.execute(request, session);
    }
}

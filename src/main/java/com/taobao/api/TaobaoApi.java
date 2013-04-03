package com.taobao.api;

/**
 * Taobao Open API实现的入口
 * 
 * @author Simon Leung
 *
 */
public class TaobaoApi {
	private ImprovedTaobaoClient taobaoClient;
	
	private StreamApi streamApi; 
	private TradeApi tradeApi;
    private LogisticsApi logisticsApi;
    private VasApi vasApi;
    private SubUserApi subUserApi;
	
	public TaobaoApi(ImprovedTaobaoClient taobaoClient) {
		this.taobaoClient = taobaoClient;
		this.streamApi = new StreamApi(taobaoClient);
		this.tradeApi = new TradeApi(taobaoClient);
        this.logisticsApi = new LogisticsApi(taobaoClient);
        this.vasApi = new VasApi(taobaoClient);
        this.subUserApi = new SubUserApi(taobaoClient);
	}

	public StreamApi getStreamApi() {
		return streamApi;
	}
	
	public TradeApi getTradeApi() {
		return tradeApi;
	}

    public LogisticsApi getLogisticsApi() {
        return logisticsApi;
    }

    public VasApi getVasApi() {
        return vasApi;
    }

    public SubUserApi getSubUserApi() {
        return subUserApi;
    }

    public ImprovedTaobaoClient getTaobaoClient() {
		return taobaoClient;
	}
}

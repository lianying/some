package com.taobao.api;

import com.taobao.api.domain.AddressResult;
import com.taobao.api.domain.LogisticsCompany;
import com.taobao.api.domain.LogisticsPartner;
import com.taobao.api.request.*;
import com.taobao.api.response.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class LogisticsApi {
    private static final Logger log = LoggerFactory.getLogger(LogisticsApi.class);

    private static final String LOGISTICS_COMPANY_FIELDS = "id,code,name,reg_mail_no";

    private ImprovedTaobaoClient taobaoClient;

    public LogisticsApi(ImprovedTaobaoClient taobaoClient) {
        this.taobaoClient = taobaoClient;
    }

    /**
     * 查询淘宝网合作的物流公司信息
     *
     * @return
     */
    public List<LogisticsCompany> getLogisticsCompanies() {
        LogisticsCompaniesGetRequest request = new LogisticsCompaniesGetRequest();
        request.setFields(LOGISTICS_COMPANY_FIELDS);
        LogisticsCompaniesGetResponse response = taobaoClient.execute(request);
        return response.getLogisticsCompanies();
    }

    public List<LogisticsPartner> getLogisticsPartners(String serviceType) {
        LogisticsPartnersGetRequest req = new LogisticsPartnersGetRequest();
        req.setServiceType(serviceType);
        req.setIsNeedCarriage(false);
        LogisticsPartnersGetResponse response = taobaoClient.execute(req);
        return response.getLogisticsPartners();
    }

    public List<AddressResult> searchAddresses(String session) {
        LogisticsAddressSearchRequest request = new LogisticsAddressSearchRequest();
        LogisticsAddressSearchResponse response = taobaoClient.execute(request, session);
        return response.getAddresses();
    }

    /**
     * 自己联系物流（线下物流）发货
     *
     * @param tid                  订单id
     * @param waybillNo            快递单号
     * @param logisticsCompanyCode 物流公司代码
     */
    public void offlineSend(Long tid, String waybillNo, String logisticsCompanyCode, String session) {
        if(log.isDebugEnabled()) {
            log.debug("offline send tid: " + tid + ", waybill no: " + waybillNo + ", logistics company code: " + logisticsCompanyCode);
        }

        LogisticsOfflineSendRequest request = new LogisticsOfflineSendRequest();
        request.setTid(tid);
        request.setOutSid(waybillNo);
        request.setCompanyCode(logisticsCompanyCode);

        LogisticsOfflineSendResponse response = taobaoClient.execute(request, session);
        if(!response.isSuccess()) {
            throw new TaobaoApiException("", "fail to ship order by offline send api : " + tid);
        }
    }

    /**
     * 在线订单发货处理（支持货到付款）
     *
     * @param tid                  订单id
     * @param waybillNo            快递单号
     * @param logisticsCompanyCode 物流公司代码
     */
    public void onlineSend(Long tid, String waybillNo, String logisticsCompanyCode, String session) {
        if(log.isDebugEnabled()) {
            log.debug("online send tid: " + tid + ", waybill no: " + waybillNo + ", logistics company code: " + logisticsCompanyCode);
        }
        LogisticsOnlineSendRequest request = new LogisticsOnlineSendRequest();
        request.setTid(tid);
        request.setOutSid(waybillNo);
        request.setCompanyCode(logisticsCompanyCode);

        LogisticsOnlineSendResponse response = taobaoClient.execute(request, session);
        if(!response.isSuccess()) {
            throw new TaobaoApiException("", "fail to ship order by online send api : " + tid);
        }
    }

    /**
     * 无需物流（虚拟）发货处理
     *
     * @param tid 订单id
     */
    public void dummySend(Long tid, String session) {
        log.debug("dummy send tid: {}", tid);
        LogisticsDummySendRequest request = new LogisticsDummySendRequest();
        request.setTid(tid);
        LogisticsDummySendResponse response = taobaoClient.execute(request, session);
        if(!response.isSuccess()) {
            throw new TaobaoApiException("", "fail to ship order by dummy send api : " + tid);
        }
    }
}

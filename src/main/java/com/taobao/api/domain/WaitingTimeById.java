package com.taobao.api.domain;

import com.taobao.api.TaobaoObject;
import com.taobao.api.internal.mapping.ApiField;

/**
 * 平均等待时长
 *
 * @author auto create
 * @since 1.0, null
 */
public class WaitingTimeById extends TaobaoObject {

	private static final long serialVersionUID = 3568292785769358785L;

	/**
	 * 平均等待时间长度（秒）
	 */
	@ApiField("avg_waiting_times")
	private Long avgWaitingTimes;

	/**
	 * 客服人员ID
	 */
	@ApiField("service_staff_id")
	private String serviceStaffId;

	public Long getAvgWaitingTimes() {
		return this.avgWaitingTimes;
	}
	public void setAvgWaitingTimes(Long avgWaitingTimes) {
		this.avgWaitingTimes = avgWaitingTimes;
	}

	public String getServiceStaffId() {
		return this.serviceStaffId;
	}
	public void setServiceStaffId(String serviceStaffId) {
		this.serviceStaffId = serviceStaffId;
	}

}

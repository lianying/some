package com.thinkgem.jeesite.modules.top.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.Lists;
import com.thinkgem.jeesite.common.persistence.BaseEntity;

/**
 * top用户Entity
 * 
 * @author lay
 * @version 2013-03-22
 */
@Entity
@Table(name = "top_user")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class TopUser extends BaseEntity {

	private static final long serialVersionUID = 1L;

	long taobaoUserId;
	String taobaoUserNick;
	String accessToken;
	String refreshToekn;
	String tokenType;
	long expiresIn;
	long w1ExpiresIn;
	long w2ExpiresIn;
	long r1ExpiresIn;
	long r2ExpiresIn;
	long reExpiresIn;

	private List<Item> itemList = Lists.newArrayList();

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "nick")
	@Fetch(FetchMode.SUBSELECT)
	@NotFound(action = NotFoundAction.IGNORE)
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

	@JsonProperty("taobao_user_id")
	public long getTaobaoUserId() {
		return taobaoUserId;
	}

	@JsonProperty("taobao_user_nick")
	public String getTaobaoUserNick() {
		return taobaoUserNick;
	}

	@JsonProperty("access_token")
	public String getAccessToken() {
		return accessToken;
	}

	@JsonProperty("refresh_token")
	public String getRefreshToekn() {
		return refreshToekn;
	}

	@JsonProperty("token_type")
	public String getTokenType() {
		return tokenType;
	}

	@JsonProperty("expires_in")
	public long getExpiresIn() {
		return expiresIn;
	}

	@JsonProperty("w1_expires_in")
	public long getW1ExpiresIn() {
		return w1ExpiresIn;
	}

	@JsonProperty("w2_expires_in")
	public long getW2ExpiresIn() {
		return w2ExpiresIn;
	}

	@JsonProperty("r1_expires_in")
	public long getR1ExpiresIn() {
		return r1ExpiresIn;
	}

	@JsonProperty("r2_expires_in")
	public long getR2ExpiresIn() {
		return r2ExpiresIn;
	}

	@JsonProperty("re_expires_in")
	public long getReExpiresIn() {
		return reExpiresIn;
	}

	public void setTaobaoUserId(long taobaoUserId) {
		this.taobaoUserId = taobaoUserId;
	}

	public void setTaobaoUserNick(String taobaoUserNick) {
		this.taobaoUserNick = taobaoUserNick;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public void setRefreshToekn(String refreshToekn) {
		this.refreshToekn = refreshToekn;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	public void setExpiresIn(long expiresIn) {
		this.expiresIn = expiresIn;
	}

	public void setW1ExpiresIn(long w1ExpiresIn) {
		this.w1ExpiresIn = w1ExpiresIn;
	}

	public void setW2ExpiresIn(long w2ExpiresIn) {
		this.w2ExpiresIn = w2ExpiresIn;
	}

	public void setR1ExpiresIn(long r1ExpiresIn) {
		this.r1ExpiresIn = r1ExpiresIn;
	}

	public void setR2ExpiresIn(long r2ExpiresIn) {
		this.r2ExpiresIn = r2ExpiresIn;
	}

	public void setReExpiresIn(long reExpiresIn) {
		this.reExpiresIn = reExpiresIn;
	}

}

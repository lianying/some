package com.thinkgem.jeesite.modules.top.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

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
	
	private long taobao_user_id;
	private String taobao_user_nick;
	private String access_token;
	private String refresh_toekn;
	private String token_type;
	private long expires_in;
	private long w1_expires_in;
	private long w2_expires_in;
	private long r1_expires_in;
	private long r2_expires_in;
	private long re_expires_in;
	
	private List<Item> itemList = Lists.newArrayList();

	public long getTaobaoUserId() {
		return taobao_user_id;
	}

	public void setTaobaoUserId(long id) {
		this.taobao_user_id = id;
	}

	@Id
	public String getTaobaoUserNick() {
		return taobao_user_nick;
	}

	public void setTaobaoUserNick(String nick) {
		this.taobao_user_nick = nick;
	}

	public String getAccessToken() {
		return access_token;
	}

	public void setAccessToken(String accessToken) {
		this.access_token = accessToken;
	}

	public String getRefreshToekn() {
		return refresh_toekn;
	}

	public void setRefreshToekn(String refreshToekn) {
		this.refresh_toekn = refreshToekn;
	}

	public String getTokenType() {
		return token_type;
	}

	public void setTokenType(String tokenType) {
		this.token_type = tokenType;
	}

	public long getExpiresIn() {
		return expires_in;
	}

	public void setExpiresIn(long expiresIn) {
		this.expires_in = expiresIn;
	}

	public long getW1ExpiresIn() {
		return w1_expires_in;
	}

	public void setW1ExpiresIn(long w1ExpiresIn) {
		this.w1_expires_in = w1ExpiresIn;
	}

	public long getW2ExpiresIn() {
		return w2_expires_in;
	}

	public void setW2ExpiresIn(long w2ExpiresIn) {
		this.w2_expires_in = w2ExpiresIn;
	}

	public long getR1ExpiresIn() {
		return r1_expires_in;
	}

	public void setR1ExpiresIn(long r1ExpiresIn) {
		this.r1_expires_in = r1ExpiresIn;
	}

	public long getR2ExpiresIn() {
		return r2_expires_in;
	}

	public void setR2ExpiresIn(long r2ExpiresIn) {
		this.r2_expires_in = r2ExpiresIn;
	}

	public long getReExpiresIn() {
		return re_expires_in;
	}

	public void setReExpiresIn(long reExpiresIn) {
		this.re_expires_in = reExpiresIn;
	}

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
	
}

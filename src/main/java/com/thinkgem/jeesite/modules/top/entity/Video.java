package com.thinkgem.jeesite.modules.top.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.taobao.api.internal.mapping.ApiField;
import com.thinkgem.jeesite.common.persistence.BaseEntity;

/**
 * 淘宝商品Entity
 * @author lay
 * @version 2013-03-18
 */
@Entity
@Table(name = "top_video")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Video extends BaseEntity {
	
	private static final long serialVersionUID = 1L;

	/**
	 * 视频关联记录创建时间（格式：yyyy-MM-dd HH:mm:ss）
	 */
	@ApiField("created")
	private Date created;

	/**
	 * 视频关联记录的id，和商品相对应
	 */
	@ApiField("id")
	private Long id;

	/**
	 * 视频记录关联的商品的数字id(注意：iid近期即将废弃，请用num_iid参数)
	 */
	@ApiField("iid")
	private String iid;

	/**
	 * 视频关联记录修改时间（格式：yyyy-MM-dd HH:mm:ss）
	 */
	@ApiField("modified")
	private Date modified;

	/**
	 * 视频记录所关联的商品的数字id
	 */
	@ApiField("num_iid")
	private Long numIid;

	/**
	 * video的url连接地址。淘秀里视频记录里面存储的url地址
	 */
	@ApiField("url")
	private String url;

	/**
	 * video的id，对应于视频在淘秀的存储记录
	 */
	@Id
	@ApiField("video_id")
	private Long videoId;

	public Date getCreated() {
		return this.created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}

	@Id
	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getIid() {
		return this.iid;
	}
	public void setIid(String iid) {
		this.iid = iid;
	}

	public Date getModified() {
		return this.modified;
	}
	public void setModified(Date modified) {
		this.modified = modified;
	}

	@Column(name = "num_iid")
	public Long getNumIid() {
		return this.numIid;
	}
	public void setNumIid(Long numIid) {
		this.numIid = numIid;
	}

	public String getUrl() {
		return this.url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	public Long getVideoId() {
		return this.videoId;
	}
	public void setVideoId(Long videoId) {
		this.videoId = videoId;
	}

}



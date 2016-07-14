package org.zyd.store.base.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 
 * @author GeJianKui
 */
public abstract class BaseEntity implements Serializable {
	private static final long serialVersionUID = -2532937037070373808L;

	private Timestamp createTime;
	private Timestamp updateTime;

	public Timestamp getCreateTime() {
		return createTime == null ? null : (Timestamp) createTime.clone();
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = (null == createTime ? null : (Timestamp) createTime.clone());
	}

	public Timestamp getUpdateTime() {
		return updateTime == null ? null : (Timestamp) updateTime.clone();
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = (null == updateTime ? null : (Timestamp) updateTime.clone());
	}

}

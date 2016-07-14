package org.zyd.service.dto;

import org.zyd.common.constants.Category;

public class PropertyConfigDto implements java.io.Serializable{
	private static final long serialVersionUID = -5723169757428709466L;
	
	private Category category;
	private String propName;
	private Integer seq;

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getPropName() {
		return propName;
	}

	public void setPropName(String propName) {
		this.propName = propName;
	}

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

}

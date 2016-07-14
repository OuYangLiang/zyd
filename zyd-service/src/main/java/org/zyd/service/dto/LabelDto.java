package org.zyd.service.dto;

import java.math.BigDecimal;

import org.zyd.common.constants.LabelStyle;

public class LabelDto implements java.io.Serializable{
	private static final long serialVersionUID = -5974149829045439379L;
	
	private BigDecimal labelId;
	private LabelStyle labelStyle;
	private String labelVal;

	public BigDecimal getLabelId() {
		return labelId;
	}

	public void setLabelId(BigDecimal labelId) {
		this.labelId = labelId;
	}

	public LabelStyle getLabelStyle() {
		return labelStyle;
	}

	public void setLabelStyle(LabelStyle labelStyle) {
		this.labelStyle = labelStyle;
	}

	public String getLabelVal() {
		return labelVal;
	}

	public void setLabelVal(String labelVal) {
		this.labelVal = labelVal;
	}
}

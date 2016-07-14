package org.zyd.service.dto;

import java.math.BigDecimal;

public class EvaluationImageDto implements java.io.Serializable{
	private static final long serialVersionUID = -2345244935205628105L;
	
	private BigDecimal imageId;
    private BigDecimal evalId;
    private Integer imageSeq;
    private String imageAddrs;

    public BigDecimal getImageId() {
        return this.imageId;
    }

    public BigDecimal getEvalId() {
        return this.evalId;
    }

    public Integer getImageSeq() {
        return this.imageSeq;
    }

    public String getImageAddrs() {
        return this.imageAddrs;
    }

    public void setImageId(BigDecimal imageId) {
        this.imageId = imageId;
    }

    public void setEvalId(BigDecimal evalId) {
        this.evalId = evalId;
    }

    public void setImageSeq(Integer imageSeq) {
        this.imageSeq = imageSeq;
    }

    public void setImageAddrs(String imageAddrs) {
        this.imageAddrs = imageAddrs == null ? null : imageAddrs.trim();
    }

}
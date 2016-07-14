package org.zyd.service.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.zyd.common.constants.Level;
import org.zyd.common.constants.LevelChangeType;

public class PartyLevelDto implements java.io.Serializable{
	private static final long serialVersionUID = 983753139182001974L;
	
	private BigDecimal partyId;
    private Level level;
    private LevelChangeType levelChgType;
    private Timestamp levelChgTs;

    public BigDecimal getPartyId() {
        return this.partyId;
    }

    public Level getLevel() {
        return this.level;
    }

    public LevelChangeType getLevelChgType() {
        return this.levelChgType;
    }

    public Timestamp getLevelChgTs() {
        return this.levelChgTs;
    }

    public void setPartyId(BigDecimal partyId) {
        this.partyId = partyId;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public void setLevelChgType(LevelChangeType levelChgType) {
        this.levelChgType = levelChgType;
    }

    public void setLevelChgTs(Timestamp levelChgTs) {
        this.levelChgTs = levelChgTs == null ? null : (Timestamp) levelChgTs.clone();
    }

}
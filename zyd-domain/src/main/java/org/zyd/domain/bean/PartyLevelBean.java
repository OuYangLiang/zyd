package org.zyd.domain.bean;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.zyd.common.constants.Level;
import org.zyd.common.constants.LevelChangeType;
import org.zyd.domain.bean.operation.BaseOperation;
import org.zyd.domain.bean.operation.RemoveOperation;

public interface PartyLevelBean extends BaseOperation, RemoveOperation {

    BigDecimal getPartyId();

    Level getLevel();

    LevelChangeType getLevelChgType();

    Timestamp getLevelChgTs();

    void setPartyId(BigDecimal partyId);

    void setLevel(Level level);

    void setLevelChgType(LevelChangeType levelChgType);

    void setLevelChgTs(Timestamp levelChgTs);

}

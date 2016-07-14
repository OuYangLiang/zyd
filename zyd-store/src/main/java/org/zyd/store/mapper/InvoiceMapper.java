package org.zyd.store.mapper;

import org.zyd.store.base.mapper.DBActionMapper;
import org.zyd.store.base.mapper.PaginatingMapper;
import org.zyd.store.entity.InvoiceEntity;
import org.zyd.store.term.InvoiceTerm;

/**
 * 
 * InvoiceMapper
 * 
 * @author GeJianKui
 * 
 */
public interface InvoiceMapper extends DBActionMapper<InvoiceEntity, InvoiceTerm>,
        PaginatingMapper<InvoiceEntity, InvoiceTerm> {

}

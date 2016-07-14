package org.zyd.webadmin.util;

import java.math.BigDecimal;

import com.caucho.hessian.io.Deserializer;
import com.caucho.hessian.io.HessianProtocolException;
import com.caucho.hessian.io.Serializer;

public class SerializerFactory extends com.caucho.hessian.io.SerializerFactory {
	
	private BigDecimalSerializer bigDecimalSerializer = new BigDecimalSerializer();
	private BigDecimalDeserializer bigDecimalDeserializer = new BigDecimalDeserializer();

	@Override
	public Deserializer getDeserializer(Class cl)
			throws HessianProtocolException {
	    if (BigDecimal.class.isAssignableFrom(cl)) {
	        return bigDecimalDeserializer;
	    }
	    return super.getDeserializer(cl);
	}

	@Override
	public Serializer getSerializer(Class cl) throws HessianProtocolException {
		if (BigDecimal.class.isAssignableFrom(cl)) {
	        return bigDecimalSerializer;
	    }
	    return super.getSerializer(cl);
	}

}

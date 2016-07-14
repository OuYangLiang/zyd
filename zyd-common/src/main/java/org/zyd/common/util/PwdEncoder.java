package org.zyd.common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PwdEncoder {
	
	public static void main(String[] args) throws NoSuchAlgorithmException{ 
		System.out.println(encodePassword("password123"));
	}

    public static String encodePassword(String data) throws NoSuchAlgorithmException {
        return encodePassword(data, "SHA-512");
    }
    
    public static String encodePassword(String data, String algorithm) throws NoSuchAlgorithmException {
        if (null == data) {
            return null;
        }
        MessageDigest md = MessageDigest.getInstance(algorithm);

        md.reset();
        md.update(data.getBytes());

        byte[] rlt = md.digest();

        StringBuffer buf = new StringBuffer();

        for (int i = 0; i < rlt.length; i++) {
            if ((rlt[i] & 0xff) < 0x10) {
                buf.append("0");
            }

            buf.append(Integer.toHexString(rlt[i] & 0xff));
        }

        return buf.toString();
    }

}
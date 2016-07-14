package org.zyd.common.util;

import java.util.regex.Pattern;

public class Validator {

    /**
     * 手机
     */
    public static final String MOBILE_REGEX = "^1[3-9]\\d{9}$";
    /**
     * 密码
     * <p/>
     * 以字母开头，长度在6~18之间，只能包含字符、数字和下划线
     */
    public static final String PASSWORD_REGEX = "^[a-zA-Z]\\w{5,17}$";
    /**
     * 姓名
     * <p/>
     * 汉字，长度在2~5
     */
    public static final String PARTY_NAME_REGEX = "^[\u4e00-\u9fa5]{2,5}$";
    /**
     * 用户昵称
     * <p/>
     * 以字母开头，长度在6~18之间，只能包含字符、数字和下划线
     */
    public static final String PARTY_ALIAS_REGEX = "^[a-zA-Z]\\w{5,17}$";
    /**
     * 邮政编码
     * <p/>
     * 1~9开头，6位数字
     */
    public static final String POST_CODE_REGEX = "[1-9]\\d{5}(?!\\d)";

    /**
     * 
     * 功能描述: 手机号校验
     * 
     * @param mobile
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isMobile(String mobile) {
        return Pattern.matches(MOBILE_REGEX, mobile);
    }

    /**
     * 
     * 功能描述: 姓名校验
     * 
     * @param partyName
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isPartyName(String partyName) {
        return Pattern.matches(PARTY_NAME_REGEX, partyName);
    }

    /**
     * 
     * 功能描述: 昵称校验
     * 
     * @param partyAlias
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isPartyAlias(String partyAlias) {
        return Pattern.matches(PARTY_ALIAS_REGEX, partyAlias);
    }

    /**
     * 
     * 功能描述: 邮编校验
     * 
     * @param postCode
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isPostCode(String postCode) {
        return Pattern.matches(POST_CODE_REGEX, postCode);
    }

    /**
     * 
     * 功能描述: 密码校验
     * 
     * @param password
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isPassword(String password) {
        return Pattern.matches(PASSWORD_REGEX, password);
    }

    public static void main(String[] args) {
        System.out.println(Validator.isPostCode("99999"));
    }

}

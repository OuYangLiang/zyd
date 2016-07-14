package org.zyd.common.util;

/**
 * 
 * 密码盐值生成器
 * 
 */
public class SaltGenerator {

    /**
     * 
     * 功能描述:随机获取两位正整数作为密码盐值
     * 
     * @return
     */
    public static int generateSalt() {
        int salt = (int) Math.round(Math.random() * 90 + 10);
        return salt;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(SaltGenerator.generateSalt());
        }
    }

}

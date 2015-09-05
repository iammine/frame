package com.gzy.frame.common.util;

import java.util.UUID;

/**
 * 生成uuid
 * @author Administrator
 *
 */
public class MakeUUID {

    /**
     * 返回生成的uuid
     * @return
     */
    public static String getUUID() {
        // 去掉“-”符号
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 获得指定数目的UUID
     * @param number
     * @return
     */
    public static String[] getUUID(int number) {
        if (number < 1) {
            return null;
        }
        String[] ss = new String[number];
        for (int i = 0; i < number; i++) {
            ss[i] = getUUID();
        }
        return ss;
    }

}

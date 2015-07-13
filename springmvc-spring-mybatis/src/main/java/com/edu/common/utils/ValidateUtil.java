package com.edu.common.utils;

import java.util.Collection;

/**
 * 数据检查类
 * Created by lc on 2015/6/4.
 */
public class ValidateUtil {
    /**
     * 判断字符串有效性
     */
    public static boolean isValid(String src) {
        if (src == null || "".equals(src.trim())) {
            return false;
        }
        return true;
    }

    /**
     * 判断集合的有效性
     */
    @SuppressWarnings("rawtypes")
    public static boolean isValid(Collection col) {
        if (col == null || col.isEmpty()) {
            return false;
        }
        return true;
    }

    /**
     * 判断数组是否有效
     */
    public static boolean isValid(Object[] arr) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        return true;
    }
}

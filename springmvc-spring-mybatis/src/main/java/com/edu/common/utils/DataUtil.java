package com.edu.common.utils;

import com.edu.common.bean.BaseEntity;

import java.io.*;
import java.security.MessageDigest;
import java.util.Set;

/**
 * 数据处理帮助类
 * Created by lc on 2015/6/4.
 */
public class DataUtil {
    /**
     * 使用md5算法进行加密
     */
    public static String md5(String src) {
        try {
            StringBuffer buffer = new StringBuffer();
            char[] chars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
            byte[] bytes = src.getBytes();
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] targ = md.digest(bytes);
            for (byte b : targ) {
                buffer.append(chars[(b >> 4) & 0x0F]);
                buffer.append(chars[b & 0x0F]);
            }
            return buffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 深度复制,复制的整个对象图
     */
    public static Serializable deeplyCopy(Serializable src) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(src);
            oos.close();
            baos.close();

            byte[] bytes = baos.toByteArray();
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bais);
            Serializable copy = (Serializable) ois.readObject();
            ois.close();
            bais.close();
            return copy;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 抽取实体的id,形成字符串
     */
    public static String extractRightIds(Set<? extends BaseEntity> entites) {
        String temp = "";
        if (ValidateUtil.isValid(entites)) {
            for (BaseEntity e : entites) {
                temp = temp + e.getID() + ",";
            }
            return temp.substring(0, temp.length() - 1);
        }
        return temp;
    }

    /**
     * 根据下标获取大写字母
     * @param index
     * @return
     */
    public static String getStringABC(int index){
        String[] strArr = {"A","B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q",
                "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        if(index > strArr.length){
            return "";
        }
        return strArr[index];
    }
}

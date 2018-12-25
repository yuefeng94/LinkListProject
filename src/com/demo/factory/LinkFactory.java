package com.demo.factory;

/**
 * @Author: demo
 * @Date: 2018/12/25
 * @Description: com.demo.factory
 * @Version: 1.0
 */
public class LinkFactory {

    public static <T> T getInstance(Class<T> tClass) {
        if (tClass == null) {
            throw new  NullPointerException(tClass + " is null");
        }
        try {
            return (T)tClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}

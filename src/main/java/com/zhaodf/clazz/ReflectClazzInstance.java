package com.zhaodf.clazz;

import static java.lang.Class.forName;

/**
 * 类：ReflectDemo
 *
 * @author zhaodf
 * @date 2020/6/9
 */
public class ReflectClazzInstance {
    //通过反射获取类实例
    public static Object reflectInstance(String className){
        try {
            Class<?> clazz = Class.forName(className);
            return clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

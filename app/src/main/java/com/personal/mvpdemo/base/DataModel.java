package com.personal.mvpdemo.base;

/**
 * 数据请求的统一入口，负责事件的分发
 */
public class DataModel {

    public static BaseModel request(Class clazz) {

        // 声明一个空的BaseModel
        BaseModel model = null;

        try {  // 判断class对象是不是BaseModel的实例
            if (clazz.newInstance() instanceof BaseModel) {
                //利用反射机制获得对应Model对象的引用
                model = (BaseModel) clazz.newInstance();
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return model;
    }
}
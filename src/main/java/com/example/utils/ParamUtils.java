package com.example.utils;

import lombok.SneakyThrows;

import java.lang.reflect.Field;

public final class ParamUtils {
    @SneakyThrows
    public static boolean hasNullProperty(Object obj) {
        Class stuCla = obj.getClass();
        Field[] fs = stuCla.getDeclaredFields();
        boolean flag = false;
        for (Field f : fs) {
            f.setAccessible(true);
            Object val = f.get(obj);
            if(val == null) {
                flag = true;
                break;
            }
        }
        return flag;
    }
}

package com.fs.general.common.utils;

import java.lang.reflect.Field;
/**
 * 反射帮助类
 * @author fangli
 *
 */
public class ReflectHelper {
    /**
     * 获取对象的Field相应属性的值
     * @param object 对象
     * @param filename 属性名
     * @return 属性值
     * @throws Throwable
     */
    public static Object getFiledValue(Object object,String filename) throws Throwable{
        
        Field[] fields = object.getClass().getDeclaredFields();
        Field[] fieldsuper = object.getClass().getSuperclass().getDeclaredFields();
        
        Field.setAccessible(fields, true);
        Field.setAccessible(fieldsuper, true);
        for(Field field : fields){
            if(field.getName().equals(filename)){
                return field.get(object);
            }
        }
        
        for(Field field : fieldsuper){
            if(field.getName().equals(filename)){
                return field.get(object);
            }
        }
        return null;
    }
}

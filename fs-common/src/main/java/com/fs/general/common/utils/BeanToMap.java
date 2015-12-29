package com.fs.general.common.utils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * JavaBean工具类
 * 
 * @author guojun
 *
 */
public class BeanToMap {
	/**
	 * 将一个 JavaBean 对象转化为一个 Map
	 * 
	 * @param bean
	 *            要转化的JavaBean 对象
	 * @return 转化出来的 Map 对象
	 * @throws IntrospectionException
	 *             如果分析类属性失败
	 * @throws IllegalAccessException
	 *             如果实例化 JavaBean 失败
	 * @throws InvocationTargetException
	 *             如果调用属性的 setter 方法失败
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map<String, Object> convertBean(Object bean) throws IntrospectionException, IllegalAccessException,
			InvocationTargetException {
		Class type = bean.getClass();
		Map returnMap = new HashMap();
		BeanInfo beanInfo = Introspector.getBeanInfo(type);
		PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
		for (int i = 0; i < propertyDescriptors.length; i++) {
			PropertyDescriptor descriptor = propertyDescriptors[i];
			String propertyName = descriptor.getName();
			if (!propertyName.equals("class")) {
				Method readMethod = descriptor.getReadMethod();
				Object result = readMethod.invoke(bean, new Object[0]);
				if (result != null) {
					returnMap.put(propertyName, result);
				} else {
					returnMap.put(propertyName, "");
				}
			}
		}
		return returnMap;
	}

	/**
	 * 将一个 List<JavaBean> 对象转化为一个List<Map>
	 * 
	 * @param <T>
	 * 
	 * @param list
	 * @return 要转化的List<JavaBean>
	 * @throws IntrospectionException
	 *             如果分析类属性失败
	 * @throws IllegalAccessException
	 *             如果实例化 JavaBean 失败
	 * @throws InvocationTargetException
	 *             如果调用属性的 setter 方法失败
	 */
	public static <T> List<Map<String, Object>> convertListBean(List<T> list) throws IntrospectionException, IllegalAccessException,
			InvocationTargetException {
		List<Map<String, Object>> returnListMap = null;
		if (!list.isEmpty()) {
			returnListMap = new ArrayList<Map<String, Object>>();
			for (int i = 0; i < list.size(); i++) {
				Map<String, Object> map = convertBean(list.get(i));
				returnListMap.add(map);
			}
		}
		return returnListMap;
	}
}

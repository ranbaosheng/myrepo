package com.fs.general.common.utils;

import freemarker.template.SimpleScalar;
import freemarker.template.TemplateModelException;
import freemarker.template.TemplateNumberModel;

/**
 * Freemarker工具类
 * 
 * @author caizhiqin
 * 
 */
public class FreemarkerUtils {
	/**
	 * 
	 * @param paramValue
	 * @return 取得int类型参数
	 * @throws TemplateModelException
	 */
	public static int getIntegerParam(Object paramValue)
			throws TemplateModelException {
		int integerParam = 0;
		if (paramValue instanceof TemplateNumberModel) {
			integerParam = ((TemplateNumberModel) paramValue).getAsNumber()
					.intValue();
		}
		return integerParam;
	}

	/**
	 * 
	 * @param paramValue
	 * @return 取得long类型参数
	 * @throws TemplateModelException
	 */
	public static long getLongParam(Object paramValue)
			throws TemplateModelException {
		long longParam = 0;
		if (paramValue instanceof TemplateNumberModel) {
			longParam = ((TemplateNumberModel) paramValue).getAsNumber()
					.longValue();
		}
		return longParam;
	}

	/**
	 * 
	 * @param paramValue
	 * @return 取得字符串类型参数
	 * @throws TemplateModelException
	 */
	public static String getStringParam(Object paramValue)
			throws TemplateModelException {
		if (paramValue instanceof SimpleScalar) {
			String stringParam = ((SimpleScalar) paramValue).getAsString();
			return stringParam;
		}else 
			return null;
	}
}

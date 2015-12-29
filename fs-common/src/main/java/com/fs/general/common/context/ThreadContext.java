package com.fs.general.common.context;

import java.util.HashMap;

/**
 * 局部线程变量
 * 用来保存线程中的临时数据，非常有用
 * @author echo
 *
 */
public class ThreadContext
{
	public static String REQUEST = "request";
	public static String RESPONSE = "response";
	
	private static class ThreadContextImp extends  ThreadLocal<Object>
	{
		protected synchronized Object initialValue()
		{
			return( new HashMap<Object, Object>() );
		}
	}
	
	private static ThreadContextImp tci = new ThreadContextImp();
	
	public static void put(Object key,Object val)
	{
		((HashMap)tci.get()).put(key,val);
	}
	
	public static Object get(String key)
	{
		return( ((HashMap)tci.get()).get(key));
	}
	
	public static HashMap getMap()
	{
		return((HashMap)tci.get());
	}
	
	public static void remove(String key)
	{
		((HashMap)tci.get()).remove(key);
	}
	
	public static boolean containsKey(String key)
	{
		return (  ((HashMap)tci.get()).containsKey(key)  );
	}

}

package com.fs.general.common.context;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;



/**
 * 平台上下文环境
 * @author ECHO
 *
 */
@Component
public class GlobalContext {
	private static final Logger logger = LoggerFactory.getLogger(GlobalContext.class);
	
	private static ExecutorService executorService;
	
	public GlobalContext()
	{
		executorService = Executors.newFixedThreadPool(50);//初始化线程池
		logger.info("50个线程初始化完成");
	}
	
	public static ExecutorService getExecutorService() {
		return executorService;
	}
	
	/**
	 * 获得前台html结尾的路径
	 * @return
	 */
	public static String getRequestURI()
	{
		HttpServletRequest request = (HttpServletRequest)ThreadContext.get(ThreadContext.REQUEST);

		if (request==null)
		{
			return "";
		}
		
		String paras = request.getQueryString();
		if ( paras==null )
		{
			return(request.getRequestURI());
		}
		else
		{
			return(request.getRequestURI() + "?" + paras);
		}
	}
	
	
	
}

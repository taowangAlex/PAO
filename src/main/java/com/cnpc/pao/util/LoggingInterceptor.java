package com.cnpc.pao.util;

import java.io.Serializable;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

import org.jboss.solder.logging.Logger;

public class LoggingInterceptor implements Serializable {

	private static final long serialVersionUID = 1L;
	Logger logger = Logger.getLogger(LoggingInterceptor.class);

	public LoggingInterceptor() {
	}

	@AroundInvoke
	public Object log(InvocationContext ctx) throws Exception {
		long start = System.currentTimeMillis();
		String tempClass = ctx.getTarget().getClass().getName();
		String tempMethod = ctx.getMethod().getName();
		try {

			logger.info("+++++ 类：方法 || " + tempClass + ":" + tempMethod
					+ "方法开始执行！+++++");
			Object[] params = ctx.getParameters();
			if (params != null) {
				int i = 1;
				for (Object object : params) {
					logger.info("----参数" + i + "值为" + object.toString()
							+ "----");
					i++;
				}
			}
			Object object = ctx.proceed();

			logger.info("+++++ 类：方法 || " + tempClass + ":" + tempMethod
					+ "方法执行结束！+++++");

			return object;

		} catch (Exception e) {
			throw e;
		} finally {
			long time = System.currentTimeMillis() - start;
			logger.info("+++++ 类：方法 || " + tempClass + ":" + tempMethod
					+ "方法耗时:" + time + "ms");
		}

	}
}

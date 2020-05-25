package com.jsite.core.log;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * 日志管理类
 * 
 */
public final class LogAppend {

	/**
	 * 日志对象
	 */
	private static LogAppend logAppend;

	private LogAppend() {
	}

	/**
	 * 获取日志管理对象。
	 * 
	 * @return
	 */
	public static LogAppend getInstance() {
		if (null == logAppend) {
			logAppend = new LogAppend();
		}
		return logAppend;
	}

	/**
	 * 输出提示级别的日志。
	 * 
	 * @param className
	 * @param str
	 */
	public void infoLog(Class<?> className, String str) {
		Logger logger = LogManager.getLogger(className);
		logger.info(str);
	}

	/**
	 * 输出错误级别日志信息
	 * 
	 * @param className
	 * @param e
	 */
	public void errorLog(Class<?> className, Throwable e) {
		Logger logger = LogManager.getLogger(className);
		logger.error(e.getMessage(), e);
	}

	/**
	 * 输出调式级别日志信息
	 * 
	 * @param className
	 * @param str
	 */
	public void debugLog(Class<?> className, String str) {
		Logger logger = LogManager.getLogger(className);
		logger.debug(str);
	}
}

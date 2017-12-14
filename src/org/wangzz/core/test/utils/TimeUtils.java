package org.wangzz.core.test.utils;

import java.util.Stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 时间相关的测试Utils函数.
 */
public class TimeUtils {

	private static Logger logger = LoggerFactory.getLogger(TimeUtils.class);

	private static Stack<Long> times = new Stack<Long>();

	/**
	 * 开始统计时间.
	 */
	public static void begin() {
		times.add(System.currentTimeMillis());
	}

	/**
	 * 结束统计时间 并输出结果.
	 */
	public static void end(String title) {
		String message = title + " : " + (System.currentTimeMillis() - times.pop());
		logger.info(message);
	}

	/**
	 * sleep等待,单位毫秒.
	 */
	public static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {//NOSONAR
		}
	}
}

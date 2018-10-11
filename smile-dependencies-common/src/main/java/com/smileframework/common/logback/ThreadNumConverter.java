package com.smileframework.common.logback;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

/**
 * 
 * @author chenjian
 * @since 2017年3月3日 下午1:49:07
 */
public class ThreadNumConverter extends ClassicConverter {
	/**
	 * 当需要显示线程ID的时候，返回当前调用线程的ID
	 */
	@Override
	public String convert(ILoggingEvent event) {
		return "T=" + String.valueOf(Thread.currentThread().getId());
	}
}
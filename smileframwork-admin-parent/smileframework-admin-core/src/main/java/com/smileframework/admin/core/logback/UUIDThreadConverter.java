package com.smileframework.admin.core.logback;

import java.util.UUID;

import org.apache.log4j.MDC;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

/**
 * 
 * @author chenjian
 * @since 2017年3月3日 下午1:49:07
 */
public class UUIDThreadConverter extends ClassicConverter {
	/**
	 * 当需要显示线程ID的时候，返回当前调用线程的ID
	 */
	@Override
	public String convert(ILoggingEvent event) {
		if (MDC.get("MDC-SMILE") != null) {
			return MDC.get("MDC-SMILE").toString();
		} else {
			MDC.put("MDC-SMILE", "T=" + UUID.randomUUID().toString().replace("-", ""));
			return MDC.get("MDC-SMILE").toString();
		}
	}
}
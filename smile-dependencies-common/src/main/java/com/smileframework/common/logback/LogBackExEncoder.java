/*
 * Copyright by mobanker and the original author or authors.
 * 
 * This document only allow internal use ,Any of your behaviors using the file
 * not internal will pay legal responsibility.
 *
 * You may learn more information about mobanker from
 *
 *      http://www.mobanker.com/
 *
 */
package com.smileframework.common.logback;

import java.io.IOException;

import ch.qos.logback.classic.PatternLayout;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.spi.ILoggingEvent;

/**
 * 
 * @author chenjian
 * @since 2017年3月3日 下午1:18:56
 */
public class LogBackExEncoder extends PatternLayoutEncoder {
	static {
		PatternLayout.defaultConverterMap.put("T", ThreadNumConverter.class.getName());
		PatternLayout.defaultConverterMap.put("threadNum", ThreadNumConverter.class.getName());
		PatternLayout.defaultConverterMap.put("UUID", UUIDThreadConverter.class.getName());
	}

	@Override
	public void doEncode(ILoggingEvent event) throws IOException {
		super.doEncode(event);
	}
}

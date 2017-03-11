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
package com.smileframework.admin.core.sequence;

import java.net.InetAddress;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

/**
 * 
 * @author chenjian
 * @since 2017年3月11日 下午8:10:53
 */
public class SequenceIdGenerateUtils {

	private static long BEGIN_DATE;
	private static int localMachineAppend;
	private static String stoday;
	static {
		try {
			BEGIN_DATE = DateUtils.parseDate("2017-03-01", "yyyy-MM-dd").getTime();
			Integer.parseInt(InetAddress.getLocalHost().getHostAddress().split("\\.")[3]);

		} catch (Exception e) {

		}
	}

	private static AtomicInteger atomicInteger = new AtomicInteger(0);

	/**
	 * 单机生成序列号
	 *
	 * @author chenjian
	 * @since 2017年3月11日 下午8:52:28
	 * @param businessType
	 * @return
	 * @see
	 */
	public static String generate(String businessType) {
		String time = DateFormatUtils.format(new Date(), "yyyyMMddhhmmssSSS");
		String date = time.substring(0, 7);
		if (!date.equals(stoday)) {
			// 重置序列
			atomicInteger = new AtomicInteger();
			stoday = date;
		}
		StringBuilder binaryStr = new StringBuilder();
		binaryStr.append(businessType);
		binaryStr.append(time);
		binaryStr.append(1);
		binaryStr.append(localMachineAppend);
		binaryStr.append(wrapSequenceMachine());
		return binaryStr.toString();
	}

	/**
	 * 39 bit
	 */
	private static String wrapTimeBinaryStr() {
		long currentTime = System.currentTimeMillis();
		long timeElipse = currentTime - BEGIN_DATE;
		return StringUtils.leftPad(Long.toBinaryString(timeElipse), 39, '0');
	}

	/**
	 * 10 bit
	 */
	private static String wrapMachineBinaryStr(int machineIp) {
		return StringUtils.leftPad(Integer.toBinaryString(machineIp), 10, '0');
	}

	/**
	 * 5 bit
	 */
	private static String wrapBusinessBinaryStr(int businessType) {
		return StringUtils.leftPad(Integer.toBinaryString(businessType), 5, '0');
	}

	/**
	 * 4 bit
	 */
	private static String wrapRoomBinaryStr(int room) {
		return StringUtils.leftPad(Integer.toBinaryString(room), 4, '0');
	}

	/**
	 * 5 bit
	 */
	private static String wrapSequencePeyMachine() {
		if (atomicInteger.get() == Integer.MAX_VALUE) {
			atomicInteger = new AtomicInteger();
		}
		return StringUtils.leftPad(Integer.toBinaryString(atomicInteger.incrementAndGet() % 32), 5, '0');
	}

	private static String wrapSequenceMachine() {
		if (atomicInteger.get() == 9999999) {
			atomicInteger = new AtomicInteger();
		}
		return StringUtils.leftPad(String.valueOf(atomicInteger.incrementAndGet()), 8, '0');
	}

}

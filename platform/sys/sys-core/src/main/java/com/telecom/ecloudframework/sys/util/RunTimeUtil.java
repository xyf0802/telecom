package com.telecom.ecloudframework.sys.util;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 这是个生成唯一id的工具类
 * @author lxy
 */
public class RunTimeUtil {

    private static AtomicInteger index = new AtomicInteger();

    public RunTimeUtil() {
    }

    public static int getPid() {
        String info = getRunTimeInfo();
        int pid = (new Random()).nextInt();
        int index = info.indexOf("@");
        if(index > 0) {
            pid = Integer.parseInt(info.substring(0, index));
        }

        return pid;
    }

    public static String getRunTimeInfo() {
        RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();
        String info = runtime.getName();
        return info;
    }

    public static String getRocketMqUniqeInstanceName() {
        return "pid" + getPid() + "_index" + index.incrementAndGet();
    }

}

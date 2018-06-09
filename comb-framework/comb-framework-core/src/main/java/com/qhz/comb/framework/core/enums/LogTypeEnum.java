package com.qhz.comb.framework.core.enums;

//import com.google.common.collect.Lists;
//import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

/**
 * 日志类型枚举
 *
 * @author jiangting
 * @since 1.0, 2018/4/24
 */
public enum LogTypeEnum {

    /**
     * 操作日志
     */
    OPERATION_LOG("10", "操作日志"),
    /**
     * 登录日志
     */
    LOGIN_LOG("20", "登录日志"),
    /**
     * 异常日志
     */
    EXCEPTION_LOG("30", "异常日志");

    /**
     * 日志类型.
     */
    String type;
    /**
     * 日志名称.
     */
    String name;

    LogTypeEnum(String type, String name) {
        this.type = type;
        this.name = name;
    }

    /**
     * 获取日志类型
     *
     * @return 日志类型
     */
    public String getType() {
        return type;
    }

    /**
     * 获取日志类型名称
     *
     * @return 日志类型名称
     */
    public String getName() {
        return name;
    }

    /**
     * 获取指定日志类型的名称
     *
     * @param type 日志类型
     * @return the 指定日志类型的名称
     */
    public static String getName(String type) {
        for (LogTypeEnum ele : LogTypeEnum.values()) {
            if (type.equals(ele.getType())) {
                return ele.getName();
            }
        }
        return null;
    }

    /**
     * 获取指定日志类型的枚举值
     *
     * @param type 指定日志类型
     * @return the 枚举值
     */
    public static LogTypeEnum getEnum(String type) {
        for (LogTypeEnum ele : LogTypeEnum.values()) {
            if (type.equals(ele.getType())) {
                return ele;
            }
        }
        return LogTypeEnum.OPERATION_LOG;
    }

    /**
     * 获取所有枚举类型值.
     *
     * @return 列表
     */
//    public static List<Map<String, Object>> getList() {
//        List<Map<String, Object>> list = Lists.newArrayList();
//        for (LogTypeEnum ele : LogTypeEnum.values()) {
//            Map<String, Object> map = Maps.newHashMap();
//            map.put("key", ele.getType());
//            map.put("value", ele.getName());
//            list.add(map);
//        }
//        return list;
//    }
}

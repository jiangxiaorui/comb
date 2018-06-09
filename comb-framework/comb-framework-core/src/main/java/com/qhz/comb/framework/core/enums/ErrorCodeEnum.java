package com.qhz.comb.framework.core.enums;

/**
 * 错误代码枚举
 *
 * @author jiangting
 * @since 1.0, 2018/4/24
 */
public enum ErrorCodeEnum {

    /**
     * Gl 99990100 error code enum.
     */
    GL99990100(9999100, "参数异常"),
    /**
     * Gl 99990401 error code enum.
     */
    GL99990401(99990401, "无访问权限"),
    /**
     * Gl 000500 error code enum.
     */
    GL99990500(500, "未知异常"),
    /**
     * Gl 000403 error code enum.
     */
    GL99990403(9999403, "无权访问"),
    /**
     * Gl 000404 error code enum.
     */
    GL9999404(9999404, "找不到指定资源"),
    /**
     * Gl 99990001 error code enum.
     */
    GL99990001(99990001, "注解使用错误"),
    /**
     * Gl 99990002 error code enum.
     */
    GL99990002(99990002, "微服务不在线,或者网络超时");

    private int code;
    private String msg;

    /**
     * 错误信息.
     *
     * @return the string
     */
    public String msg() {
        return msg;
    }

    /**
     * 错误代码.
     *
     * @return the int
     */
    public int code() {
        return code;
    }

    ErrorCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 获取错误枚举
     *
     * @param code the code
     * @return the enum
     */
    public static ErrorCodeEnum getEnum(int code) {
        for (ErrorCodeEnum ele : ErrorCodeEnum.values()) {
            if (ele.code() == code) {
                return ele;
            }
        }
        return null;
    }
}

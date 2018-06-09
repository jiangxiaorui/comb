package com.qhz.comb.framework.core.protocol;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

/**
 * 结果包装类
 *
 * @author jiangting
 * @since 1.0, 2018/4/24
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultWrapper<T> implements Serializable {

    /**
     * 成功码.
     */
    public static final int SUCCESS_CODE = 200;

    /**
     * 成功信息.
     */
    public static final String SUCCESS_MESSAGE = "操作成功";

    /**
     * 错误码.
     */
    public static final int ERROR_CODE = 500;

    /**
     * 错误信息.
     */
    public static final String ERROR_MESSAGE = "内部异常";

    /**
     * 错误码：参数非法
     */
    public static final int ILLEGAL_ARGUMENT_CODE_ = 100;

    /**
     * 错误信息：参数非法
     */
    public static final String ILLEGAL_ARGUMENT_MESSAGE = "参数非法";

    /**
     * 编号.
     */
    private int code;

    /**
     * 信息.
     */
    private String message;

    /**
     * 结果数据
     */
    private T data;

    /**
     * 新建一个ResultWrapper. default code=200
     */
    public ResultWrapper() {
        this(SUCCESS_CODE, SUCCESS_MESSAGE);
    }

    /**
     * 新建一个ResultWrapper
     *
     * @param code    the code
     * @param message the message
     */
    public ResultWrapper(int code, String message) {
        this(code, message, null);
    }

    /**
     * 新建一个ResultWrapper
     *
     * @param code    the code
     * @param message the message
     * @param data    the data
     */
    public ResultWrapper(int code, String message, T data) {
        super();
        this.code(code).message(message).data(data);
    }

    /**
     * 设置编号,返回自身的引用.
     *
     * @param code the new 编号
     * @return the wrapper
     */
    private ResultWrapper<T> code(int code) {
        this.setCode(code);
        return this;
    }

    /**
     * 设置信息 , 返回自身的引用.
     *
     * @param message the new 信息
     * @return the wrapper
     */
    private ResultWrapper<T> message(String message) {
        this.setMessage(message);
        return this;
    }

    /**
     * 设置结果数据 , 返回自身的引用.
     *
     * @param data the new 结果数据
     * @return the wrapper
     */
    public ResultWrapper<T> data(T data) {
        this.setData(data);
        return this;
    }

    /**
     * 判断是否成功： 依据 ResultWrapper.SUCCESS_CODE == this.code
     *
     * @return code =200,true;否则 false.
     */
    @JsonIgnore
    public boolean success() {
        return ResultWrapper.SUCCESS_CODE == this.code;
    }

    /**
     * 判断是否失败： 依据 ResultWrapper.SUCCESS_CODE != this.code
     *
     * @return code !=200,true;否则 false.
     */
    @JsonIgnore
    public boolean failure() {
        return !success();
    }

    /**
     * 构建响应结果
     *
     * @param code
     * @param message
     * @param data
     * @return
     */
    public static ResultWrapper build(int code, String message, Object data) {
        return new ResultWrapper(code, message, data);
    }

    /**
     * 构建响应结果
     *
     * @param code
     * @param message
     * @return
     */
    public static ResultWrapper build(int code, String message) {
        return build(code, message, null);
    }

    /**
     * 构建响应结果
     *
     * @param code
     * @return
     */
    public static ResultWrapper build(int code) {
        return build(code, null);
    }

    /**
     * 构建响应结果
     *
     * @param e
     * @return
     */
    public static ResultWrapper build(Exception e) {
        return new ResultWrapper(ResultWrapper.ERROR_CODE, e.getMessage(), null);
    }

    /**
     * 构建成功响应结果
     *
     * @return
     */
    public static ResultWrapper buildSuccess() {
        return buildSuccess(null);
    }

    /**
     * 构建成功响应结果
     *
     * @param data
     * @return
     */
    public static ResultWrapper buildSuccess(Object data) {
        return buildSuccess(ResultWrapper.SUCCESS_MESSAGE, data);
    }

    /**
     * 构建成功响应结果
     *
     * @param message
     * @param data
     * @return
     */
    public static ResultWrapper buildSuccess(String message, Object data) {
        return build(ResultWrapper.SUCCESS_CODE, message, data);
    }


    /**
     * 构建错误响应结果
     *
     * @param code
     * @param message
     * @param data
     * @return
     */
    public static ResultWrapper buildFailure(int code, String message, Object data) {
        return build(code, message, data);
    }

    /**
     * 构建错误响应结果
     *
     * @return
     */
    public static ResultWrapper buildFailure() {
        return buildFailure(ResultWrapper.ERROR_CODE, ResultWrapper.ERROR_MESSAGE, null);
    }

    /**
     * 构建错误响应结果
     *
     * @param code
     * @param message
     * @return
     */
    public static ResultWrapper buildFailure(int code, String message) {
        return buildFailure(code, message, null);
    }

    /**
     * 构建错误响应结果
     *
     * @param message
     * @return
     */
    public static ResultWrapper buildFailure(String message) {
        return buildFailure(ResultWrapper.ERROR_CODE, message);
    }

    /**
     * 构建错误响应结果
     *
     * @param data
     * @return
     */
    public static ResultWrapper buildFailure(Object data) {
        return buildFailure(ResultWrapper.ERROR_CODE, ResultWrapper.ERROR_MESSAGE, data);
    }

}

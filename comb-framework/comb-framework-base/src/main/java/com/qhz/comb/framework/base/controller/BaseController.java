package com.qhz.comb.framework.base.controller;

import com.qhz.comb.framework.core.protocol.ResultWrapper;

/**
 * 基础控制类
 *
 * @author jiangting
 * @since 1.0, 2018/4/24
 */
public class BaseController {

    public ResultWrapper success() {
        return ResultWrapper.buildSuccess();
    }

    public ResultWrapper success(Object data) {
        return ResultWrapper.buildSuccess(data);
    }
}

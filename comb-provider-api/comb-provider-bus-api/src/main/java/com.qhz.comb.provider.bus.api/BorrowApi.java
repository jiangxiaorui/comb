package com.qhz.comb.provider.bus.api;

import org.springframework.web.bind.annotation.GetMapping;

/**
 * 标接口
 *
 * @author jiangting
 * @since 1.0, 2018/5/14
 */
public interface BorrowApi {

    @GetMapping(value = "/test")
    String test();
}

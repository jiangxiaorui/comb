package com.qhz.comb.auth.controller;

import com.qhz.comb.framework.base.controller.BaseController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiangting
 * @since 1.0, 2018/6/1
 */
@RestController
public class TestController extends BaseController {

    @GetMapping(value = "/test")
    public String test() {
        return "AAA";
    }
}

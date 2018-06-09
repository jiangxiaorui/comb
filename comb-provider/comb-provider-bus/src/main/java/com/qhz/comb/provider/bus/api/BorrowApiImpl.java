package com.qhz.comb.provider.bus.api;

import com.qhz.comb.provider.bus.api.feign.BorrowFeignClient;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiangting
 * @since 1.0, 2018/5/24
 */
@RestController
public class BorrowApiImpl implements BorrowFeignClient{

    @Override
    public String test() {
        return "AAA";
    }
}

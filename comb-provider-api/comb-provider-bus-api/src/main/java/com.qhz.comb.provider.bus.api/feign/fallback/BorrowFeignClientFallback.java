package com.qhz.comb.provider.bus.api.feign.fallback;

import com.qhz.comb.provider.bus.api.feign.BorrowFeignClient;
import org.springframework.stereotype.Component;

/**
 * BorrowFeignClient 熔断
 *
 * @author jiangting
 * @since 1.0, 2018/5/14
 */
@Component
public class BorrowFeignClientFallback implements BorrowFeignClient {

    @Override
    public String test() {
        return "Error";
    }
}

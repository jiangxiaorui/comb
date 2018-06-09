package com.qhz.comb.provider.bus.api.feign;

import com.qhz.comb.provider.bus.api.BorrowApi;
import com.qhz.comb.provider.bus.api.feign.fallback.BorrowFeignClientFallback;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * 标 FeignClient
 *
 * @author jiangting
 * @since 1.0, 2018/5/14
 */
@FeignClient(name = "comb-provider-bus", fallback = BorrowFeignClientFallback.class)
public interface BorrowFeignClient extends BorrowApi {

}

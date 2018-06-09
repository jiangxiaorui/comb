package com.qhz.comb.provider.common.api.feign;

import com.qhz.comb.provider.common.api.SysUserApi;
import com.qhz.comb.provider.common.api.feign.fallback.SysUserFeignClientFallback;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * 系统用户 FeignClient
 *
 * @author jiangting
 * @since 1.0, 2018/5/28
 */
@FeignClient(name = "comb-provider-common", fallback = SysUserFeignClientFallback.class)
public interface SysUserFeignClient extends SysUserApi {
}

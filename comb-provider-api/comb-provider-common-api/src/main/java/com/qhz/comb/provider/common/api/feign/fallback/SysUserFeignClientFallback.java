package com.qhz.comb.provider.common.api.feign.fallback;

import com.qhz.comb.provider.common.api.feign.SysUserFeignClient;
import com.qhz.comb.provider.common.api.vo.SysUserVo;

/**
 * SysUserFeignClient 熔断
 * @author jiangting
 * @since 1.0, 2018/5/28
 */
public class SysUserFeignClientFallback implements SysUserFeignClient{

    @Override
    public SysUserVo findUserByUsername(String username) {
        return null;
    }
}

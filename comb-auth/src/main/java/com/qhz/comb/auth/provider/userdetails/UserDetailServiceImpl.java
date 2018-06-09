package com.qhz.comb.auth.provider.userdetails;

import com.qhz.comb.provider.common.api.feign.SysUserFeignClient;
import com.qhz.comb.provider.common.api.vo.SysUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * UserDetailService 实现
 *
 * @author jiangting
 * @since 1.0, 2018/5/28
 */
@Service("userDetailService")
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private SysUserFeignClient sysUserFeignClient;

    @Override
    public UserDetailsImpl loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUserVo userVo = sysUserFeignClient.findUserByUsername(username);
        return new UserDetailsImpl(userVo);
    }
}

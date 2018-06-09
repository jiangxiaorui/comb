package com.qhz.comb.provider.common.api;

import com.qhz.comb.provider.common.api.vo.SysUserVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author jiangting
 * @since 1.0, 2018/5/28
 */
public interface SysUserApi {

    /**
     * 通过用户名查询用户、角色信息
     *
     * @param username 用户名
     * @return UserVo
     */
    @GetMapping("/user/findUserByUsername/{username}")
    SysUserVo findUserByUsername(@PathVariable("username") String username);
}

package com.qhz.comb.provider.user.controller;

import com.qhz.comb.framework.core.protocol.ResultWrapper;
import com.qhz.comb.provider.bus.api.feign.BorrowFeignClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.qhz.comb.framework.base.controller.BaseController;
import com.qhz.comb.provider.user.model.domain.User;
import com.qhz.comb.provider.user.service.UserService;

import java.util.List;

/**
 * <p>
 * 用户 控制器
 * </p>
 *
 * @author jiangting
 * @since 2018-04-26
 */
@RestController
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(tags = "用户 接口", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @Autowired
    BorrowFeignClient borrowFeignClient;

    /**
     * 获取用户列表
     */
    @GetMapping(value = "/list")
    @ApiOperation("获取用户列表")
    public ResultWrapper<List<User>> list() {
        String m = borrowFeignClient.test();
        return this.success(userService.selectListByColumn("userID", 18));
    }

    /**
     * 新增用户
     */
    @PostMapping(value = "/add")
    @ApiOperation("新增用户")
    public ResultWrapper<String> add(User user) {
        userService.insert(user);
        return this.success();
    }

    /**
     * 删除用户
     */
    @PostMapping(value = "/delete/{id}")
    @ApiOperation("删除用户")
    public ResultWrapper<String> delete(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return this.success();
    }

    /**
     * 修改用户
     */
    @PostMapping(value = "/update")
    @ApiOperation("修改用户")
    public ResultWrapper<String> update(User user) {
        userService.updateById(user);
        return this.success();
    }

    /**
     * 获取用户
     */
    @GetMapping(value = "/get/{id}")
    @ApiOperation("获取用户")
    public ResultWrapper<User> get(@PathVariable("id") Long id) {
        return this.success(userService.selectById(id));
    }
}


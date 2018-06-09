package com.qhz.comb.provider.common.controller;

import com.qhz.comb.framework.core.protocol.ResultWrapper;
import com.qhz.comb.provider.common.model.domain.SysUser;
import com.qhz.comb.provider.common.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.qhz.comb.framework.base.controller.BaseController;

import java.util.List;

/**
 * <p>
 * 用户表 控制器
 * </p>
 *
 * @author jiangting
 * @since 2018-05-28
 */
@RestController
@RequestMapping("/common/sysUser")
@Api(tags = "用户表 接口")
public class SysUserController extends BaseController {

    @Autowired
    private SysUserService sysUserService;

    /**
     * 获取用户表列表
     */
    @GetMapping(value = "/list")
    @ApiOperation("获取用户表列表")
    public ResultWrapper<List<SysUser>> list() {
        return this.success(sysUserService.selectAll());
    }

    /**
     * 新增用户表
     */
    @PostMapping(value = "/add")
    @ApiOperation("新增用户表")
    public ResultWrapper<String> add(SysUser sysUser) {
        sysUserService.insert(sysUser);
        return this.success();
    }

    /**
     * 删除用户表
     */
    @PostMapping(value = "/delete/{id}")
    @ApiOperation("删除用户表")
    public ResultWrapper<String> delete(@PathVariable("id") Long id) {
        sysUserService.deleteById(id);
        return this.success();
    }

    /**
     * 修改用户表
     */
    @PostMapping(value = "/update")
    @ApiOperation("修改用户表")
    public ResultWrapper<String> update(SysUser sysUser) {
        sysUserService.updateById(sysUser);
        return this.success();
    }

    /**
     * 获取用户表
     */
    @GetMapping(value = "/get/{id}")
    @ApiOperation("获取用户表")
    public ResultWrapper<SysUser> get(@PathVariable("id") Long id) {
        return this.success(sysUserService.selectById(id));
    }
}


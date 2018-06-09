package com.qhz.comb.provider.common.controller;

import com.qhz.comb.framework.core.protocol.ResultWrapper;
import com.qhz.comb.provider.common.model.domain.SysRole;
import com.qhz.comb.provider.common.service.SysRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.qhz.comb.framework.base.controller.BaseController;

import java.util.List;

/**
 * <p>
 * 系统用户角色 控制器
 * </p>
 *
 * @author jiangting
 * @since 2018-05-28
 */
@RestController
@RequestMapping("/common/sysRole")
@Api(tags = "系统用户角色 接口")
public class SysRoleController extends BaseController {

    @Autowired
    private SysRoleService sysRoleService;

    /**
     * 获取系统用户角色列表
     */
    @GetMapping(value = "/list")
    @ApiOperation("获取系统用户角色列表")
    public ResultWrapper<List<SysRole>> list() {
        return this.success(sysRoleService.selectAll());
    }

    /**
     * 新增系统用户角色
     */
    @PostMapping(value = "/add")
    @ApiOperation("新增系统用户角色")
    public ResultWrapper<String> add(SysRole sysRole) {
        sysRoleService.insert(sysRole);
        return this.success();
    }

    /**
     * 删除系统用户角色
     */
    @PostMapping(value = "/delete/{id}")
    @ApiOperation("删除系统用户角色")
    public ResultWrapper<String> delete(@PathVariable("id") Long id) {
        sysRoleService.deleteById(id);
        return this.success();
    }

    /**
     * 修改系统用户角色
     */
    @PostMapping(value = "/update")
    @ApiOperation("修改系统用户角色")
    public ResultWrapper<String> update(SysRole sysRole) {
        sysRoleService.updateById(sysRole);
        return this.success();
    }

    /**
     * 获取系统用户角色
     */
    @GetMapping(value = "/get/{id}")
    @ApiOperation("获取系统用户角色")
    public ResultWrapper<SysRole> get(@PathVariable("id") Long id) {
        return this.success(sysRoleService.selectById(id));
    }
}


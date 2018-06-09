package com.qhz.comb.auth.controller;

import com.qhz.comb.auth.model.domain.SysOauthClient;
import com.qhz.comb.auth.service.SysOauthClientService;
import com.qhz.comb.framework.core.protocol.ResultWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.qhz.comb.framework.base.controller.BaseController;

import java.util.List;

/**
 * <p>
 * oauth客户端 控制器
 * </p>
 *
 * @author jiangting
 * @since 2018-05-28
 */
@RestController
@RequestMapping("/auth/sysOauthClient")
@Api(tags = "oauth客户端 接口")
public class SysOauthClientController extends BaseController {

    @Autowired
    private SysOauthClientService sysOauthClientService;

    /**
     * 获取oauth客户端列表
     */
    @GetMapping(value = "/list")
    @ApiOperation("获取oauth客户端列表")
    public ResultWrapper<List<SysOauthClient>> list() {
        return this.success(sysOauthClientService.selectAll());
    }

    /**
     * 新增oauth客户端
     */
    @PostMapping(value = "/add")
    @ApiOperation("新增oauth客户端")
    public ResultWrapper<String> add(SysOauthClient sysOauthClient) {
        sysOauthClientService.insert(sysOauthClient);
        return this.success();
    }

    /**
     * 删除oauth客户端
     */
    @PostMapping(value = "/delete/{id}")
    @ApiOperation("删除oauth客户端")
    public ResultWrapper<String> delete(@PathVariable("id") Long id) {
        sysOauthClientService.deleteById(id);
        return this.success();
    }

    /**
     * 修改oauth客户端
     */
    @PostMapping(value = "/update")
    @ApiOperation("修改oauth客户端")
    public ResultWrapper<String> update(SysOauthClient sysOauthClient) {
        sysOauthClientService.updateById(sysOauthClient);
        return this.success();
    }

    /**
     * 获取oauth客户端
     */
    @GetMapping(value = "/get/{id}")
    @ApiOperation("获取oauth客户端")
    public ResultWrapper<SysOauthClient> get(@PathVariable("id") Long id) {
        return this.success(sysOauthClientService.selectById(id));
    }
}


package com.qhz.comb.provider.bus.controller;

import com.qhz.comb.framework.core.protocol.ResultWrapper;
import com.qhz.comb.provider.bus.model.domain.Borrow;
import com.qhz.comb.provider.bus.service.BorrowService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.qhz.comb.framework.base.controller.BaseController;

import java.util.List;

/**
 * <p>
 * 融资 控制器
 * </p>
 *
 * @author jiangting
 * @since 2018-04-27
 */
@RestController
@RequestMapping("/bus/borrow")
@Api(tags = "融资 接口")
public class BorrowController extends BaseController {

    @Autowired
    private BorrowService borrowService;

    /**
     * 获取融资列表
     */
    @GetMapping(value = "/list")
    @ApiOperation("获取融资列表")
    public ResultWrapper<List<Borrow>> list() {
        return this.success(borrowService.selectListByColumn("borrowID",1));
    }

    /**
     * 新增融资
     */
    @PostMapping(value = "/add")
    @ApiOperation("新增融资")
    public ResultWrapper<String> add(Borrow borrow) {
        borrowService.insert(borrow);
        return this.success();
    }

    /**
     * 删除融资
     */
    @PostMapping(value = "/delete/{id}")
    @ApiOperation("删除融资")
    public ResultWrapper<String> delete(@PathVariable("id") Long id) {
        borrowService.deleteById(id);
        return this.success();
    }

    /**
     * 修改融资
     */
    @PostMapping(value = "/update")
    @ApiOperation("修改融资")
    public ResultWrapper<String> update(Borrow borrow) {
        borrowService.updateById(borrow);
        return this.success();
    }

    /**
     * 获取融资
     */
    @GetMapping(value = "/get/{id}")
    @ApiOperation("获取融资")
    public ResultWrapper<Borrow> get(@PathVariable("id") Long id) {
        return this.success(borrowService.selectById(id));
    }
}


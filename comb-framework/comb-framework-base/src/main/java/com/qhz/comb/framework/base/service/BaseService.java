package com.qhz.comb.framework.base.service;

import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * 数据服务通用接口
 *
 * @author jiangting
 * @since 1.0, 2018/4/24
 */
public interface BaseService<T> extends IService<T> {

    /**
     * 根据列获取唯一对象
     *
     * @param column
     * @param value
     * @return
     */
    T findOneByColumn(String column, String value);

    /**
     * 根据列获取列表
     *
     * @param column
     * @param value
     * @return
     */
    List<T> selectListByColumn(String column, Object value);

    /**
     * 查询全部结果
     *
     * @return
     */
    List<T> selectAll();
}

package com.qhz.comb.devtools.generator.service;

import com.baomidou.mybatisplus.mapper.SqlRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 获取数据库所有表
 *
 * @author jiangting
 * @since 1.0, 2018/4/25
 */
@Service
public class TableService {

    @Value("${spring.datasource.db-name}")
    private String dbName;

    /**
     * 获取当前数据库所有的表信息
     */
    public List<Map<String, Object>> getAllTables() {
        String sql = "select TABLE_NAME as tableName,TABLE_COMMENT as tableComment from information_schema.`TABLES` where TABLE_SCHEMA = '" + dbName + "'";
        return SqlRunner.db().selectList(sql);
    }
}

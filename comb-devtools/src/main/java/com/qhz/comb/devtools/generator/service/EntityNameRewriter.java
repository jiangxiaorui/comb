package com.qhz.comb.devtools.generator.service;

import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.qhz.comb.framework.util.StringUtils;
import lombok.Data;

import java.util.List;

/**
 * @author jiangting
 * @since 1.0, 2018/4/25
 */
@Data
public class EntityNameRewriter extends InjectionConfig {

    private String entityName;

    @Override
    public void initMap() {
        if(StringUtils.isNotEmpty(entityName)){
            List<TableInfo> tableInfoList = this.getConfig().getTableInfoList();
            if(tableInfoList != null){
                tableInfoList.get(0).setComment(entityName);
            }
        }
    }
}

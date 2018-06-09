package com.qhz.comb.devtools.generator.task;

import lombok.Data;

/**
 * @author jiangting
 * @since 1.0, 2018/4/25
 */
@Data
public class GenerateTask {

    private String projectLocation;

    private String tablePrefix;

    private String packageName;

    private String tableName;

    private String entityName;

    private String module;

    private String developer;

    private Boolean onlyGenerateEntity;
}

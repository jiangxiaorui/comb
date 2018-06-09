package com.qhz.comb.framework.base.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体基类
 *
 * @author jiangting
 * @since 1.0, 2018/4/24
 */
@Data
public class BaseEntity implements Serializable {

    /**
     * 版本号
     */
    private Integer version;
    /**
     * 创建人
     */
    private String creator;

    /**
     * 创建人ID
     */
    @TableField(value = "creator_id")
    private Long creatorId;

    /**
     * 创建时间
     */
    @TableField(value = "created_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createdTime;

    /**
     * 最近修改人
     */
    @TableField(value = "last_operator")
    private String modifier;

    /**
     * 最后修改人ID
     */
    @TableField(value = "last_operator_id")
    private Long modifierId;

    /**
     * 最后修改时间
     */
    @TableField(value = "update_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date modifiedTime;
}

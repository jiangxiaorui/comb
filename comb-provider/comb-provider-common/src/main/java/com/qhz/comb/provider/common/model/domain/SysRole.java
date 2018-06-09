package com.qhz.comb.provider.common.model.domain;

import com.baomidou.mybatisplus.annotations.Version;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import com.baomidou.mybatisplus.enums.IdType;

import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * <p>
 * 系统用户角色
 * </p>
 *
 * @author jiangting
 * @since 2018-05-28
 */
@Data
@Accessors(chain = true)
@TableName("d_sys_role")
public class SysRole implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "role_id", type = IdType.AUTO)
    private Integer roleId;

    /**
     * 角色名称
     */
    @TableField("role_name")
    private String roleName;

    /**
     * 角色Code
     */
    @TableField("role_code")
    private String roleCode;

    /**
     * 角色描述
     */
    @TableField("role_desc")
    private String roleDesc;

    /**
     * 创建人ID
     */
    @TableField("creator_id")
    private Integer creatorId;

    /**
     * 创建时间
     */
    @TableField("created_time")
    private Date createdTime;

    /**
     * 最后修改人ID
     */
    @TableField("modifier_id")
    private Integer modifierId;

    /**
     * 最后修改时间
     */
    @TableField("modified_time")
    private Date modifiedTime;

    /**
     * 删除标识（0-正常,1-删除）
     */
    @TableField("del_flag")
    private String delFlag;


}

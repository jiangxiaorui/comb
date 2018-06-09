package com.qhz.comb.provider.common.model.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import com.baomidou.mybatisplus.enums.IdType;

import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * <p>
 * 用户
 * </p>
 *
 * @author jiangting
 * @since 2018-05-28
 */
@Data
@Accessors(chain = true)
@TableName("d_sys_user")
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    /**
     * 用户名
     */
    @TableField("username")
    private String username;

    /**
     * 用户密码
     */
    @TableField("password")
    private String password;

    /**
     * 随机盐
     */
    @TableField("salt")
    private String salt;

    /**
     * 手机号码
     */
    @TableField("phone")
    private String phone;

    /**
     * 头像
     */
    @TableField("avatar")
    private String avatar;

    /**
     * 部门ID
     */
    @TableField("dept_id")
    private Integer deptId;

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
     * 0-正常，1-删除
     */
    @TableField("del_flag")
    private String delFlag;

}

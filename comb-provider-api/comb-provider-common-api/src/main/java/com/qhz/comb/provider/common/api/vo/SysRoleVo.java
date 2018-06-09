package com.qhz.comb.provider.common.api.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 系统角色 VO
 *
 * @author jiangting
 * @since 1.0, 2018/5/28
 */
@Data
public class SysRoleVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色ID
     */
    private Integer roleId;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色Code
     */
    private String roleCode;

    /**
     * 角色描述
     */
    private String roleDesc;

    /**
     * 删除标识（0-正常,1-删除）
     */
    private String delFlag;
}

package com.qhz.comb.provider.common.api.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 系统用户 VO
 *
 * @author jiangting
 * @since 1.0, 2018/5/28
 */
@Data
public class SysUserVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private Integer userId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 随机盐
     */
    private String salt;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 部门ID
     */
    private Integer deptId;

    /**
     * 0-正常，1-删除
     */
    private String delFlag;

    /**
     * 角色列表
     */
    private List<SysRoleVo> roleList;
}

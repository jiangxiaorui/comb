package com.qhz.comb.provider.user.model.domain;

import com.baomidou.mybatisplus.annotations.TableField;
import lombok.Data;
import lombok.experimental.Accessors;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * <p>
 * 用户
 * </p>
 *
 * @author jiangting
 * @since 2018-04-27
 */
@Data
@Accessors(chain = true)
@TableName("d_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 客户ID
     */
    @TableId(value = "userID", type = IdType.AUTO)
    private Integer userID;

    /**
     * 用户编码，或者KEY值
     */
    @TableField("userKey")
    private String userKey;

    /**
     * 用户名
     */
    @TableField("userName")
    private String userName;

    /**
     * 客户昵称
     */
    @TableField("userNickname")
    private String userNickname;

    /**
     * 密码
     */
    @TableField("password")
    private String password;

    /**
     * 客户交易密码
     */
    @TableField("payPassword")
    private String payPassword;

    /**
     * 客户状态 1 正常 0 注销
     */
    @TableField("userStatus")
    private Integer userStatus;

    /**
     * 客户姓名
     */
    @TableField("realName")
    private String realName;

    /**
     * 实名认证状态 0 未认证，1已认证
     */
    @TableField("realStatus")
    private Integer realStatus;

    /**
     * 华兴账号
     */
    @TableField("accNO")
    private String accNO;

    /**
     * 绑卡标示  0 未绑卡,1绑卡
     */
    @TableField("bankStatus")
    private Integer bankStatus;

    /**
     * 性别 0 未知 1 男 2 女
     */
    @TableField("userSex")
    private Integer userSex;

    /**
     * 头像路径
     */
    @TableField("headUrl")
    private String headUrl;

    /**
     * 邮箱
     */
    @TableField("email")
    private String email;

    /**
     * 邮箱认证状态 0 未认证，1已认证
     */
    @TableField("emailStatus")
    private Integer emailStatus;

    /**
     * 状态 0 未认证，1已认证
     */
    @TableField("vipStatus")
    private Integer vipStatus;

    /**
     * VIP等级
     */
    @TableField("viplevel")
    private Integer viplevel;

    /**
     * VIP 时间
     */
    @TableField("vipTime")
    private Integer vipTime;

    /**
     * 电话
     */
    @TableField("phone")
    private String phone;

    /**
     * 电话认证状态 0 未认证，1已认证
     */
    @TableField("phoneStatus")
    private Integer phoneStatus;

    /**
     * 客服的ID
     */
    @TableField("attendantID")
    private Integer attendantID;

    /**
     * 专属客服
     */
    @TableField("attendantUserName")
    private String attendantUserName;

    /**
     * 客户类型 0普通用户 1 潜在客户 5 大客户 15公司员工 20企业融资用户 21担保方 30融资用户 40马甲用户
     */
    @TableField("userType")
    private Integer userType;

    /**
     * 推广渠道ID
     */
    @TableField("clientSource")
    private Integer clientSource;

    /**
     * 注册时间
     */
    @TableField("regDatetime")
    private Integer regDatetime;

    /**
     * 注册终端 1 PC 2 安卓 3 IOS 4 微信
     */
    @TableField("regTerminal")
    private Integer regTerminal;

    /**
     * 注册IP
     */
    @TableField("regIP")
    private String regIP;

    /**
     * 微信编码ID
     */
    @TableField("openID")
    private String openID;

    /**
     * 法大大 客户唯一编号
     */
    @TableField("customerID")
    private String customerID;

    /**
     * 修改时间
     */
    @TableField("editDatetime")
    private Integer editDatetime;
}

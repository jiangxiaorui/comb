package com.qhz.comb.provider.bus.model.domain;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.Version;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import com.baomidou.mybatisplus.enums.IdType;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * <p>
 * 融资
 * </p>
 *
 * @author jiangting
 * @since 2018-04-27
 */
@Data
@Accessors(chain = true)
@TableName("d_borrow")
public class Borrow implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 标ID
     */
    @TableId(value = "borrowID", type = IdType.AUTO)
    private Integer borrowID;

    /**
     * 用户ID
     */
    @TableField("userID")
    private Integer userID;

    /**
     * 手机号码
     */
    @TableField("phone")
    private String phone;

    /**
     * 单号可对接华兴
     */
    @TableField("orderNO")
    private String orderNO;

    /**
     * 华兴放款单号
     */
    @TableField("loanNO")
    private String loanNO;

    /**
     * 流标单号
     */
    @TableField("cancelNO")
    private String cancelNO;

    /**
     * 标编码
     */
    @TableField("borrowNO")
    private String borrowNO;

    /**
     * 融资人姓名 平台的用户
     */
    @TableField("realName")
    private String realName;

    /**
     * 华兴账号
     */
    @TableField("accNO")
    private String accNO;

    /**
     * 实际融资人用户ID,网贷之家专用
     */
    @TableField("borrowUserID")
    private Integer borrowUserID;

    /**
     * 1 平台保障 2 其他保障  5 担保公司
     */
    @TableField("projectType")
    private Integer projectType;

    /**
     * 担保方ID
     */
    @TableField("guaranteeID")
    private Integer guaranteeID;

    /**
     * 标类型 额度类型 70 净值标 80 秒标 90 理财标 100钱优选 200钱保通 300钱车宝 400钱主盈 500微信专享 600新手专享
     */
    @TableField("borrowType")
    private Integer borrowType;

    /**
     * 1 普通标 2 新手标
     */
    @TableField("activityType")
    private Integer activityType;

    /**
     * 标题
     */
    @TableField("borrowTitle")
    private String borrowTitle;

    /**
     * 标状态-1 删除 0 草稿 1 审核中  2 自动投标 3 发布中 4 满标 5 复审中  6 还款中 7 完成还款   9过期 10 撤销
     */
    @TableField("borrowStatus")
    private Integer borrowStatus;

    /**
     * 申请借款金额
     */
    @TableField("borrowMoney")
    private BigDecimal borrowMoney;

    /**
     * 实际借款金额
     */
    @TableField("realBorrowMoney")
    private BigDecimal realBorrowMoney;

    /**
     * 融资管理费
     */
    @TableField("borrowFees")
    private BigDecimal borrowFees;

    /**
     * 融资担保费
     */
    @TableField("guaFees")
    private BigDecimal guaFees;

    /**
     * 总收款
     */
    @TableField("totalReceipts")
    private BigDecimal totalReceipts;

    /**
     * 还款本金
     */
    @TableField("repaymentCapital")
    private BigDecimal repaymentCapital;

    /**
     * 还款利息
     */
    @TableField("repaymentInterest")
    private BigDecimal repaymentInterest;

    /**
     * 投标次数
     */
    @TableField("tendertimes")
    private Integer tendertimes;

    /**
     * 年利率
     */
    @TableField("borrowApr")
    private BigDecimal borrowApr;

    /**
     * 利息增值
     */
    @TableField("borrowAprSub")
    private BigDecimal borrowAprSub;

    /**
     * 默认0 vip用户不能加息 1 vip用户可以加息
     */
    @TableField("isVip")
    private Integer isVip;

    /**
     * 默认0 持劵用户不能加息 1 持券用户可以加息
     */
    @TableField("isTicket")
    private Integer isTicket;

    /**
     * 借款天数
     */
    @TableField("borrowDays")
    private Integer borrowDays;

    /**
     * 借款期数
     */
    @TableField("borrowLimit")
    private Integer borrowLimit;

    /**
     * 还款方式
     */
    @TableField("repaymentStyle")
    private Integer repaymentStyle;

    /**
     * 最小投标额
     */
    @TableField("minTender")
    private Integer minTender;

    /**
     * 最大投标额，默认应该是融资额
     */
    @TableField("maxTender")
    private Integer maxTender;

    /**
     * 有效期内的标的融资最迟结束时间
     */
    @TableField("endBorrowtime")
    private Integer endBorrowtime;

    /**
     * 发布时间也可以是预发布时间
     */
    @TableField("publishDatetime")
    private Integer publishDatetime;

    /**
     * 满标时间
     */
    @TableField("fullDatetime")
    private Integer fullDatetime;

    /**
     * 有效时间
     */
    @TableField("validTime")
    private Integer validTime;

    /**
     * 审核时间
     */
    @TableField("auditDatetime")
    private Integer auditDatetime;

    /**
     * 审核备注
     */
    @TableField("auditRemark")
    private String auditRemark;

    /**
     * 审核人ID
     */
    @TableField("auditUserID")
    private Integer auditUserID;

    /**
     * 复审时间
     */
    @TableField("reviewDatetime")
    private Integer reviewDatetime;

    /**
     * 复审说明
     */
    @TableField("reviewRemark")
    private String reviewRemark;

    /**
     * 复审人
     */
    @TableField("reviewUserID")
    private Integer reviewUserID;

    /**
     * 标密码
     */
    @TableField("borrowPassword")
    private String borrowPassword;

    @TableField("borrowRemark")
    private String borrowRemark;

    /**
     * 第三方返回内容
     */
    @TableField("returnContent")
    private String returnContent;

    /**
     * 创建时间
     */
    @TableField("addDatetime")
    private Integer addDatetime;

    /**
     * 修改时间
     */
    @TableField("editDatetime")
    private Integer editDatetime;

    /**
     * 操作终端 1 PC 2 安卓 3 IOS 4 微信
     */
    @TableField("terminal")
    private Integer terminal;

    /**
     * 操作IP
     */
    @TableField("operateIP")
    private String operateIP;

    /**
     * 自动还款授权华兴单号
     */
    @TableField("repayAuthNo")
    private String repayAuthNo;

    /**
     * 自动还款授权状态 0 未授权或者已取消授权  1 已授权
     */
    @TableField("repayAuthStatus")
    private Integer repayAuthStatus;

    /**
     * 资产评级  1较高  2适中 3较低
     */
    @TableField("assetRating")
    private Integer assetRating;


}

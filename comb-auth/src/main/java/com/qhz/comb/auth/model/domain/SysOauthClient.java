package com.qhz.comb.auth.model.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import com.baomidou.mybatisplus.enums.IdType;

import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * <p>
 * oauth客户端
 * </p>
 *
 * @author jiangting
 * @since 2018-05-28
 */
@Data
@Accessors(chain = true)
@TableName("d_sys_oauth_client")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SysOauthClient implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 客户端ID
     */
    @TableField("client_id")
    private String clientId;

    /**
     * 客户端密钥
     */
    @TableField("client_secret")
    private String clientSecret;

    /**
     * 授权范围集合(以英文逗号分隔)
     */
    @TableField("scopes")
    private String scopes;

    /**
     * 授权类型集合(以英文逗号分隔)
     */
    @TableField("authorized_grant_types")
    private String authorizedGrantTypes;

    /**
     * 资源ID集合(以英文逗号分隔)
     */
    @TableField("resource_ids")
    private String resourceIds;

    /**
     * 自动审批集合(以英文逗号分隔)
     */
    @TableField("auto_approves")
    private String autoApproves;

    /**
     * 重定向地址
     */
    @TableField("redirect_uri")
    private String redirectUri;

    /**
     * 访问令牌有效时长(单位：秒)
     */
    @TableField("access_token_validity")
    private Integer accessTokenValidity;

    /**
     * 刷新令牌有效时长(单位：秒)
     */
    @TableField("refresh_token_validity")
    private Integer refreshTokenValidity;

    /**
     * 附加信息
     */
    @TableField("additional_information")
    private String additionalInformation;

    /**
     * 是否启用
     */
    @TableField("enable")
    private Boolean enable;

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


}

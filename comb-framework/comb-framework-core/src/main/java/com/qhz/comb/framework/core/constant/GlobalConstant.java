package com.qhz.comb.framework.core.constant;

/**
 * 公共常量
 *
 * @author jiangting
 * @since 1.0, 2018/5/23
 */
public class GlobalConstant {

    public static final long FILE_MAX_SIZE = 5 * 1024 * 1024;
    public static final String UNKNOWN = "unknown";

    public static final String X_FORWARDED_FOR = "X-Forwarded-For";
    public static final String X_REAL_IP = "X-Real-IP";
    public static final String PROXY_CLIENT_IP = "Proxy-Client-IP";
    public static final String WL_PROXY_CLIENT_IP = "WL-Proxy-Client-IP";
    public static final String HTTP_CLIENT_IP = "HTTP_CLIENT_IP";
    public static final String HTTP_X_FORWARDED_FOR = "HTTP_X_FORWARDED_FOR";


    public static final String LOCALHOST_IP = "127.0.0.1";
    public static final String LOCALHOST_IP_16 = "0:0:0:0:0:0:0:1";
    public static final int MAX_IP_LENGTH = 15;

    public static final String DEV_PROFILE = "dev";
    public static final String TEST_PROFILE = "test";
    public static final String PRO_PROFILE = "pro";
    public static final int TWO_INT = 2;
    public static final int M_SIZE = 1024;

    public static final String ROOT_PREFIX = "comb_";

    public static final int EXCEPTION_CAUSE_MAX_LENGTH = 2048;
    public static final int EXCEPTION_MESSAGE_MAX_LENGTH = 2048;

    /**
     * 项目的license
     */
    public static final String QHZ_LICENSE = "made by qhz";

    /**
     * jwt签名
     */
    public static final String SIGN_KEY = "comb";

    /**
     * 删除
     */
    public static final String STATUS_DEL = "1";
    /**
     * 正常
     */
    public static final String STATUS_NORMAL = "0";

    /**
     * 锁定
     */
    public static final String STATUS_LOCK = "9";

    /**
     * sys_oauth_client_details 表的字段，不包括client_id、client_secret
     */
    public static final String CLIENT_FIELDS = "client_id, client_secret, resource_ids, scope, "
            + "authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, "
            + "refresh_token_validity, additional_information, autoapprove";

    /**
     *JdbcClientDetailsService 查询语句
     */
    public static final String BASE_FIND_STATEMENT = "select " + CLIENT_FIELDS
            + " from sys_oauth_client_details";

    /**
     * 默认的查询语句
     */
    public static final String DEFAULT_FIND_STATEMENT = BASE_FIND_STATEMENT + " order by client_id";

    /**
     * 按条件client_id 查询
     */
    public static final String DEFAULT_SELECT_STATEMENT = BASE_FIND_STATEMENT + " where client_id = ?";
}

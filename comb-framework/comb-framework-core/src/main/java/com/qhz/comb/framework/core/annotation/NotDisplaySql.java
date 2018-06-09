package com.qhz.comb.framework.core.annotation;


import java.lang.annotation.*;

/**
 * 配合 SqlLogInterceptor 对指定方法 禁止打印SQL到控制台
 *
 * @author jiangting
 * @since 1.0, 2018/4/24
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface NotDisplaySql {
}
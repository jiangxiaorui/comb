package com.qhz.comb.framework.core.exception;

/**
 * 403 授权拒绝
 *
 * @author jiangting
 * @since 1.0, 2018/5/29
 */
public class DeniedException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DeniedException() {
    }

    public DeniedException(String message) {
        super(message);
    }

    public DeniedException(Throwable cause) {
        super(cause);
    }

    public DeniedException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeniedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

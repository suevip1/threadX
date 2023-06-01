package com.threadx.metrics.server.common.code;

/**
 * 用户登录异常信息
 *
 * @author huangfukexing
 * @date 2023/6/1 09:22
 */
public enum LoginExceptionCode implements IExceptionCode{
    /**
     * 用户名或者密码错误
     */
    USER_NAME_OR_PASSWORD_ERROR("510000", "用户名或者密码错误！");
    ;

    ;
    /**
     * 错误吗
     */
    private final String code;

    /**
     * 错误信息
     */
    private final String message;

    LoginExceptionCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    ;

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

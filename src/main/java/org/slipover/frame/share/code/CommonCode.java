package org.slipover.frame.share.code;

/**
 * 通用code
 */
public enum CommonCode implements ServerCode {

    SUCCESS("C_200", "成功"),
    VERIFY_ERROR("C_400", "验证错误"),
    NO_ACCESS("C_403", "无权限"),
    ERROR("C_500", "错误"),
    EXCEPTION("C_502", "异常");

    private String code;

    private String message;

    CommonCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }

}

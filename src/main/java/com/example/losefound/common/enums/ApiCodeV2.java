package com.example.losefound.common.enums;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author: sunYue
 * @Date: 2021/2/23 14:29
 */
public enum ApiCodeV2 {
    //关键操作加锁 防止重复操作
    LOCKED_REQUEST("0005", "对不起，系统正在拼命处理中，请勿重复操作，谢谢"),
    SUCCESS("0000", "操作成功"),

    INPUT_ISNULL("1000", "输入参数为空，请检查输入参数"),
    SYSTEM_ERROR("1001", "系统存在未知异常"),
    SYSTEM_PARAM_ERROR("1002", "调用参数转换异常"),
    NOT_EXIT("1003", "操作数据不存在"),
    ALREADY_EXIT("1004", "添加数据已存在"),
    PAY_ERROR("1005", "支付失败，请联系管理员"),
    TRANSFER_ERROR("1006", "转账失败，请联系管理员"),
    ERROR_NOT_AUTH("1007", "无访问权限"),
    ERROR_HEADER("1008", "登录信息失效"),
    //    USER_INVALID_USERID("1009", "用户ID不存在"),
    USER_PASSWORD_ERROR("1010", "账号或密码错误"),
    INVALID_SMS_CODE_ERROR("1011", "无效的验证码"),
    USER_PAYPASSWORD_ERROR("1012", "密码错误"),
    PARAM_ERROR("1013", "输入参数错误"),
    SERVICE_DOWN("1014", "服务暂时不可用，请稍后再试"),
    USER_PASSWORD_ERROR_LIMIT("1015", "对不起，密码错误次数达到上限5次，为了保障您的账户安全，已锁定账户，建议您找回密码后再试"),
    SIGN_VERIFY_ERROR("1016", "验签失败"),

    ;

    private String code;
    private String msg;

    ApiCodeV2(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

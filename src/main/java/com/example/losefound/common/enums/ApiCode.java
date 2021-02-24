package com.example.losefound.common.enums;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author: sunYue
 * @Date: 2021/2/23 14:29
 */
public enum ApiCode {
    SUCCESS("0000", "操作成功"),
    SYSTEM_ERROR("1", "系统操作异常"),
    INPUT_ISNULL("2", "输入参数为空，请检查输入参数"),
    LOCKED_REQUEST("5", "对不起，系统正在拼命处理中，请勿重复操作，谢谢"),
    REQUEST_ERROR("7", "请求异常，网络异常，请检查管理员"),

    ;

    @Getter
    @Setter
    private String code;
    @Getter
    @Setter
    private String msg;

    private ApiCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}

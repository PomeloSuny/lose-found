package com.example.losefound.common.exception;

import com.example.losefound.common.enums.ApiCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by wann on 2018-3-26.
 */
public class ParamValidateException extends RuntimeException {
    @Getter
    @Setter
    private String code;
    @Getter
    @Setter
    private String msg;

    public ParamValidateException(Exception e) {
        super(e);
    }

    public ParamValidateException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private ParamValidateException() {
        this.code = code;
        this.msg = msg;
    }

    public static ParamValidateException paramError() {
        return setApiCode(ApiCode.SYSTEM_ERROR);
    }

    public static ParamValidateException paramNull() {
        return setApiCode(ApiCode.SYSTEM_ERROR);
    }

    public static ParamValidateException signError() {
        ParamValidateException exception = new ParamValidateException();
        return setApiCode(ApiCode.SYSTEM_ERROR);
    }

    public static ParamValidateException tokenExpired() {
        return setApiCode(ApiCode.SYSTEM_ERROR);
    }

    public static ParamValidateException tokenError() {
        return setApiCode(ApiCode.SYSTEM_ERROR);
    }


    public static ParamValidateException setApiCode(ApiCode code) {
        ParamValidateException exception = new ParamValidateException();
        exception.setCode(code.getCode());
        exception.setMsg(code.getMsg());
        return exception;
    }

}

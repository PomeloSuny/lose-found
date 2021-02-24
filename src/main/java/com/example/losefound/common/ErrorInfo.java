package com.example.losefound.common;

import com.example.losefound.common.enums.ApiCode;
import com.example.losefound.common.enums.ApiCodeV2;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Map;

/**
 * 数据封装，返回类型
 *
 * @Author: sunYue
 * @Date: 2021/2/23 14:27
 */
@Data
@Accessors(chain = true)
public class ErrorInfo<T> implements Serializable {

    public static final int REQUEST_OK = 0;
    public static final int REQUEST_ERROR = 1;

    public static final String SUCCESS = "success";
    public static final String FAIL = "fail";

    private String code;
    private String msg;
    private T data;
    private Map map;


    public ErrorInfo(String code, String msg, T data) {
        super();
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ErrorInfo(String code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }

    public ErrorInfo(T data) {
        super();
        this.data = data;
    }

    public ErrorInfo() {
        super();
    }

    public static ErrorInfo getSuccess() {
        return setApiCode(ApiCode.SUCCESS);
    }

    public static ErrorInfo inputIsNull() {
        return setApiCode(ApiCode.INPUT_ISNULL);

    }

    public static ErrorInfo inputIsNull(String err) {
        return setApiCode(ApiCode.INPUT_ISNULL).setMsg(err);

    }

    public static ErrorInfo getSystemError() {
        return setApiCode(ApiCode.SYSTEM_ERROR);
    }

    public static ErrorInfo getRequestError() {
        return setApiCode(ApiCode.REQUEST_ERROR);
    }

    public static boolean isSuccessInfo(ErrorInfo errorInfo) {
        if (ApiCode.SUCCESS.getCode().equals(errorInfo.getCode())) {
            return true;
        } else {
            return false;
        }
    }


    public static ErrorInfo setApiCode(ApiCode code) {
        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setCode(code.getCode() + "");
        errorInfo.setMsg(code.getMsg());
        return errorInfo;
    }

}

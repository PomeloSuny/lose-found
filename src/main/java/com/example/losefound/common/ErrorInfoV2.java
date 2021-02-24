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
public class ErrorInfoV2<T> implements Serializable {

    public static final int REQUEST_OK = 0;
    public static final int REQUEST_ERROR = 1;

    public static final String SUCCESS = "success";
    public static final String FAIL = "fail";

    private String code;
    private String msg;
    private T data;
    private Map map;


    public ErrorInfoV2(String code, String msg, T data,Map map) {
        super();
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.map = map;
    }

    public ErrorInfoV2(String code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }

    public ErrorInfoV2(T data) {
        super();
        this.data = data;
    }

    public ErrorInfoV2() {
        super();
    }


    public static ErrorInfoV2 getSuccess() {
        return setApiCode(ApiCodeV2.SUCCESS);
    }

    public static ErrorInfoV2 inputIsNull() {
        return setApiCode(ApiCodeV2.INPUT_ISNULL);

    }

    public static ErrorInfoV2 inputIsNull(String err) {
        return setApiCode(ApiCodeV2.INPUT_ISNULL).setMsg(err);

    }

    public static ErrorInfoV2 getSystemError() {
        return setApiCode(ApiCodeV2.SYSTEM_ERROR);
    }


    public static ErrorInfoV2 setApiCode(ApiCodeV2 code) {
        ErrorInfoV2 errorInfo = new ErrorInfoV2();
        errorInfo.setCode(code.getCode() + "");
        errorInfo.setMsg(code.getMsg());
        return errorInfo;
    }
    /*public static ErrorInfoV2 setApiCode(ApiCode code) {
        ErrorInfoV2 errorInfo = new ErrorInfoV2();
        errorInfo.setCode(code.getCode() + "");
        errorInfo.setMsg(code.getMsg());
        return errorInfo;
    }*/

    public static ErrorInfoV2 setApiCode(String code, String msg) {
        ErrorInfoV2 errorInfo = new ErrorInfoV2();
        errorInfo.setCode(code);
        errorInfo.setMsg(msg);
        return errorInfo;
    }

    public static boolean isSuccessInfo(ErrorInfoV2 errorInfo) {
        if (errorInfo != null && errorInfo.getCode() != null && "0000".equals(errorInfo.getCode())) {
            return true;
        }
        return false;
    }

    public static boolean isFailureInfo(ErrorInfoV2 errorInfo) {
        if (errorInfo != null && errorInfo.getCode() != null && "0000".equals(errorInfo.getCode())) {
            return false;
        }
        return true;
    }



    public ErrorInfoV2 isSuccess() {
        return setApiCode(ApiCodeV2.SUCCESS);
    }

}

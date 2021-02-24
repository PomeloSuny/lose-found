package com.example.losefound.common.exception;

import com.example.losefound.common.enums.ApiCode;
import lombok.Data;

/**
 * Created by wann on 2019-6-26.
 */
@Data
public class PayRiskException extends RuntimeException {


    private String code;
    private String msg;


    public PayRiskException(Exception e) {
        super(e);
    }

    public PayRiskException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    public static PayRiskException setApiCode(ApiCode code) {
        return new PayRiskException(code.getCode(), code.getMsg());
    }

}

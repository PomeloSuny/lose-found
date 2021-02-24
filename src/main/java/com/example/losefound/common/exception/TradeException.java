package com.example.losefound.common.exception;

/**
 * Created by IntelliJ IDEA.
 * User: yfliufei
 * Date: 15-5-25
 * Time: 下午2:37
 * To change this template use File | Settings | File Templates.
 */
public class TradeException extends RuntimeException {
    private String code;
    private String msg;
    private String money; //余额

    public TradeException(Exception e) {
        super(e);
    }

    public TradeException(String code, String msg, String money) {
        this.code = code;
        this.money=money;
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


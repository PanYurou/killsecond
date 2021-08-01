package com.pyr.result;

public class CodeMsg {
    private int code;
    private String message;

    public static CodeMsg SERVER_ERROR = new CodeMsg(500,"server error!");


    public CodeMsg(int code, String success) {
        this.code = code;
        this.message = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

package com.chx.config;

public class ConditionException extends RuntimeException{

    private static final long serivalVersionUID = 1L;
    private String code;
    /*public ConditionException(String code, String name){
        super(name);
        this.code = code;
    }


     */
    public ConditionException(String name){
        super(name);
        code = "500";
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
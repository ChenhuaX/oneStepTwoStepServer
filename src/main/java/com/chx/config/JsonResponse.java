package com.chx.config;
// 封装response
/*
    1. code ： 0 -- success
    2. code :  1 -- fail
*/
public class JsonResponse<T> {
    private String code;
    private String msg;
    private  T data;

    public JsonResponse(String code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public JsonResponse(T data){
        this.data = data;
        msg = "ok";
        code = "0";
    }

    public static JsonResponse<String> success(){
        return new JsonResponse<>(null);
    }
    public static JsonResponse<String> success(String data){
        return new JsonResponse<>(data);
    }
    public static JsonResponse<String> fail(){
        return new JsonResponse<>("1", "json fail");
    }
    public static JsonResponse<String> fail(String code, String msg){ return new JsonResponse<>(code, msg);}

}

package com.guli.commonutils;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class R {
    @ApiModelProperty(value = "是否成功")
    private boolean success;
    @ApiModelProperty(value = "状态码")
    private Integer code;
    @ApiModelProperty(value = "返回信息")
    private String message;
    @ApiModelProperty(value = "返回数据")
    private Map<String,Object> data=new HashMap<String,Object>();

    private R(){

    }
    public static R ok(){
        R r=new R();
        r.success=true;
        r.code=ResultCode.SUCCESS;
        r.message="成功";
        return r;
    }
    public static R error(){
        R r=new R();
        r.success=false;
        r.code=ResultCode.ERROR;
        r.message="失败";
        return r;
    }
    public R success(Boolean success){
        this.setSuccess(success);
        return this;
    }
    public R message(String message){
        this.setMessage(message);
        return this;
    }
    public R code(Integer code){
        this.setCode(code);
        return this;
    }
    public R data(String key, Object value){
        this.data.put(key, value);
        return this;
    }
    public R data(Map<String, Object> map){
        this.setData(map);
        return this;
    }
}

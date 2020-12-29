package com.loveraising.common;

import lombok.Data;


/**
 * @program: LoveRaising
 * @description:
 * @author: Guxinyu
 * @created: 2020/12/28 18:46
 */
@Data
public class TableResult <T>{
    /**
     * 总记录数
     */
    private Long count;
    /**
     * 列表数据
     */
    private T data;
    /**
     * 消息状态码
     */
    private Integer code;
    /**
     *信息
     * */
    private String msg;

    public TableResult() {
    }
    public TableResult(Integer code,String msg,long count, T data) {
        this.code=code;
        this.msg=msg;
        this.count=count;
        this.data=data;
    }
    public TableResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    /**
     * 当接口调用成功
     */
    public static <T>TableResult ResponseBySucess(String msg, Long count,T data){
        return new TableResult(0,msg,count,data);
    }
    /**
     * 接口调用失败
     */
    public static TableResult ResponseByFail(Integer code, String msg){
        return new TableResult(code,msg);
    }
    /**
     * 判断一个接口是否调用成功
     */
    public boolean isSucess(){
        return this.code==0;
    }

}

package org.imooc.constant;

public enum PageCodeEnum {

    ADD_SUCCESS(1 ,"新增成功!"),

    ADD_FAIL(2 ,"新增失败！"),

    ;

    private Integer code;
    private String msg;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public static final String KEY ="pageCode";

    PageCodeEnum(Integer code , String msg){
       this.code=code;
       this.msg=msg;
    }
}

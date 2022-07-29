package com.lh.kafka.enums;


import java.util.HashMap;
import java.util.Map;

/**
 * @author: ywx
 * @description
 * @Date: 2022/07/18
 */

public enum  StatusEnum {
    NORMAL(0, "正常"),
    DELETE(1, "无效");

    private Integer code;
    private String desc;
    private static Map<Integer, String> map = new HashMap<>();

    StatusEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    static {
        for (StatusEnum val : StatusEnum.values()) {
            map.put(val.getCode(), val.getDesc());
        }
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static String getDescByCode(Integer code) {
        return map.get(code);
    }
}

package com.misakimei.Jquests;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 18754 on 2016/10/23.
 */
public enum Status {
    OK(200),
    NOT_FIND(404),
    WRONG_CODE(-1);


    private static final Map<Integer, Status> intToTypeMap = new HashMap<>();

    static {
        for (Status type : Status.values()) {
            intToTypeMap.put(type.getCode(), type);
        }
    }


    private int code;

    Status(int code) {
        this.code = code;
    }

    public static Status valueOf(int responseCode) {
        Status s = intToTypeMap.get(responseCode);
        if (s != null) {
            return s;
        } else {
            return WRONG_CODE;
        }

    }

    public int getCode() {
        return code;
    }
}

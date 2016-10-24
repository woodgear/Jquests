package com.misakimei.Jquests.Header;

/**
 * Created by 18754 on 2016/10/24.
 */
class NormalHeader implements Header {
    private static final String format = "{%s : %s}";
    private String key;
    private String value;

    public NormalHeader(String key, String val) {
        this.key = key;
        this.value = val;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public String getVal() {
        return value;
    }

    @Override
    public String toString() {
        return String.format(format, getKey(), getVal());
    }
}

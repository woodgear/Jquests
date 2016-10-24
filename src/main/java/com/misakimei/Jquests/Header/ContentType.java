package com.misakimei.Jquests.Header;

/**
 * Created by 18754 on 2016/10/24.
 */
public enum ContentType implements Header {

    JSON("application/json"),
    HTML("text/html"),
    GIF("image/gif");


    private String type;

    ContentType(String v) {
        this.type = v;
    }

    @Override
    public String getKey() {
        return null;
    }

    @Override
    public String getVal() {
        return null;
    }
}

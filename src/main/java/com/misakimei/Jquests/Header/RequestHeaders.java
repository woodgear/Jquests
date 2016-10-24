package com.misakimei.Jquests.Header;

import com.misakimei.Jquests.Cookies;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 18754 on 2016/10/24.
 * 请求首部
 */
public class RequestHeaders extends Headers {

    private static final Pattern parser_head = Pattern.compile("([^:]*):\\s*([^\n]*)\n?");
    public Cookies cookies = new Cookies();


    public RequestHeaders() {
        super();
    }

    public RequestHeaders(String head) {
        of(head);
    }

    public Headers of(String head) {
        Matcher m = parser_head.matcher(head);
        while (m.find()) {
            add(m.group(1), m.group(2));
        }
        return this;
    }
}

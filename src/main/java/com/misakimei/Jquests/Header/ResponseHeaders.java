package com.misakimei.Jquests.Header;

import com.misakimei.Jquests.Cookies;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by 18754 on 2016/10/24.
 * 响应首部
 */
public class ResponseHeaders extends Headers {
    public Cookies cookies = new Cookies();

    public ResponseHeaders() {
        super();
    }

    public Headers of(Map<String, List<String>> headers) {
        ArrayList<Map.Entry<String, List<String>>> list = new ArrayList(headers.entrySet());
        for (Map.Entry<String, List<String>> e : list) {
            for (String s : e.getValue()) {
                add(e.getKey(), s);
            }
        }

        init();
        return this;
    }

    private void init() {
        this.cookies = Cookies.of(getHeaders("Set-Cookie"));
    }


}

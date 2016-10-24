package com.misakimei.Jquests;

import com.misakimei.Jquests.Header.Header;

import java.net.HttpCookie;
import java.util.*;

/**
 * Created by 18754 on 2016/10/23.
 */
public class Cookies implements Header {

    public static final String KEY = "Cookie";
    private HashMap<String, HttpCookie> map = new HashMap<>();

    public Cookies() {
    }

    public static Cookies of(List<Header> lis) {
        Cookies cookies = new Cookies();
        for (Header h : lis) {
            List<HttpCookie> cs = HttpCookie.parse(h.getVal());
            for (HttpCookie c : cs) {
                cookies.map.put(c.getName(), c);
            }
        }
        return cookies;
    }

    public Cookies add(String key, String v) {
        map.put(key, new HttpCookie(key, v));
        return this;
    }

    public HttpCookie get(String name) {
        return map.get(name);
    }

    @Override
    public String getKey() {
        return KEY;
    }

    @Override
    public String getVal() {
        StringJoiner sj = new StringJoiner(";");
        Iterator<Map.Entry<String, HttpCookie>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry e = it.next();
            sj.add(e.getValue().toString());
        }
        return sj.toString();
    }
}
